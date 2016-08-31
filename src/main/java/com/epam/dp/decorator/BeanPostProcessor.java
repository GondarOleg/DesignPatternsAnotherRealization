package com.epam.dp.decorator;

/**
 * Created by Oleg_Gondar on 8/30/2016.
 */
public interface BeanPostProcessor {
    public Object beanPostProcess(Object o) throws IllegalAccessException;
}
