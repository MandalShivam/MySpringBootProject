package com.infy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

   @ExceptionHandler(NoSuchCustomerException.class)
   public ResponseEntity<ErrorMessage> exceptionHandler(NoSuchCustomerException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorMessage,HttpStatus.OK);
   }
}
