package com.app.develite.ControllerAdvice;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;


@RestControllerAdvice
public class exceptionHandlers {
    @RestControllerAdvice
    public class NoValuePresentAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoValuePresentException(NoSuchElementException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage("No such element!");
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    }

    @RestControllerAdvice
    public class EmptyResultDataAccessAdvice{
        @ExceptionHandler(EmptyResultDataAccessException.class)
        public ResponseEntity<ErrorResponse> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
            ErrorResponse error = new ErrorResponse();
            error.setStatus(HttpStatus.BAD_REQUEST.value());
            error.setMessage("No such element!");
            error.setTimestamp(LocalDateTime.now());
            return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
            
        }
    }
    @RestControllerAdvice
    public class AdminExceptionHandlerAdvice {
     
        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
            ErrorResponse error = new ErrorResponse();
            error.setStatus(HttpStatus.CONFLICT.value());
            if(e.getMessage().contains("unique_username")){
                error.setMessage("Username name already in use! Choose another one.");
            }
            else if(e.getMessage().contains("unique_company")){
                error.setMessage("Company name already in use! Choose another one.");
            }  
            else if (e.getMessage().contains("unique_email")){
                error.setMessage("Email already in use! Choose another one.");
            }
            else{
            error.setMessage("Data integrity violation: " + e.getMessage());
        }

            error.setTimestamp(LocalDateTime.now());
            return new ResponseEntity<>(error, HttpStatus.CONFLICT);
        }
    }
    

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        if(ex.getMessage().contains("username")){
            error.setMessage("Username Required!");
        }
        else if (ex.getMessage().contains("password")){
            error.setMessage("Password Required!");
        }
        else if (ex.getMessage().contains("firstname")){
            error.setMessage("Firstname Required!");
        }
        else if (ex.getMessage().contains("lastname")){
            error.setMessage("Lastname Required!");
        }
        else if (ex.getMessage().contains("email")){
            error.setMessage("Email Required!");
        }
        else if (ex.getMessage().contains("company")){
            error.setMessage("Company name Required!");
        }

        else if (ex.getMessage().contains("phone")){
            error.setMessage("Phone number Required!");
        }
        else if (ex.getMessage().contains("address")){
            error.setMessage("Address Required!");
        }
        else if (ex.getMessage().contains("description")){
            error.setMessage("Description Required!");
        }


        else{
            error.setMessage("Data integrity violation: " + ex.getMessage());
        }


        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
      }
}
