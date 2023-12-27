package org.BookStore.Services;
import org.BookStore.Books.*;
import org.BookStore.Database.*;
import org.BookStore.Services.Adminstration.AdminServices;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.sql.SQLException;

public class Loader {

    static dbconnection dbcon = null;
    static Connection conn;
    public static void LoadBooks(){

        dbcon = dbconnection.getInstance();
        try {
            conn = dbcon.getConnection();

            String Query = Books.getAllBooks_Query();
            PreparedStatement book_statement = conn.prepareStatement(Query);
            ResultSet rs = book_statement.executeQuery();
            List<Book> List = new ArrayList<>();

            while(rs.next())
            {
                Book temp = new Book();
                temp.setBookId(rs.getInt("BookId"));
                temp.setAuthor(rs.getString("Author"));
                temp.setTitle(rs.getString("Title"));
                temp.setDescription(rs.getString("Description"));
                temp.setCoverimg(rs.getString("CoverImg"));
                temp.setPrice(rs.getInt("Price"));
                temp.setQuantity(rs.getInt("Quantity"));
                temp.setAvgrev(rs.getFloat("AvgRev"));
                String[] Category = rs.getString("Category").split(",");
                List<String> Categories = new ArrayList<>();
                for(String cat : Category)
                    Categories.add(cat.trim());
                temp.setCategory(Categories);
                List.add(temp);
            }
            Book.setListOfBooks(List);

        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
        }
    }
    public static void LoadBooksCategory(){
        dbcon = dbconnection.getInstance();
        try{
            conn = dbcon.getConnection();
            String Query = Books.getAllBookCategory_Query();
            List<String> List = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(Query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                List.add(rs.getString("Category"));
            }

            Book.setListOfBookCategory(List);
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
        }
    }
    public static void LoadUsers(){
        dbcon = dbconnection.getInstance();
        try{
            conn = dbcon.getConnection();
            String Query = Adminstration.getListOfUsers_Query();
            List<String> List = new ArrayList<>();
            List<String> List2 = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(Query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getInt("Online") == 1)
                    List.add(rs.getString("Name"));
                else
                    List2.add(rs.getString("Name"));
            }

            AdminServices.setListOfOnlineUsers(List);
            AdminServices.setListOfOfflineUsers(List2);
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
        }
    }
}
