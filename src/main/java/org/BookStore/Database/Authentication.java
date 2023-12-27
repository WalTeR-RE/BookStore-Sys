package org.BookStore.Database;

import javax.swing.plaf.PanelUI;

public class Authentication {
    public static String getLogin_By_Query(String username,String email){
        if(!username.isEmpty()) {
            return "SELECT * FROM accounts WHERE username = ? AND password = ?";
        }
        else if(!email.isEmpty()){
            return "SELECT * FROM accounts WHERE Email = ? AND password = ?";
        }
        return "SELECT * FROM accounts WHERE username = ? AND password = ?";
    }
    public static String getUser_UUID_ByUsername_Query(){
            return "SELECT uuid FROM usersrecord WHERE username = ?";
    }
    public static String getUser_UUID_ByAccountId_Query(){
        return "SELECT uuid FROM usersrecord WHERE AccountId = ?";
    }
    public static String getRegister_New_Account_Query(){
        return "INSERT INTO accounts (username , password , Email, Role, Active, Created) VALUES (?,?,?,?,?,?)";
    }
    public static String getRegister_New_Userrec_Query(){
        return "INSERT INTO usersrecord (uuid , Name , Age, Gender, Phonenumber, SecurityQues, SecurityQuesAns, Points, Online) VALUES (?,?,?,?,?,?,?,?,?)";
    }
    public static String getRegistration_Validate_Query(){
        return "SELECT AccountId from accounts WHERE (username = ? or Email = ? ) UNION SELECT AccountId FROM usersrecord WHERE Phonenumber = ? ";
    }
    public static String getUserByEmail_Query(){ return "SELECT * FROM accounts WHERE Email = ?"; } //reset by email Checker
    public static String getUserByPhonenumber_Query(){ return "SELECT AccountId FROM usersrecord WHERE Phonenumber = ?"; } // reset by phonenumber Checker

    public static String getUserDataByEmail_Query(){
        return "SELECT * FROM accounts INNER JOIN usersrecord ON accounts.AccountId = usersrecord.AccountId WHERE accounts.Email = ?";
    }
    public static String getOnlineSetter_Query(){
        return "UPDATE usersrecord SET Online = ? WHERE uuid = ?";
    }
    public static String getUserByPhonenumber2_Query(){ return "SELECT * FROM accounts INNER JOIN usersrecord ON accounts.AccountId = usersrecord.AccountId WHERE usersrecord.Phonenumber = ?"; } // reset by phonenumber Checker
    public static String getResetPasswordByEmail_Query(){ return "UPDATE accounts SET OTP = ? WHERE Email= ?"; } // reset by email Handler1
    public static String getUpdateOTPCounter_Query(){ return "UPDATE accounts SET ResetCounter = ? WHERE Email= ?"; } // OTP/SecQues Attempt Handler
    public static String getWrongResetCounter_Query(){ return "UPDATE accounts SET WrongResetCounter = ? WHERE Email= ?"; } // OTP/SecQues Attempt Handler
    public static String getAccountActive_Query(){ return "UPDATE accounts SET Active = ? WHERE Email= ?"; } // OTP/SecQues Attempt Handler

    public static String getSecurityQues_Ans_Query(){ return "SELECT * FROM usersrecord WHERE AccountId = ?"; } // reset by phonenumber Handler
    public static String getOTP_Query(){ return "SELECT OTP FROM accounts WHERE Email = ?"; } // reset by email Handler2
    public static String getUpdateUserPassword_Query(String email){ return !email.isEmpty()?"UPDATE accounts SET password = ? WHERE Email = ?" : "UPDATE accounts SET password = ? WHERE AccountId = ?"; } // UPDATE PASSWORD
}
