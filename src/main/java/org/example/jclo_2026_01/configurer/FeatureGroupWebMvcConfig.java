package org.example.jclo_2026_01.configurer;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sound.midi.Instrument;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FeatureGroupWebMvcConfig implements WebMvcConfigurer {

    // Создание пользовательской аннотации:
    // реализовать логику обработки конкретного типа аргументов в случае, если рядом с ним присутствует
    // специальная аннотация

    /*
    private static final Map<String, InstrumentType> types = Stream.of(Bond.values(), Entity.values())
            .flatMap(Stream::of).collect(Collectors.toMap(InstrumentType::name, Function.identity()));

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CustomParamResolver());

    }

    private class CustomParamResolver implements HandlerMethodArgumentResolver{
        @Override
        public boolean supportsParameter(MethodParameter parameter) {
            return parameter.hasParameterAnnotation(Instrument.class);
        }

        @Override
        public Object resolveArgument (MethodParameter parameter, ModelAndViewContainer mavContainer,
                                       NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
            String feature = webRequest.getParameter("feature");
            return types.getOrDefault(feature, Unknown.UNKNOWN);
        }
    }
     */
}
