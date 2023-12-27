package org.BookStore.Services.Adminstration;
import org.BookStore.Books.Book;
import org.BookStore.Controllers.validators;
import org.BookStore.Database.Books;
import org.BookStore.Database.dbconnection;
import org.BookStore.Controllers.BookValidators;
import org.BookStore.users.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AddBook {
    static dbconnection dbcon  = null;
    static Connection conn;

    public enum AddBookStatus{
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


    private static AddBookStatus validateBook(Book book) {
        BookValidators serializer = new BookValidators();
        if (book == null) {
            return AddBookStatus.FAIL;
        }

        if (!serializer.isValidAuthor(book.getAuthor())) {
            return AddBookStatus.INVALIDAUTHOR;
        }

        if (!serializer.isValidTitle(book.getTitle())) {
            return AddBookStatus.INVALIDTITLE;
        }

        if (!serializer.isValidCoverImg(book.getCoverimg())) {
            return AddBookStatus.INVALIDCOVERIMG;
        }

        if (!serializer.isValidCategory(book.getCategory())) {
            return AddBookStatus.INVALIDCATEGORY;
        }

        if (!serializer.isValidDescription(book.getDescription())) {
            return AddBookStatus.INVALIDDESC;
        }

        if (!serializer.isValidPrice(book.getPrice())) {
            return AddBookStatus.INVALIDPRICE;
        }

        if (!serializer.isValidQuantity(book.getQuantity())) {
            return AddBookStatus.INVALIDQUANT;
        }

        if (!serializer.isValidAvgRev(book.getAvgrev())) {
            return AddBookStatus.INVALIDAVGREV;
        }

        return AddBookStatus.OK;
    }

    public static AddBookStatus AddNewBook(currentuser CurrentSession,String Author, String Title, List<String> Category,String Desc,String CoverImg,int Price,int Quantity,float AvgRev){
        if(!CurrentSession.IsManager())
        {
            return AddBookStatus.FAIL;
        }

        Book book = new Book();
        book.setBookId(Book.getListOfBooks().getLast().getBookId()+1);
        book.setAuthor(Author);
        book.setTitle(Title);
        book.setCategory(Category);
        book.setDescription(Desc);
        book.setCoverimg(CoverImg);
        book.setPrice(Price);
        book.setQuantity(Quantity);
        book.setAvgrev(AvgRev);
        AddBookStatus status = validateBook(book);

        if(status!= AddBookStatus.OK)
            return status;

        dbcon = dbconnection.getInstance();
        try {

            conn = dbcon.getConnection();
            String Query = Books.getAddNewBook_Query();
            PreparedStatement ps = conn.prepareStatement(Query);
            ps.setInt(1,book.getBookId());
            ps.setString(2,book.getAuthor());
            ps.setString(3,book.getTitle());
            ps.setString(4,book.getCategory().stream().map(Object::toString).collect(Collectors.joining(", ")));
            ps.setString(5,book.getDescription());
            ps.setString(6,book.getCoverimg());
            ps.setInt(7,book.getPrice());
            ps.setInt(8,book.getQuantity());
            ps.setFloat(9,book.getAvgrev());
            ps.executeUpdate();

            return AddBookStatus.OK;
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
            return AddBookStatus.DBERROR;
        }



    }
}
