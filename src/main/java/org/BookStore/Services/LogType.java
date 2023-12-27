package org.BookStore.Services;

public enum LogType {
    SYSTEM_DB_ERROR(505),
    CHAT_LOG(117),
    ADMIN_FEATURE(110),
    MANAGER_FEATURE(105),
    NEW_ORDER(102),
    REVIEWS(111),
    EDIT_REVIEW(118),
    VOUCHERS(120),
    REGISTER(1),
    LOGIN(2),
    FORGOT_PASSWORD(3),
    SYSTEM_ERROR(500),
    FILES_NOT_FOUND_ERRORS(404);

    private final int code;

    LogType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

