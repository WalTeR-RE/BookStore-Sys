/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.BookStore.Database;
import java.sql.*;
public class Reviews{
    public static String getBookReviews(){
         return "SELECT * FROM reviewsrecord WHERE BookId =? ";
       
    }
    public static String SetReview(){
        return "INSERT INTO reviewsrecord(Description,Stars,RevName,Revuuid,BookId) VALUES  (?,?,?,?,?) ";
        
    }
    public static String setAvgRev(){
        
      return "UPDATE sysbooksrecord SET AvgRev= ? where BookId = ?";
    }
    public static String getReviewCount(){
        return "SELECT * FROM reviewsrecord WHERE BookId = ? AND Revuuid = ?";
    }
    public static String editReview(){
        return "UPDATE reviewsrecord SET Stars = ? ,Description = ? WHERE Revuuid = ? AND BookId = ? ";
    }
    public static String deleteReview(){
        return "DELETE FROM reviewsrecord WHERE Revuuid = ? AND BookId= ?";
    }
    
    
    
    
    
    
    
    
    
    
};


    
    
    
    

    

