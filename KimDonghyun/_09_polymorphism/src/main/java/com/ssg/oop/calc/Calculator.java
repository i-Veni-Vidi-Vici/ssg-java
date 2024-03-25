package com.ssg.oop.calc;

public abstract class Calculator {
    protected int num1;
    protected int num2;

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public abstract int calc();
}
