package com.epam.dp.decorator;

import com.epam.dp.factory.Show;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Oleg_Gondar on 8/31/2016.
 */
public class InjectIntInNotAnnotatedFieldBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object beanPostProcess(Object o) throws IllegalAccessException {
        return injectRandomIntBeanPostProcessor(o);
    }

    private Object injectRandomIntBeanPostProcessor(Object o) throws IllegalAccessException {
        if (o instanceof Show) {
            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(InjectRandomInt.class)) {
                    field.setAccessible(true);
                    field.setInt(o, new Random().nextInt(1000));
                }
            }
        }
        return o;
    }
}
