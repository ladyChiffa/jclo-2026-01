package org.example.jclo_2026_01.controller;

import org.example.jclo_2026_01.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BrokenController {
    @GetMapping("/error")
    private String error () {
        System.out.println("logic");
        throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "ResponseStatusException");
    }
}
