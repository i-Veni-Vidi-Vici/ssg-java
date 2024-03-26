package com.ssg.oop.calc;

public class Divider extends Calculator {
    @Override
    public void calc() {
        System.out.printf("%d / %d = %d\n", getNum1(), getNum2(), getNum1() / getNum2());
    }
}
