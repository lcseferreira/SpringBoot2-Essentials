package com.kneladev.springboot2.handler;

import com.kneladev.springboot2.exception.BadRequestException;
import com.kneladev.springboot2.exception.BadRequestExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

// Caso os controllers tenham uma exceção do tipo BAD REQUEST, retorne esse exception handler
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre) {
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad request exception, check the documentation.")
                        .details(bre.getMessage())
                        .developerMessager(bre.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }
}
