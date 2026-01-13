package org.example.jclo_2026_01.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController2 {
    @Value("${hello.from:defaultName}") // из org.springframework...
                            // setter здесь не нужен, т.к. значение здесь может быть добавлено через рефлексию
    private String from;

    @GetMapping("/name")
    private String hello () {
        return String.format("Hello from %s", from);
    }
}
