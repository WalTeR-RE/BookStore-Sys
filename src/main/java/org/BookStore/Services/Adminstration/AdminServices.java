package org.BookStore.Services.Adminstration;
import org.BookStore.users.*;
import org.BookStore.Database.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class AdminServices {


    public enum BanStatus{
        OK,
        FAIL,
        USERNOTFOUND,
        ALREADYBANNED,
        DBERROR
    }
    public enum BanType{
        BAN_ACCOUNT(100),
        BAN_CHAT(105);
        private final int val;
        BanType(int i) {
            this.val=i;
        }
        public int getValue(){
            return this.val;
        }
    }

    static dbconnection dbcon= null;
    static Connection conn;

    public static BanStatus BanUser(currentuser CurrentSession,String Email,String Phonenumber,String Active,String Reason){
        if(!CurrentSession.IsAdmin())
            return BanStatus.FAIL;

        boolean ByEmail = true;
        String Query,Query2;
        if(!Email.equals(""))
            ByEmail = true;
        else
            ByEmail = false;

        try{
            dbcon = dbconnection.getInstance();
            conn = dbcon.getConnection();
            if(ByEmail){
                Query = Adminstration.getBanUnBanUserByEmail_Query(); Query2 = Adminstration.getRecordBanByEmail_Query();}
            else{
                Query = Adminstration.getBanUnBanUserByPhonenumber_Query(); Query2 = Adminstration.getRecordBanByPhonenumber_Query();}

            PreparedStatement BanStatement = conn.prepareStatement(Query);
            PreparedStatement RecordStatement = conn.prepareStatement(Query2);

            BanStatement.setString(1,Active);
            if(ByEmail) {
                BanStatement.setString(2, Email);
                RecordStatement.setString(1,Email);
                RecordStatement.setString(2,Email);
            }
            else {
                BanStatement.setString(2, Phonenumber);
                RecordStatement.setString(1,Phonenumber);
                RecordStatement.setString(2,Phonenumber);
            }

            RecordStatement.setString(3,CurrentSession.getName());
            RecordStatement.setString(4,CurrentSession.getUuid());
            RecordStatement.setString(5,Reason);
            RecordStatement.setString(6,String.valueOf(BanType.BAN_ACCOUNT.getValue()));
            int result = BanStatement.executeUpdate();
            if(Active=="0")
                RecordStatement.executeUpdate();

            if(result==0)
                return BanStatus.USERNOTFOUND;
            else
                return BanStatus.OK;

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
            return BanStatus.DBERROR;
        }
        finally {
            if(dbcon!=null)
                dbcon.closeConnection(conn);
        }

    }
    private static List<String> ListOfOnlineUsers;
    private static List<String> ListOfOfflineUsers;

    public static List<String> getListOfOfflineUsers() {
        return ListOfOfflineUsers;
    }

    public static void setListOfOfflineUsers(List<String> listOfOfflineUsers) {
        ListOfOfflineUsers = listOfOfflineUsers;
    }

    public static List<String> getListOfOnlineUsers() {
        return ListOfOnlineUsers;
    }

    public static void setListOfOnlineUsers(List<String> listOfOnlineUsers) {
        ListOfOnlineUsers = listOfOnlineUsers;
    }

    public static BanStatus BanUserChat(currentuser CurrentSession, String Email, String Phonenumber, String Active, String Reason){
        if(!CurrentSession.IsAdmin())
            return BanStatus.FAIL;

        boolean ByEmail = true;
        String Query,Query2;
        if(!Email.equals(""))
            ByEmail = true;
        else
            ByEmail = false;

        try{
            dbcon = dbconnection.getInstance();
            conn = dbcon.getConnection();
            if(ByEmail){
                Query = Adminstration.getBanUnBanUserChatByEmail_Query(); Query2 = Adminstration.getRecordBanByEmail_Query();}
            else{
                Query = Adminstration.getBanUnBanUserChatByPhonenumber_Query(); Query2 = Adminstration.getRecordBanByPhonenumber_Query();}

            PreparedStatement BanStatement = conn.prepareStatement(Query);
            PreparedStatement RecordStatement = conn.prepareStatement(Query2);

            BanStatement.setString(1,Active);
            if(ByEmail) {
                BanStatement.setString(2, Email);
                RecordStatement.setString(1,Email);
                RecordStatement.setString(2,Email);
            }
            else {
                BanStatement.setString(2, Phonenumber);
                RecordStatement.setString(1,Phonenumber);
                RecordStatement.setString(2,Phonenumber);
            }

            RecordStatement.setString(3,CurrentSession.getName());
            RecordStatement.setString(4,CurrentSession.getUuid());
            RecordStatement.setString(5,Reason);
            RecordStatement.setString(6,String.valueOf(BanType.BAN_CHAT.getValue()));

            int result = BanStatement.executeUpdate();
            if(Active=="1")
                RecordStatement.executeUpdate();

            if(result==0)
                return BanStatus.USERNOTFOUND;
            else
                return BanStatus.OK;

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
            return BanStatus.DBERROR;
        }
        finally {
            if(dbcon!=null)
                dbcon.closeConnection(conn);
        }

    }
}
