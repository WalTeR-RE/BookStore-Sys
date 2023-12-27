package org.BookStore.Services;
import org.BookStore.Database.*;
import org.BookStore.users.currentuser;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class VouchersService {
    public enum VOUCHER_STATE{
        OK,
        FAIL,
        EXPIRED,
        MAXUSAGE,
        USERALREADYUSEDIT,
        DBERROR
    }
    static dbconnection dbcon = null;
    static Connection conn;

    private static int Discount;

    public static int getDiscount() {
        return Discount;
    }

    public static void setDiscount(int discount) {
        Discount = discount;
    }
    public static boolean ValidVoucher(String Voucher){

        dbcon = dbconnection.getInstance();
        try{
            conn = dbcon.getConnection();
            String Query = VouchersSystem.getSpecificVouchersList_Query();
            PreparedStatement ps = conn.prepareStatement(Query);
            ps.setString(1,Voucher);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                int Disc = rs.getInt("DiscountPercentage");
                setDiscount(Disc);
                return true;
            }
            else return false;
        }
        catch (SQLException ex)
        {
            return false;
        }
        finally {
            if(dbcon!=null)
                dbcon.closeConnection(conn);
        }

    }

    public static VOUCHER_STATE UseVoucher(currentuser CurrentSession, String Voucher){

        dbcon = dbconnection.getInstance();
        try{
            conn = dbcon.getConnection();
            String Query = VouchersSystem.getVouchersList_Query();
            String Query2 = VouchersSystem.getUseVoucher_Query();
            String Query3 = VouchersSystem.getUpdateVoucher_Query();
            String Query4 = VouchersSystem.getUserUsedVoucher_Query();
            PreparedStatement statement = conn.prepareStatement(Query);
            ResultSet rs = statement.executeQuery();
            Boolean found = false;
            int voc_id=0;
            int counter=0;
            int used_counter=0;
            String expire_date="";
            int Discount=0;
            while (rs.next()){
                if(rs.getString("voucher").equals(Voucher)) {
                    voc_id = rs.getInt("voucherid");
                    used_counter = rs.getInt("UsedCount");
                    counter = rs.getInt("counter");
                    expire_date = rs.getString("expiredate");
                    Discount = rs.getInt("DiscountPercentage");
                    found = true;
                }
            }

            if(!found)
                return VOUCHER_STATE.FAIL;

            if(used_counter>=counter)
                return VOUCHER_STATE.MAXUSAGE;


            int comp_result=0;
            String to_compare = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
            try{
                SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
                Date d1 = formater.parse(expire_date);
                Date d2 = formater.parse(to_compare);
                comp_result = d1.compareTo(d2);
            }
            catch (ParseException ex)
            {
                JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
                return VOUCHER_STATE.FAIL;
            }
            if(comp_result<0) // if current date is after expire date
            {
                return VOUCHER_STATE.EXPIRED;
            }

            PreparedStatement statement4 = conn.prepareStatement(Query4);
            statement4.setString(1,CurrentSession.getUuid());
            statement4.setInt(2,voc_id);
            ResultSet res = statement4.executeQuery();
            if(res.next())
                return VOUCHER_STATE.USERALREADYUSEDIT;


            PreparedStatement statement1 = conn.prepareStatement(Query2);
            statement1.setInt(1,voc_id);
            statement1.setString(2, CurrentSession.getUuid());
            statement1.setString(3,CurrentSession.getName());
            statement1.setString(4, to_compare);


            int result = statement1.executeUpdate();
            if(result==0)
                return VOUCHER_STATE.FAIL;

            PreparedStatement statement2 = conn.prepareStatement(Query3);
            statement2.setInt(1,(used_counter+1));
            statement2.setInt(2,voc_id);

            int result2 = statement2.executeUpdate();
            if(result2 == 0)
                return VOUCHER_STATE.FAIL;

            setDiscount(Discount);
            return VOUCHER_STATE.OK;
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
            return VOUCHER_STATE.DBERROR;
        }
        finally {
            if(dbcon!= null)
                dbcon.closeConnection(conn);
        }


    }






}
