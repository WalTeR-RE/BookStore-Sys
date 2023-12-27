package org.BookStore.Services;

import org.BookStore.users.currentuser;
import org.BookStore.Database.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.management.Query;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketService {

    static dbconnection dbcon = null;
    static Connection conn;
    public enum TicketStatus{
        OK,
        FAIL,
        SUMMARYORDESCTOOSHORT,
        DBERROR
    }

    private static int generateRandomTicketId(){
        Random rnd = new Random();
        return rnd.nextInt((int) Math.pow(10,5))+(int)Math.pow(10,5);
    }
    public static TicketStatus CreateTicket(currentuser CurrentSession,String Summary,String Desc) {
        if (Desc.length() < 5 || Summary.length() < 5)
            return TicketStatus.SUMMARYORDESCTOOSHORT;


        dbcon = dbconnection.getInstance();
        try {
            conn = dbcon.getConnection();
            String Query = TicketSystem.getCreateTicket_Query();

            PreparedStatement preparedStatement = conn.prepareStatement(Query);
            preparedStatement.setInt(1, generateRandomTicketId());
            preparedStatement.setString(2, CurrentSession.getUuid());
            preparedStatement.setString(3, CurrentSession.getName());
            preparedStatement.setString(4, Summary);
            preparedStatement.setString(5, Desc);
            preparedStatement.setString(6, "NEW");
            preparedStatement.setString(7, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY")));

            int res = preparedStatement.executeUpdate();
            if (res == 0)
                return TicketStatus.FAIL;

            return TicketStatus.OK;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
            return TicketStatus.DBERROR;
        } finally {
            if (dbcon != null)
                dbcon.closeConnection(conn);
        }
    }

}
