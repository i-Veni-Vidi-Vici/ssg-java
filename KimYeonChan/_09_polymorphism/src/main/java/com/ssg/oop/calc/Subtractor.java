package com.ssg.oop.calc;

public class Subtractor extends Calculator {
    @Override
    public void calc() {
        System.out.println(getNum1() + " - " + getNum2() + " = " + (getNum1() - getNum2()));
    }
}
