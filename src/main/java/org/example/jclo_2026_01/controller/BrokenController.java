package org.example.jclo_2026_01.controller;

import org.example.jclo_2026_01.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
