package org.BookStore.Services;
import org.BookStore.Database.*;
import org.BookStore.users.currentuser;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PointsService {

    static dbconnection dbcon = null;
    static Connection conn;
    public static void AddPoints(currentuser CurrentSession,int Points){
        dbcon = dbconnection.getInstance();
        try{
            conn = dbcon.getConnection();
            String Query = PointsSystem.getAddUserPoints_Query();

            PreparedStatement statement = conn.prepareStatement(Query);
            int NewPoints = CurrentSession.getPoints()+Points;
            statement.setInt(1,NewPoints);
            statement.setString(2,CurrentSession.getUuid());

            int result = statement.executeUpdate();
            if(result == 1)
            {
                CurrentSession.setPoints(NewPoints);
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
        }
        finally {
            if(dbcon!= null)
                dbcon.closeConnection(conn);
        }

    }
}
