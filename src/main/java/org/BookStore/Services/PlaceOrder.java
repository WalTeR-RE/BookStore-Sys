package org.BookStore.Services;

import org.BookStore.Books.Book;
import org.BookStore.Database.dbconnection;
import org.BookStore.Database.Books;
import org.BookStore.Services.PointsService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Queue;
import org.BookStore.users.currentuser;

import javax.swing.*;


public class PlaceOrder {
    public enum OrderStatus{
        OK,
        FAIL,
        QUANTITYERR,
        VOUCHERNOTVALID,
        VOUCHEREXPIRED,
        USERALREADYUSEDITONCE,
        DBERROR
    }

    static dbconnection dbcon  = null;
    static Connection conn;

    public static boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean validateValues(
            String uuid,
            String name,
            String phoneNumber,
            String address,
            String country,
            Integer quantity,
            Integer bookId,
            String date
    ) {
        return isNullOrBlank(uuid) ||
                isNullOrBlank(name) ||
                isNullOrBlank(phoneNumber) ||
                isNullOrBlank(address) ||
                isNullOrBlank(country) ||
                quantity == null ||
                bookId == null ||
                isNullOrBlank(date);
    }
    public static OrderStatus Placeorder(currentuser CurrentSession,String Address,String Country,int Quantity,int BookId,String Date,int Price,String Voucher) {
        if (validateValues(CurrentSession.getUuid(), CurrentSession.getName(), CurrentSession.getPhonenumber(), Address, Country, Quantity, BookId, Date))
            return OrderStatus.FAIL;
        if (Quantity < 1)
            return OrderStatus.QUANTITYERR;
        else if (Book.getListOfBooks().stream().noneMatch(book -> book.getBookId() == BookId))
            return OrderStatus.FAIL;

        int currentquan = Objects.requireNonNull(Book.getBookById(BookId)).getQuantity();


        if(currentquan-Quantity < 0)
            return OrderStatus.QUANTITYERR;
        dbcon = dbconnection.getInstance();
        try {
            conn = dbcon.getConnection();
            String Query1 = Books.getPutBookOrderQuery();
            String Query2 = Books.getPutPurchaseHistory_Query();
            String Query3 = Books.getUpdateQuantity_Query();
            VouchersService.VOUCHER_STATE voucher_state = VouchersService.VOUCHER_STATE.OK;
            if(!isNullOrBlank(Voucher))
                voucher_state = VouchersService.UseVoucher(CurrentSession,Voucher);


            if(voucher_state == VouchersService.VOUCHER_STATE.OK) {
                Price -= (int)(Price*((float)VouchersService.getDiscount()/100));
            }
            else if(voucher_state == VouchersService.VOUCHER_STATE.FAIL)
                return OrderStatus.VOUCHERNOTVALID;
            else if(voucher_state == VouchersService.VOUCHER_STATE.EXPIRED||voucher_state== VouchersService.VOUCHER_STATE.MAXUSAGE)
                return OrderStatus.VOUCHEREXPIRED;
            else if(voucher_state==VouchersService.VOUCHER_STATE.USERALREADYUSEDIT)
                return OrderStatus.USERALREADYUSEDITONCE;

            PreparedStatement putorder_statement = conn.prepareStatement(Query1);
            PreparedStatement purchasehistroy_statement = conn.prepareStatement(Query2);
            PreparedStatement updatequant = conn.prepareStatement(Query3);
            putorder_statement.setString(1, CurrentSession.getUuid());
            putorder_statement.setString(2, CurrentSession.getName());
            putorder_statement.setString(3, CurrentSession.getPhonenumber());
            putorder_statement.setString(4, Address);
            putorder_statement.setString(5, Country);
            putorder_statement.setInt(6, Quantity);
            putorder_statement.setInt(7, BookId);
            putorder_statement.setString(8, Date);
            int result = putorder_statement.executeUpdate();

            if (result == 0)
                return OrderStatus.FAIL;



            purchasehistroy_statement.setString(1, CurrentSession.getUuid());
            purchasehistroy_statement.setInt(2, (Price*Quantity));
            purchasehistroy_statement.setString(3, Date);



            int result2 = purchasehistroy_statement.executeUpdate();

            if (result2 == 0)
                return OrderStatus.FAIL;

            updatequant.setInt(1,(currentquan-Quantity));
            updatequant.setInt(2,BookId);
            int res = updatequant.executeUpdate();

            if(res==0)
                return OrderStatus.FAIL;

            PointsService.AddPoints(CurrentSession,(Price*Quantity));
            VouchersService.setDiscount(0);
            return OrderStatus.OK;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
            return OrderStatus.DBERROR;
        } finally {
            if (dbcon != null)
                dbcon.closeConnection(conn);
        }

    }


}
