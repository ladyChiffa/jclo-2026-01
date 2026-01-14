package org.example.jclo_2026_01.controller;

import jdk.javadoc.doclet.Reporter;
import org.example.jclo_2026_01.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/error")
public class BrokenController {
    @GetMapping("/error")
    public String error () {
        System.out.println("logic");
        throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "ResponseStatusException");
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") long id) {
        try {
            throw new IllegalArgumentException("IllegalArgumentException");
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ResponseStatusException", e);
        }
    }

    @GetMapping("/illegal")
    public Person throwException() {
        throw new IllegalArgumentException("IllegalArgumentException");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> illegalHandler(IllegalArgumentException e) {
        return new ResponseEntity<>("Exception in throwException method", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> reHandler() {
        return new ResponseEntity<>("Exception in throwException method", HttpStatus.I_AM_A_TEAPOT);
    }
}
