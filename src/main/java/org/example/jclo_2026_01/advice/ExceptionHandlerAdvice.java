package org.example.jclo_2026_01.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> illegalHandler(IllegalArgumentException e) {
        return new ResponseEntity<>("Exception in throwException method", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> reHandler() {
        return new ResponseEntity<>("Exception in throwException method", HttpStatus.I_AM_A_TEAPOT);
    }
}
