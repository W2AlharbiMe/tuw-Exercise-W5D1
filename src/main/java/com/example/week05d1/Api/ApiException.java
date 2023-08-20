package com.example.week05d1.Api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class ApiException extends RuntimeException {
    private String message;

    public ApiException(String message) {
        super(message);
    }
}
