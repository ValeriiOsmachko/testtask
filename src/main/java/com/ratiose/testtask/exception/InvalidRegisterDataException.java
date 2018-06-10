package com.ratiose.testtask.exception;


import com.ratiose.testtask.exceptiondataenum.ExceptionData;

public class InvalidRegisterDataException extends RuntimeException {

    private String code;

    public InvalidRegisterDataException(final ExceptionData exceptionData) {
        super(exceptionData.getMessage());
        this.code = exceptionData.getCode();
    }

    public String getCode() {
        return code;
    }

}
