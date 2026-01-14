package org.example.jclo_2026_01.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RulesWebMvcConfig implements WebMvcConfigurer {

    /*

    // Пример создания и регистрации конвертера в FormatterRegistry

    private static final Map<String, InstrumentType> types = Stream.of(Bond.values(), Entity.values())
            .flatMap(Stream::of).collect(Collectors.toMap(InstrumentType::name, Function.identity()));

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new SpringRateFeatureConverter());
    }

    private static class SpringRateFeatureConverter implements Converter<String, InstrumentType> {
        @Override
        public InstrumentType convert(String source) {
            return types.getOrDefault(source, Unknown.UNKNOWN);
        }
    }

     */
}
