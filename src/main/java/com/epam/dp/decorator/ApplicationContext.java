package com.epam.dp.decorator;

import com.epam.dp.factory.BeanFactory;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Oleg_Gondar on 8/30/2016.
 */
public class ApplicationContext {

    BeanFactory beanFactory;
    Set<BeanPostProcessor> beanPostProcessors = new HashSet<>();

    public ApplicationContext(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        initializeBeanPostProcessors();
    }

    public Object getBean(final String id) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Object o = beanFactory.getBean(id);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors
                ) {
            beanPostProcessor.beanPostProcess(o);
        }
        return o;
    }

    private void initializeBeanPostProcessors() {
        Reflections reflections = new Reflections("com.epam.dp.decorator");
        Set<Class<? extends BeanPostProcessor>> classes = reflections.getSubTypesOf(BeanPostProcessor.class);

        for (Class<?> clazz : classes) {
            try {
                beanPostProcessors.add((BeanPostProcessor) clazz.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


}
