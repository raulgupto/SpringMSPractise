package com.springmspractise.movieservice.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class MovieExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ResponseEntity<ErrorResponse> handleValidationFailedException(ValidationFailedException e, WebRequest request){
        log.info("Exception routed from MovieExceptionHandler -> ValidationFailedException to req");
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), Collections.singletonList(e.getLocalizedMessage())), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InsertionFailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseEntity<ErrorResponse> handleInsertionFailedException(InsertionFailedException e, WebRequest request){
        log.info("Exception routed from MovieExceptionHandler -> InsertionFailedException to req");
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), Collections.singletonList(e.getLocalizedMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException e){
        log.info("Exception routed from MovieExceptionHandler -> handleConstraintViolationException to req");
        return new ResponseEntity<>(new ErrorResponse("Please check! Some values are not correct",
                e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())),
                HttpStatus.BAD_REQUEST);
    }

}
