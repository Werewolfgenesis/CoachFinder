package com.practice.coach.finder.demo.handlers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice("com.practice.coach.finder.demo.rest")
@Log4j2
public class DtoValidationHandlers {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>>onMethodArgumentNotValidExceptionException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
        		.map(DefaultMessageSourceResolvable::getDefaultMessage)
        		.collect(Collectors.toList());
        log.error("An error occured during validation {}: {}",  ex.getObjectName(), errors);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> onServiceValidationErrors(ConstraintViolationException ex) {
        List<String> errors = ex.getConstraintViolations().stream()
        		.map(ConstraintViolation::getMessage)
        		.collect(Collectors.toList());
        log.error("An error occured during validation {}: {}",  ex.getClass().getCanonicalName(), errors);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<String>> onServiceValidationErrors(BindException ex) {
        List<String> errors = ex.getBindingResult().getAllErrors().stream()
        		.map(DefaultMessageSourceResolvable::getDefaultMessage)
        		.collect(Collectors.toList());
        log.error("An error occured during validation {}: {}",  ex.getObjectName(), errors);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
