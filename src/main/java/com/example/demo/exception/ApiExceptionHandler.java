package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice//so that this exception handler can work across the entire application
//This is a way of handling more than one exception
public class ApiExceptionHandler {

    private static Logger LOGGER= LoggerFactory.getLogger (ApiExceptionHandler.class);

    //
    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity <Object> handleApiRequestException (ApiRequestException e) {

        //This line of code build exception payload, which is to be shown to the client
        ApiException apiException = new ApiException (e.getMessage (), e, HttpStatus.BAD_REQUEST, ZonedDateTime.now ());

        //Send back the response using ResponseEntity
        return new ResponseEntity <> (apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity <Object> handleNotFoundException (NotFoundException e) {

        //This line of code build exception payload, which is to be shown to the client
        ApiException apiException = new ApiException (e.getMessage (), e, HttpStatus.NOT_FOUND, ZonedDateTime.now ());

        //Send back the response using ResponseEntity
        return new ResponseEntity <> (apiException, HttpStatus.NOT_FOUND);
    }




}