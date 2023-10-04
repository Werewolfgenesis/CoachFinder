package com.practice.coach.finder.demo.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice("com.practice.coach.finder.demo.rest")
@Log4j2
public class UnexpectedExceptionHandler {
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> onExceptionHandler(Exception ex) {
        log.error("Si è verificato un errore inatteso: " + ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
