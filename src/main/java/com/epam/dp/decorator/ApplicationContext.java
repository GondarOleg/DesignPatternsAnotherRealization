package com.epam.dp.decorator;

import com.epam.dp.factory.BeanFactory;

/**
 * Created by Oleg_Gondar on 8/30/2016.
 */
public class ApplicationContext {

    BeanFactory beanFactory;
    BeanPostProcessor beanPostProcessor;

    public ApplicationContext(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void setBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessor = beanPostProcessor;
    }

    public Object getBean(final String id) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        return beanPostProcessor.beanPostProcess(beanFactory.getBean(id));

    }


}
