package org.BookStore.Authentication;

import org.BookStore.Cryptography.*;
import org.BookStore.Database.*;
import org.BookStore.Services.Loader;
import org.BookStore.users.*;


import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public enum AuthenticationStatus{
        OK,
        FAIL,
        NOCREDS,
        NOPASSWORD,
        NOEMAILNORPASSWORD,
        LOCKED,
        DBERROR
    }

    static Connection conn=null;
    static dbconnection dbcon=null;
    public static AuthenticationStatus Authenticate(String username, String password, String email) {

        if (username.isEmpty() && email.isEmpty() && password.isEmpty())
            return AuthenticationStatus.NOCREDS;

        if (username.isEmpty() && email.isEmpty())
            return AuthenticationStatus.NOEMAILNORPASSWORD;

        if (password.isEmpty())
            return AuthenticationStatus.NOPASSWORD;

        dbconnection dbcon = null;
        Connection conn = null;

        try {
            dbcon = dbconnection.getInstance();
            conn = dbcon.getConnection();
            String Query = Authentication.getLogin_By_Query(username, email);

            PreparedStatement ps = conn.prepareStatement(Query);

            if (Query.contains("Email")) {
                ps.setString(1, email);
            } else {
                ps.setString(1, username);
            }
            ps.setString(2, Crypto.MD5(password));

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return AuthenticationStatus.FAIL;
            } else {
                if (rs.getInt("Active") == 0)
                    return AuthenticationStatus.LOCKED;

                // Getting Data From Database
                PreparedStatement userDataPs = conn.prepareStatement(Authentication.getUserDataByEmail_Query());
                userDataPs.setString(1, rs.getString("Email"));
                ResultSet userDataRs = userDataPs.executeQuery();

                if(!userDataRs.next())
                    return AuthenticationStatus.FAIL;
                // Helper Variables
                int AccountId = userDataRs.getInt("AccountId");
                String Role = userDataRs.getString("Role");
                boolean Active = userDataRs.getBoolean("Active");
                String Created = userDataRs.getString("Created");
                String Email = userDataRs.getString("Email");
                String uuid = userDataRs.getString("uuid");
                String Name = userDataRs.getString("Name");
                int age = userDataRs.getInt("Age");
                String Gender = userDataRs.getString("Gender");
                String Phonenumber = userDataRs.getString("Phonenumber");
                String SecurityQues = userDataRs.getString("SecurityQues");
                String SecurityQuesAns = userDataRs.getString("SecurityQuesAns");
                int Points = userDataRs.getInt("Points");

                // Set User Session Variables
                var User = currentuser.getInstance();
                User.setAccountId(AccountId);
                User.setEmail(Email);
                User.setRole(Roles.valueOf(Role));
                User.setActive(Active);
                User.setCreated(Created);
                User.setUuid(uuid);
                User.setName(Name);
                User.setAge(age);
                User.setGender(Gender);
                User.setPhonenumber(Phonenumber);
                User.setSecurityQuestion(SecurityQues);
                User.setSecurityAnswer(SecurityQuesAns);
                User.setPoints(Points);
                User.setOnline(true);
                Loader.LoadBooks();
                if(User.IsManager()) {
                    Loader.LoadUsers();
                    Loader.LoadBooksCategory();
                }
                // Update Online Status On The Database
                OnlineStatus(User,"1");

                return AuthenticationStatus.OK;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
            return AuthenticationStatus.DBERROR;
        } finally {
            if (dbcon != null)
                dbcon.closeConnection(conn);
        }
    }

    public static void OnlineStatus(currentuser CurrentSession,String Online){
        dbcon=dbconnection.getInstance();
        try {
            conn= dbcon.getConnection();
            PreparedStatement OnlineSetter = conn.prepareStatement(Authentication.getOnlineSetter_Query());
            OnlineSetter.setString(1, Online);
            OnlineSetter.setString(2, CurrentSession.getUuid());
            OnlineSetter.executeUpdate();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
        }
        finally {
            if(dbcon!=null)
                dbcon.closeConnection(conn);
        }
    }


}
