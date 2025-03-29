package com.ssg.oop.calc;

public class Adder extends Calculator {

    public Adder(int num1, int num2) {
        super(num1, num2);
    }

    public Adder() {
    }

    @Override
    public void calc(int i, int j) {
        int sum = i+j;
        System.out.println("두 수의 합은 " + sum + " 입니다.");
    }
}
