package org.example.jclo_2026_01.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.function.Consumer;
import java.util.stream.Stream;

@Configuration
public class StaticResourceMapping implements WebMvcConfigurer {

    // Для удобной работы со статичным ресурсом необходимо
    // поставить в соответствие относительный путь, по которому надо вернуть ресурс,
    // и название и путь ресурса, который Spring будет искать в папке resources/путь_к_ресурсу_и_его_название

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        String index = "index";
        Consumer<String> registerViewController = path -> registry.addViewController("/" + path).setViewName("index");
        Stream.of("/", "ui", index).forEach(registerViewController);
    }
}
