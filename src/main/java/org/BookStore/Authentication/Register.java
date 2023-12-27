package org.BookStore.Authentication;

import org.BookStore.Cryptography.*;
import org.BookStore.Database.*;
import org.BookStore.Controllers.*;


import javax.swing.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

public class Register {

    public enum RegistrationStatus{
        OK,
        FAIL,
        PASSWORD_CONFIRMATION_ERROR,
        PASSWORD_ERROR,
        USERNAME_ERROR,
        EMAIL_ERROR,
        PHONENUMBER_ERROR,
        SECURITY_QUES_ERROR,
        SECURITY_ANS_ERROR,
        AGE_ERROR,
        GENDERERROR,
        DBERROR
    }
    private static String generateSecureUUID(){
        try {
            SecureRandom random = SecureRandom.getInstanceStrong();
            byte[] Rbytes = new byte[16];
            random.nextBytes(Rbytes);
            UUID uuid = UUID.nameUUIDFromBytes(Rbytes);

            return uuid.toString();
        } catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
        }
        return UUID.randomUUID().toString();
    }
    public static String[] getSecQuestions(){
        String[] Questions = {
                "What is the name of your first pet?",
                "What is your favorite book/movie/band?",
                "What is your mother's maiden name?",
                "What is your favorite color?",
                "What is the capital of France?",
                "In what year did World War II end?",
                "What is your dream vacation destination?",
                "Who is your favorite historical figure?",
                "What is the last name of your favorite teacher?",
                "What is the model of your first car?",
                "What is your favorite type of cuisine?",
                "What is the name of your childhood best friend?",
                "What is the street name of the first house you lived in?",
                "What is the make of your first computer?",
                "What is your favorite childhood game?",
                "What is the name of your first crush?",
                "What is the title of your favorite song?",
                "What is the name of your favorite fictional character?",
                "What is the last name of your favorite actor/actress?",
                "What is the name of your favorite sport?",
                "What is the name of the city where you were born?",
                "What is your favorite season?",
                "What is the make of your favorite electronic device?",
                "What is the name of your favorite podcast?"
        };

        Random rnd = new Random();
        for (int i = Questions.length - 1; i > 0; i--) {
            int j = rnd.nextInt(0,i+1);
            String temp = Questions[i];
            Questions[i] = Questions[j];
            Questions[j] = temp;
        }

        return Questions;
    }
    static Connection conn=null;
    static dbconnection dbcon=null;

    public static RegistrationStatus Register(
            String username,String email,String password,
            String password_confirmation,
            String phonenumber,String security_ques,
            String security_ans,int age,String Gender)
    {
        validators serializer = new validators();
        if(!serializer.isValidUsername(username))
            return RegistrationStatus.USERNAME_ERROR;
        if(!serializer.isValidPassword(password))
            return RegistrationStatus.PASSWORD_ERROR;
        if(!password.equals(password_confirmation))
            return RegistrationStatus.PASSWORD_CONFIRMATION_ERROR;
        if(!serializer.isValidPhoneNumber(phonenumber))
            return RegistrationStatus.PHONENUMBER_ERROR;
        if(!serializer.isValidEmail(email))
            return RegistrationStatus.EMAIL_ERROR;
        if(!serializer.isValidSecurityQuestion(security_ques))
            return RegistrationStatus.SECURITY_QUES_ERROR;
        if(!serializer.isValidSecurityAnswer(security_ans))
            return RegistrationStatus.SECURITY_ANS_ERROR;
        if(age<8)
            return RegistrationStatus.AGE_ERROR;
        if(!serializer.isValidGender(Gender))
            return RegistrationStatus.GENDERERROR;

        try{
            dbconnection dbcon = dbconnection.getInstance();
            conn = dbcon.getConnection();

            // Validate There Is No Duplication
            String validatorQuery = Authentication.getRegistration_Validate_Query();
            PreparedStatement ps1 = conn.prepareStatement(validatorQuery);
            ps1.setString(1,username);
            ps1.setString(2,email);
            ps1.setString(3,phonenumber);

            ResultSet rs1 = ps1.executeQuery();
            if(rs1.next())
                return RegistrationStatus.FAIL;

            String Query1 = Authentication.getRegister_New_Userrec_Query();
            String Query2 = Authentication.getRegister_New_Account_Query();
            PreparedStatement st1 = conn.prepareStatement(Query2);
            st1.setString(1,username);
            st1.setString(2,Crypto.MD5(password));
            st1.setString(3,email);
            st1.setString(4,"User");
            st1.setString(5,"1");
            st1.setString(6, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY")));
            st1.executeUpdate();

            PreparedStatement st2 = conn.prepareStatement(Query1);
            st2.setString(1,generateSecureUUID());
            st2.setString(2,username);
            st2.setString(3,String.valueOf(age));
            st2.setString(4,Gender);
            st2.setString(5,phonenumber);
            st2.setString(6, security_ques);
            st2.setString(7, security_ans);
            st2.setString(8, "0");
            st2.setString(9, "0");
            st2.executeUpdate();

            return RegistrationStatus.OK;

        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
            return RegistrationStatus.DBERROR;
        }
        finally {
            if(dbcon!=null)
                dbcon.closeConnection(conn);
        }



    }


}
