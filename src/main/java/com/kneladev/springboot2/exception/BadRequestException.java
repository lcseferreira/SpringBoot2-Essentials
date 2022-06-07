package com.kneladev.springboot2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// A classe é uma exceção, então ela extends de RuntimeException
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
    // constructor da classe pai
    public BadRequestException(String message) {
        super(message);
    }
}
