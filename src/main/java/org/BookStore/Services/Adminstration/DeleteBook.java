package org.BookStore.Services.Adminstration;

import org.BookStore.Books.Book;
import org.BookStore.Controllers.BookValidators;
import org.BookStore.Database.Books;
import org.BookStore.Database.dbconnection;
import org.BookStore.users.Roles;
import org.BookStore.users.currentuser;
import org.mockito.internal.matchers.Null;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.stream.Collectors;

public class DeleteBook {
    static dbconnection dbcon  = null;
    static Connection conn;

    public enum DeleteBookStatus{
        OK,
        FAIL,
        NOTFOUND,
        DBERROR
    }


    public static DeleteBookStatus DeleteCurrentBook(currentuser CurrentSession, int BookId,float AvgRev){

        if(!CurrentSession.IsManager())
        {
            return DeleteBookStatus.FAIL;
        }


        dbcon = dbconnection.getInstance();
        try {

            conn = dbcon.getConnection();
            String Query;
            if(BookId != 0)
                Query = Books.getDeleteBookById_Query();
            else
                Query = Books.getDeleteBookByAvgRev_Query();

            PreparedStatement ps = conn.prepareStatement(Query);

            if (BookId != 0)
                ps.setInt(1, BookId);
            else {
                System.out.println(AvgRev);
                ps.setFloat(1, AvgRev);
            }
            ps.executeUpdate();

            return DeleteBookStatus.OK;
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
            return DeleteBookStatus.DBERROR;
        }



    }
}
