package com.ratiose.testtask.controller;

import com.ratiose.testtask.dto.ErrorDetails;
import com.ratiose.testtask.exception.InvalidRegisterDataException;
import com.ratiose.testtask.exception.UserAlreadyExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(InvalidRegisterDataException.class)
    public final ResponseEntity<ErrorDetails> handleInvalidRegisterDataException(final InvalidRegisterDataException invalidRegisterDataException) {
        ErrorDetails errorDetails = new ErrorDetails(invalidRegisterDataException.getCode(), invalidRegisterDataException.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public final ResponseEntity<ErrorDetails> handleUserAlreadyExistsException(final UserAlreadyExistsException userAlreadyExistsException) {
        ErrorDetails errorDetails = new ErrorDetails(userAlreadyExistsException.getCode(), userAlreadyExistsException.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }
}
