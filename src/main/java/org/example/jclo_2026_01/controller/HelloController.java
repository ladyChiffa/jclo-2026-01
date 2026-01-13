package org.example.jclo_2026_01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    private String hello () {
        return "Hello from app";
    }
}
