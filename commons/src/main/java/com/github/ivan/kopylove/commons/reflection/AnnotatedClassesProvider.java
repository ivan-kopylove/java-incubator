package com.github.ivan.kopylove.commons.reflection;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.stream.Collectors;

public class AnnotatedClassesProvider
{
    public static Set<Class<?>> getAnnotatedClasses(Class<? extends Annotation> input, String packageName)
    {
        Reflections relections = new Reflections(packageName);

        return relections.getTypesAnnotatedWith(input).stream()
                         .filter(clazz -> !Modifier.isAbstract(clazz.getModifiers())).collect(Collectors.toSet());
    }
}
