package org.example.jclo_2026_01.controller;

import org.example.jclo_2026_01.domain.Person;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/hello") // В теле запроса будем передавать в виде JSON Person
    private String hello (@RequestBody Person guest) {
        return String.format("Hello from %s to name %s age %d",
                from, guest.getName(), guest.getAge());
    }
}
