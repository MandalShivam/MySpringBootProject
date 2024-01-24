package com.infy.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    //this helps receiving the message/value related to the general exception from the ValidationMessages.properties
   /* @Autowired
    private Environment environment;*/

   @ExceptionHandler(NoSuchCustomerException.class)
   public ResponseEntity<ErrorMessage> exceptionHandler(NoSuchCustomerException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorMessage,HttpStatus.OK);
   }

    //Handler that handles the exception raised because of invalid data that is received as
    //URI parameter (path variables, request parameters)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> exceptionHandler1(ConstraintViolationException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setMessage(ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("'")));
        return new ResponseEntity<>(errorMessage,HttpStatus.OK);
    }
}
