package heap.jsdkl;

import jakarta.persistence.Entity;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.stream.Collectors;

public class dasdsa
{
    private static Set<Class<?>> getEntities()
    {
        Reflections relections = new Reflections("heap");

        return relections
                    .getTypesAnnotatedWith(Entity.class)
                   .stream()
                   .filter(clazz -> !Modifier.isAbstract(clazz.getModifiers()))
                   .collect(Collectors.toSet());
    }
}
