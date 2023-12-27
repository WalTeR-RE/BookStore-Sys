package org.BookStore.Database;

public class VouchersSystem {
    public static String getVouchersList_Query(){
        return "SELECT * FROM vouchers";
    }
    public static String getSpecificVouchersList_Query(){
        return "SELECT * FROM vouchers WHERE voucher = ?";
    }
    public static String getUseVoucher_Query(){
        return "INSERT INTO vouchersrecord (voucherid, UUID, Name, date) VALUES ( ?,?,?,? )";
    }

    public static String getUpdateVoucher_Query(){
        return "UPDATE vouchers SET UsedCount = ? WHERE voucherid = ?";
    }
    public static String getUserUsedVoucher_Query(){
        return "SELECT * FROM vouchersrecord WHERE UUID = ? AND voucherid = ?";
    }


}
