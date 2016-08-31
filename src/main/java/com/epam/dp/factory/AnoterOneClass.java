package com.epam.dp.factory;

import com.epam.dp.decorator.InjectRandomInt;

/**
 * Created by Oleg on 8/30/2016.
 */
@Component("AnotherOneClass")
public class AnoterOneClass implements Show{

    @InjectRandomInt
    int a;

    int b;

    @InjectRandomInt
    int c;

    @Override
    public void showInt() {
        System.out.println("In AnoterOneClass ints setted:" +
                " a = " + a +
                ", b = " + b +
                ", c = " + c);
    }

}
