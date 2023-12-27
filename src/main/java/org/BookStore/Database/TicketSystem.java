package org.BookStore.Database;

public class TicketSystem {
    public static String getCreateTicket_Query(){
        return "INSERT INTO ticketsrecord ( TicketId, UUID, Name, Summary, `Desc`, Status, Date ) VALUES ( ?, ?, ?, ?, ?, ?, ? ) ";
    }
    public static String getUpdateTicketStat_Query(){
        return "UPDATE ticketsrecord SET Status = ? WHERE TickedId = ?";
    }
    public static String getAllTickets_Query(){
        return "SELECT * FROM ticketsrecord";
    }
    public static String getTicketsByStatus_Query(){
        return "SELECT * FROM ticketsrecord WHERE Status = ?";
    }
}
