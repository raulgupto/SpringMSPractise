package com.springmspractise.movieservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationFailedException extends RuntimeException{

    public ValidationFailedException(String message){
        super(message);
    }
    public ValidationFailedException(String message, Throwable throwable){
        super(message, throwable);
    }
    public ValidationFailedException(Throwable throwable){ super(throwable); }
}
