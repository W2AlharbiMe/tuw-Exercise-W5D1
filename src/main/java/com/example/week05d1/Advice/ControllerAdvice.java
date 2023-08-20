package com.example.week05d1.Advice;


import com.example.week05d1.Api.ApiException;
import com.example.week05d1.Api.SimpleApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<SimpleApiResponse> ApiException(ApiException e){
        String message = e.getMessage();
        return ResponseEntity.status(404).body(new SimpleApiResponse(message));
    }

}
