package org.BookStore.Database;

public class Adminstration {
    public static String getBanUnBanUserByEmail_Query(){
        return "UPDATE accounts SET Active = ? WHERE Email = ?";

    }

    public static String getRecordBanByEmail_Query(){
        return "INSERT INTO banrecord( UUID, Name, Banner, BannerUUID, Reason, BanType ) " +
                "VALUES ( " +
                "(SELECT uuid FROM usersrecord WHERE AccountId = (SELECT AccountId FROM accounts WHERE Email = ?))" + // Get UUID Of User
                ",(SELECT Name FROM usersrecord WHERE AccountId = (SELECT AccountId FROM accounts WHERE Email = ?)) " + //Get the Name Of User
                ", ?, ?, ?, ? )";
    }
    public static String getRecordBanByPhonenumber_Query(){
        return "INSERT INTO banrecord( UUID, Name, Banner, BannerUUID, Reason, BanType ) " +
                "VALUES ( " +
                "(SELECT uuid FROM usersrecord WHERE Phonenumber = ? )" + // Get UUID Of User
                ",(SELECT Name FROM usersrecord WHERE Phonenumber = ? ) " + //Get the Name Of User
                ", ?, ?, ?, ? )";
    }
    public static String getBanUnBanUserByPhonenumber_Query(){
        return "UPDATE accounts SET Active = ? WHERE (AccountId = (SELECT AccountId FROM usersrecord WHERE Phonenumber = ?))";

    }
    public static String getBanUnBanUserChatByEmail_Query(){
        return "UPDATE usersrecord SET ChatIsBanned = ? WHERE AccountId = (SELECT AccountId From accounts WHERE Email = ?)";
    }
    public static String getBanUnBanUserChatByPhonenumber_Query(){
        return "UPDATE usersrecord SET ChatIsBanned = ? WHERE Phonenumber = ?";
    }
    public static String getListOfUsers_Query(){
        return "SELECT * FROM usersrecord";
    }

}
