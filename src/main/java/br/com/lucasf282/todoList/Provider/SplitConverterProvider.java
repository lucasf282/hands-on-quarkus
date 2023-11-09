package br.com.lucasf282.todoList.Provider;

import br.com.lucasf282.todoList.Annotation.Split;
import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;
import jakarta.ws.rs.ext.Provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Provider
public class SplitConverterProvider implements ParamConverterProvider {
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if(rawType == List.class) {
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(Split.class)) {
                    return (ParamConverter<T>) new SplitConverter(((Split) annotation).value());
                }
            }
            return (ParamConverter<T>) new SplitConverter();// default if there's no @Split annotation
        }
        return null;
    }
}


class SplitConverter implements ParamConverter<List<String>> {
    private final String splitCharacter;

    public SplitConverter(String splitCharacter) {
        this.splitCharacter = splitCharacter;
    }

    public SplitConverter() {
        this.splitCharacter = null;
    }

    @Override
    public List<String> fromString(String value) {
        // strip the [] that the value gets automatically wrapped in,
        // because the query param is a List
        value = value.substring(1, value.length() - 1);
        if (Objects.nonNull(splitCharacter)){
            String[] splits = value.split(splitCharacter);
            List<String> values = List.of(splits);
            if(values.isEmpty()){
                values = List.of(value);
            }
            return values;
        } else {
            return List.of(value);
        }
    }

    @Override
    public String toString(List<String> value) {
        return value.stream().collect(Collectors.joining(","));
    }
}
