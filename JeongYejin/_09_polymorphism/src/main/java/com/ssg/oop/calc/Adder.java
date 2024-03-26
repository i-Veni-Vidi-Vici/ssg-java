package com.ssg.oop.calc;

public class Adder extends Calculator {
    private int num1;
    private int num2;
    public Adder(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    @Override
    public void calc() {
        System.out.println(this.num1 + this.num2);
    }
}
