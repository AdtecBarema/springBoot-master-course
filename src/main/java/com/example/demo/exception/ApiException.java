package com.example.demo.exception;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

//This class is the  actual exception-message the client is going to see.
@Data
public class ApiException {

    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;


//    public ApiException (String message,
//                         Throwable throwable,
//                         HttpStatus httpStatus,
//                         ZonedDateTime zonedDateTime) {
//
//        this.message = message;
//        this.throwable = throwable;
//        this.httpStatus = httpStatus;
//        this.zonedDateTime = zonedDateTime;
//    }
//
//    public String getMessage () {
//        return message;
//    }
//
//    public Throwable getThrowable () {
//        return throwable;
//    }
//
//    public HttpStatus getHttpStatus () {
//        return httpStatus;
//    }
//
//    public ZonedDateTime getZonedDateTime () {
//        return zonedDateTime;
//    }
//
//    @Override
//    public String toString () {
//        return "ApiException{" +
//                "message='" + message + '\'' +
//                ", throwable=" + throwable +
//                ", httpStatus=" + httpStatus +
//                ", zonedDateTime=" + zonedDateTime +
//                '}';
//    }
}