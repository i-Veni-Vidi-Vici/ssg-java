package com.ssg.oop.calc;

public class Remainder extends Calculator {
    public Remainder(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public int calc() {
        return num1 % num2;
    }
}
