package com.my_bank.myBank.global.exception;

import lombok.Getter;

public enum Exceptions {

    /*
    * 기본 예외 처리
    */
    INVALID_DATE(400, "Invalid Date"),
    INVALID_VALUES(400, "Invalid Values"),
    UNAUTHORIZED(401, "Unauthorized"),
    ACCESS_FORBIDDEN(403, "Access forbidden"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    EMAIL_EXISTS(409, "Email exists"),
    LOGIN_ID_EXISTS(409, "Login Id exists"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_IMPLEMENTATION(501, "Not Implementation"),

    /*
    * User 예외 처리
    */
    INVALID_MEMBER_STATUS(400, "Invalid User status"),
    INVALID_PASSWORD (400, "Invalid Password"),
    USER_NOT_FOUND(404, "User not found"),
    ID_NOT_EXIST(404, "ID is not exist"),
    USER_EXISTS(409, "User exists"),
    USERID_EXISTS(409, "User_id exists"),

    /*
    * ACCOUNT(게시글) 예외 처리
    */
    ACCOUNT_NOT_PATCHED(403, "ACCOUNT not patched"),
    ACCOUNT_NOT_RECRUITING(403, "ACCOUNT status not recruiting"),
    INVALID_ACCOUNT_STATUS(403, "Invalid ACCOUNT Status"),
    ACCOUNT_NOT_FOUND(404, "ACCOUNT Not Found"),
    ACCOUNT_EXISTS(409, "ACCOUNT exists"),
    ACCOUNT_CHECK_EXISTS(409, "ACCOUNT Check exists"),
    ACCOUNT_REQUEST_EXISTS(409, "ACCOUNT Request exists"),
    ACCOUNT_MEMBER_EXISTS(409, "ACCOUNT Member exists"),

    /*
     * INCOME(게시글) 예외 처리
     */
    INCOME_NOT_PATCHED(403, "INCOME not patched"),
    INCOME_NOT_RECRUITING(403, "INCOME status not recruiting"),
    INVALID_INCOME_STATUS(403, "Invalid INCOME Status"),
    INCOME_NOT_FOUND(404, "INCOME Not Found"),
    INCOME_EXISTS(409, "INCOME exists"),
    INCOME_CHECK_EXISTS(409, "INCOME Check exists"),
    INCOME_REQUEST_EXISTS(409, "INCOME Request exists"),
    INCOME_MEMBER_EXISTS(409, "INCOME Member exists"),

    /*
     * OUTCOME(게시글) 예외 처리
     */
    OUTCOME_NOT_PATCHED(403, "OUTCOME not patched"),
    OUTCOME_NOT_RECRUITING(403, "OUTCOME status not recruiting"),
    INVALID_OUTCOME_STATUS(403, "Invalid OUTCOME Status"),
    OUTCOME_NOT_FOUND(404, "OUTCOME Not Found"),
    OUTCOME_EXISTS(409, "OUTCOME exists"),
    OUTCOME_CHECK_EXISTS(409, "OUTCOME Check exists"),
    OUTCOME_REQUEST_EXISTS(409, "OUTCOME Request exists"),
    OUTCOME_MEMBER_EXISTS(409, "OUTCOME Member exists");

    @Getter
    private int status;

    @Getter
    private String message;

    Exceptions(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
