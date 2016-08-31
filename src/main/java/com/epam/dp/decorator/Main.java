package com.epam.dp.decorator;

import com.epam.dp.factory.BeanFactory;
import com.epam.dp.factory.Show;
import com.epam.dp.factory.SomeClass;


public class Main {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {

        ApplicationContext applicationContext = new ApplicationContext(new BeanFactory());

        loadApplicationContext("TestClass", applicationContext);
        loadApplicationContext("AnotherClass", applicationContext);
        loadApplicationContext("AnotherOneClass", applicationContext);
        SomeClass someClass = (SomeClass) applicationContext.getBean("SomeClass");
        System.out.println(someClass.getTest());

    }

    public static void loadApplicationContext(String className, ApplicationContext applicationContext) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //Function just for test
        Show show = (Show) applicationContext.getBean(className);
        show.showInt();
    }
}
