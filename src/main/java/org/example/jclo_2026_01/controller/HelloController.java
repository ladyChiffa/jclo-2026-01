package org.example.jclo_2026_01.controller;

import org.example.jclo_2026_01.domain.Person;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    private String hello (@RequestBody @Validated Person guest) {
        return String.format("Hello from %s to name %s age %d",
                from, guest.getName(), guest.getAge());
    }

    @GetMapping("/hello") // В строке запроса будем передавать Person
    private String helloGet (Person guest) {
        return String.format("Hello from %s to name %s age %d",
                from, guest.getName(), guest.getAge());
    }

    @GetMapping("/helloName") // В строке запроса будем передавать Person
    private String helloName (@RequestParam("name") String name) {
        return String.format("Hello from %s to name %s",
                from, name);
    }

    @GetMapping("/helloParams") // В строке запроса будем передавать Person
    private String helloParams (@RequestParam("name") String name,
                                @RequestParam("age") int age) {
        return String.format("Hello from %s to name %s age %d",
                from, name, age);
    }
}
