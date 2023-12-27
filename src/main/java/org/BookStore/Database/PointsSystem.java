package org.BookStore.Database;

public class PointsSystem {
    public static String getAddUserPoints_Query(){
        return "UPDATE usersrecord SET Points = ? WHERE uuid = ?";
    }

}
