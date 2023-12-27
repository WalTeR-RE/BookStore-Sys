package org.BookStore.Services.Adminstration;
import org.BookStore.Books.Book;
import org.BookStore.Controllers.validators;
import org.BookStore.Database.Books;
import org.BookStore.Database.dbconnection;
import org.BookStore.Controllers.BookValidators;
import org.BookStore.users.Roles;
import org.BookStore.users.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.stream.Collectors;


public class UpdateBook {
    static dbconnection dbcon  = null;
    static Connection conn;

    public enum UpdateBookStatus{
        OK,
        FAIL,
        INVALIDAUTHOR,
        INVALIDTITLE,
        INVALIDCOVERIMG,
        INVALIDCATEGORY,
        INVALIDDESC,
        INVALIDPRICE,
        INVALIDQUANT,
        INVALIDAVGREV,
        DBERROR
    }


    private static UpdateBookStatus validateBook(Book book) {
        BookValidators serializer = new BookValidators();
        if (book == null) {
            return UpdateBookStatus.FAIL;
        }

        if (!serializer.isValidAuthor(book.getAuthor())) {
            return UpdateBookStatus.INVALIDAUTHOR;
        }

        if (!serializer.isValidTitle(book.getTitle())) {
            return UpdateBookStatus.INVALIDTITLE;
        }

        if (!serializer.isValidCoverImg(book.getCoverimg())) {
            return UpdateBookStatus.INVALIDCOVERIMG;
        }

        if (!serializer.isValidCategory(book.getCategory())) {
            return UpdateBookStatus.INVALIDCATEGORY;
        }

        if (!serializer.isValidDescription(book.getDescription())) {
            return UpdateBookStatus.INVALIDDESC;
        }

        if (!serializer.isValidPrice(book.getPrice())) {
            return UpdateBookStatus.INVALIDPRICE;
        }

        if (!serializer.isValidQuantity(book.getQuantity())) {
            return UpdateBookStatus.INVALIDQUANT;
        }

        if (!serializer.isValidAvgRev(book.getAvgrev())) {
            return UpdateBookStatus.INVALIDAVGREV;
        }

        return UpdateBookStatus.OK;
    }

    public static UpdateBookStatus UpdateBook(currentuser CurrentSession,Book book){

        if(CurrentSession.IsManager())
        {
            return UpdateBookStatus.FAIL;
        }
        UpdateBookStatus status = validateBook(book);

        if(status!= UpdateBookStatus.OK)
            return status;

        dbcon = dbconnection.getInstance();
        try {

            conn = dbcon.getConnection();
            String Query = Books.getUpdateBookAttributes_Query();
            PreparedStatement ps = conn.prepareStatement(Query);
            ps.setString(1,book.getAuthor());
            ps.setString(2,book.getTitle());
            String Category = book.getCategory().stream().map(Objects::toString).collect(Collectors.joining(", "));
            ps.setString(3,Category);
            ps.setString(4,book.getDescription());
            ps.setString(5,book.getCoverimg());
            ps.setInt(6,book.getPrice());
            ps.setInt(7,book.getQuantity());
            ps.setFloat(8,book.getAvgrev());
            ps.setInt(9,book.getBookId());
            ps.executeUpdate();

            return UpdateBookStatus.OK;
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");
            return UpdateBookStatus.DBERROR;
        }



    }

}
