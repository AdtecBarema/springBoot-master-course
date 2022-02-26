package com.example.demo.exception;

//This is what is going to be thrown from our code
public class ApiRequestException extends RuntimeException {
//Here we are overriding two of RuntimeException constructors

    public ApiRequestException (String message) {
        super (message);
    }

    public ApiRequestException (String message, Throwable cause) {
        super (message, cause);
    }
}
