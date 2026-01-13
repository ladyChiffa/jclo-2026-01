package org.example.jclo_2026_01.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties("hello") // раздел в application.properties, из которого будем брать конфигурацию для этого файла
                                  // при старте пройдемся по всем свойствам hello.* и заберем оттуда значения
                                  // чтобы это сработало - нужен еще в классе сеттер
public class HelloController {
    private String from;

    public void setFrom (String from) {
        this.from = from;
    }

    @GetMapping("/")
    private String hello () {
        return String.format("Hello from %s", from);
    }
}
