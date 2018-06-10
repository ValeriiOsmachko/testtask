package com.ratiose.testtask.exceptiondataenum;


public enum ExceptionData {

    INVALID_REGISTER_DATA("400", "Invalid register data. Not enough data for registration."),
    USER_ALREADY_EXISTS("409", "User already exists");

    ExceptionData(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
