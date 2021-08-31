package com.payroll.smepayroll.controller;

import com.payroll.smepayroll.exception.ErrorResponse;
import com.payroll.smepayroll.exception.FileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(FileNotFoundException exception){

        ErrorResponse errorResponse= new ErrorResponse();
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
