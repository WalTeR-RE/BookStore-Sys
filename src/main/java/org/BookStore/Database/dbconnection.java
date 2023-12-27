package org.BookStore.Database;

import javax.swing.*;
import java.sql.*;

public class dbconnection {
    public void TestDbConnection(){
        Connection conn = null;
        try{
            String url = System.getenv("DB_URL");
            String username = System.getenv("DB_USERNAME");
            String password = System.getenv("DB_PASSWORD");
            if (url == null || username == null || password == null) {
                throw new RuntimeException("db environment variables not set");
            }
            conn = DriverManager.getConnection(url,username,password);
            conn.close();
            System.out.println("Connected to the database!");
        }catch (SQLException e)
        {
            System.out.println("Failed To Connect To the database");
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
        }
    }
    private static volatile dbconnection instance;
    private dbconnection() {}
    public static dbconnection getInstance() {
        if (instance == null) {
            synchronized (dbconnection.class) {
                if (instance == null) {
                    instance = new dbconnection();
                }
            }
        }
        return instance;
    }
    public synchronized Connection getConnection() throws SQLException{
        String url = System.getenv("DB_URL");
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");
        if (url == null || username == null || password == null) {
            throw new RuntimeException("db environment variables not set");
        }
        return DriverManager.getConnection(url,username,password);
    }
    public synchronized void  closeConnection(Connection conn){
        try {
            if(conn!=null&&!conn.isClosed())
                conn.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
        }

    }
}
