package com.rupesh.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException userNotFoundException){

        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse();
        customExceptionResponse.setErrorMessage(userNotFoundException.getMessage());
        customExceptionResponse.setErrorCode(userNotFoundException.getErrorCode());

        return new ResponseEntity<>(customExceptionResponse, HttpStatus.NOT_FOUND);
    }
}
