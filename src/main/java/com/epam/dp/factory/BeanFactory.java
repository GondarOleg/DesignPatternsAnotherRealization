package com.epam.dp.factory;

import org.reflections.Reflections;

import java.util.*;

/**
 * @author Ivan_Zhuravel
 */
public class BeanFactory {

    private Reflections reflections =
            new Reflections("com.epam.dp.factory");
    private Map<String, Object> beans = new HashMap<>();

    {
        Set<Class<?>> annotatedWith = reflections
                .getTypesAnnotatedWith(Component.class);

        for (Class<?> clazz : annotatedWith) {
            tryAddToListeners(clazz);
        }
    }

    public Object getBean(final String id) {
        return beans.get(id);
    }


    private void tryAddToListeners(Class<?> clazz) {
        try {
            Component annotation = clazz.getAnnotation(Component.class);

            beans.put(annotation.value(), clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
