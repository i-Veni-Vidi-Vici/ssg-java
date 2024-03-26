package com.ssg.oop.calc;

public class Adder extends Calculator {
    @Override
    public void calc(int num1, int num2) {
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2) + "\n");
    }
}
