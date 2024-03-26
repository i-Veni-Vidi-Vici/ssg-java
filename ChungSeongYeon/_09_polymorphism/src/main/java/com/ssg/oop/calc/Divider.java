package com.ssg.oop.calc;

public class Divider extends Calculator {
    public Divider(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public int calc() {
        return num1 / num2;
    }
}
