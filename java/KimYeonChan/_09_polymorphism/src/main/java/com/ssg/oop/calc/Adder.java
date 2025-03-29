package com.ssg.oop.calc;

public class Adder extends Calculator {
    @Override
    public void calc() {
        System.out.println(getNum1() + " + " + getNum2() + " = " + (getNum1() + getNum2()));
    }
}
