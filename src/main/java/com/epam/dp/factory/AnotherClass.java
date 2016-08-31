package com.epam.dp.factory;

import com.epam.dp.decorator.InjectRandomInt;

/**
 * Created by Oleg_Gondar on 8/30/2016.
 */
@Component("AnotherClass")
public class AnotherClass implements Show{

    @InjectRandomInt
    private int a;

    @InjectRandomInt
    private int b;

    @Override
    public void showInt() {
        System.out.println("In AnotherClass ints setted: a = "+ a + ", b = " + b );
    }
}
