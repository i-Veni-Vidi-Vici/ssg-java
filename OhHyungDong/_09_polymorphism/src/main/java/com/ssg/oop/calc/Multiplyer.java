package com.ssg.oop.calc;

public class Multiplyer extends Calculator {


    public Multiplyer(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calc(int i, int j) {
        int multi = i * j;
        System.out.println("두 수의 곱은 " + multi + " 입니다.");

    }
}
