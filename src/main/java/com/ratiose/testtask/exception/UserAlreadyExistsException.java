package com.ratiose.testtask.exception;


import com.ratiose.testtask.exceptiondataenum.ExceptionData;

public class UserAlreadyExistsException extends RuntimeException {

    private String code;

    public UserAlreadyExistsException(final ExceptionData exceptionData) {
        super(exceptionData.getMessage());
        this.code = exceptionData.getCode();
    }

    public String getCode() {
        return code;
    }


}
