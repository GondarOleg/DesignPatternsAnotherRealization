package com.epam.dp.factory;

import com.epam.dp.decorator.InjectRandomInt;

/**
 * Created by Oleg_Gondar on 8/30/2016.
 */

@Component("TestClass")
public class TestClass implements Show {


    @InjectRandomInt
    int a;

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public void showInt() {
        System.out.println("In TestClass int setted: " + a);
    }
}
