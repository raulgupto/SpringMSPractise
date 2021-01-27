package com.springmspractise.movieservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InsertionFailedException extends RuntimeException{

    public InsertionFailedException(String message){
        super(message);
    }
    public InsertionFailedException(String message, Throwable e){
        super(message, e);
    }
    public InsertionFailedException(Throwable e){
        super(e);
    }
}
