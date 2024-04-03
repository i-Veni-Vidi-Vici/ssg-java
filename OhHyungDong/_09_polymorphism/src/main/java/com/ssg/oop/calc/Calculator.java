package com.ssg.oop.calc;

public abstract class Calculator {
    private int num1;
    private int num2;

    public Calculator() {
    }

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public abstract void calc(int i, int j);
}
