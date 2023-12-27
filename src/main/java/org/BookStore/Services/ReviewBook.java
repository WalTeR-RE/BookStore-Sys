package org.BookStore.Services;

import java.sql.*;
import javax.swing.JOptionPane;
import org.BookStore.Database.dbconnection;
import org.BookStore.Database.Books;
import org.BookStore.Database.Reviews;
import org.BookStore.users.Roles;
import org.BookStore.users.currentuser;

public class ReviewBook {


    public static float getAverageReview(int BookId) {
        Connection con;
        PreparedStatement pst;

        try {
            con = dbconnection.getInstance().getConnection();
            pst = con.prepareStatement(Reviews.getBookReviews());
            pst.setInt(1, BookId);
            ResultSet res = pst.executeQuery();
            boolean isEmpty = true;
            float counter = 0;
            float sum = 0;
            while (res.next()) {
                isEmpty = false;
                counter++;
                sum += res.getInt("Stars");

            }
            if (isEmpty) {
                JOptionPane.showMessageDialog(null, "This Book wasn't rated before");
                return 0;
            } else {

                return sum / counter;

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error with the DB connection");
            return -1;
        }

    }

    public enum Status {
       INVALID_STARS, SUCCESS, DB_ERROR,ALREADY_REVIEWED,ACCESS_DENIED;

    }

    public static Status writeReview(currentuser user , String des, int stars, int bookId) {
        Connection con;
        PreparedStatement pst;
        PreparedStatement pst2;
        PreparedStatement pst3 ;
        if (stars > 5 || stars < 1) {
            JOptionPane.showMessageDialog(null, "Invalid stars selected");
            return Status.INVALID_STARS;
        }
        try {
            con = dbconnection.getInstance().getConnection();
            pst = con.prepareStatement(Reviews.SetReview());
            pst.setString(1, des);
            pst.setInt(2, stars);
            pst.setString(3,user.getName());
            pst.setString(4,user.getUuid());
            pst.setInt(5, bookId);
            pst3 = con.prepareStatement(Reviews.getReviewCount());
            pst3.setInt(1,bookId);
            pst3.setString(2, user.getUuid());
            ResultSet res = pst3.executeQuery();
            if (res.next()){
                return Status.ALREADY_REVIEWED;
                
            }
            pst.executeUpdate();
            pst2 = con.prepareStatement(Reviews.setAvgRev());
            pst2.setFloat(1, ReviewBook.getAverageReview(bookId));
            pst2.setInt(2, bookId);
            pst2.executeUpdate();
            return Status.SUCCESS;
        } catch (SQLException e) {
            System.out.println(e);
            return Status.DB_ERROR;

        }

    }
    public static Status deleteReview(currentuser user,String uuid ,int bookId ){
        Connection con;
        PreparedStatement pst ;
        if (!user.IsAdmin()){
            
         return Status.ACCESS_DENIED;   
        }
        
        
        try{
           con = dbconnection.getInstance().getConnection();
           pst = con.prepareStatement(Reviews.deleteReview());
           pst.setString(1,uuid);
           pst.setInt(2,bookId);
           pst.executeUpdate();
           PreparedStatement pst2 = con.prepareStatement(Reviews.setAvgRev());
           pst2.setFloat(1, ReviewBook.getAverageReview(bookId));
           pst2.setInt(2, bookId);
           pst2.executeUpdate();
           return Status.SUCCESS; 
        }catch(SQLException e){
            return Status.DB_ERROR;
        }
        
        
        
    }
    public static Status editReview(currentuser user ,String uuid, int bookId , String des, int stars){
        if (stars>5||stars<0){
            return Status.INVALID_STARS;
        }
        if (!user.IsAdmin()){
            return Status.ACCESS_DENIED;
        }
        Connection con ; 
        PreparedStatement pst ;
        try {
            con = dbconnection.getInstance().getConnection();
            pst = con.prepareStatement(Reviews.editReview());
            pst.setInt(1,stars);
            pst.setString(2, des);
            pst.setString(3, uuid);
            pst.setInt(4, bookId);
            pst.executeUpdate();
            PreparedStatement pst2 = con.prepareStatement(Reviews.setAvgRev());
            pst2.setFloat(1, ReviewBook.getAverageReview(bookId));
            pst2.setInt(2, bookId);
            pst2.executeUpdate();
            return Status.SUCCESS; 
   
        }catch(SQLException e){
            return Status.DB_ERROR;
        }
        
        
        
        
        
        
        
    }

}
