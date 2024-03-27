package com.ssg.oop.calc;

public class Remainder extends Calculator {
    private int num1;
    private int num2;

    public Remainder(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void calc() {
        System.out.println(num1 % num2);
    }
}
