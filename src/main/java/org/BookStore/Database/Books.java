package org.BookStore.Database;

public class Books {

    public static String getAllBooks_Query(){
        return "SELECT * FROM sysbooksrecord";
    }
    public static String getAddNewBook_Query(){
        return "INSERT INTO sysbooksrecord ( BookId , Author , Title , Category , Description , CoverImg , Price , Quantity , AvgRev ) " +
                "VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? )";
    }
    public static String getUpdateBookAttributes_Query(){
        return "UPDATE sysbooksrecord SET Author = ?, Title = ?, Category = ?, Description = ?, CoverImg = ?, " +
                "Price = ?, Quantity = ?, AvgRev = ? WHERE BookId = ?";
    }
    public static String getDeleteBookById_Query(){
        return "DELETE FROM sysbooksrecord WHERE BookId = ? ";
    }

    public static String getDeleteBookByAvgRev_Query(){
        return "DELETE FROM sysbooksrecord WHERE AvgRev <= ? ";
    }

    public static String getPutBookOrderQuery(){
        return "INSERT INTO ordersrecord (uuid,Name,Phonenumber,Address,Country,Quantity,BookId,Date) VALUES (?,?,?,?,?,?,?,?)";
    }
    public static String getPutPurchaseHistory_Query(){
        return "CALL UpdateOrInsertOrder(?, ?, ?)";
    }
    public static String getUpdateQuantity_Query(){
        return "UPDATE sysbooksrecord SET Quantity = ? WHERE BookId = ?";
    }
    public static String getAllBookCategory_Query(){
        return "SELECT * FROM bookscategories";
    }

}
