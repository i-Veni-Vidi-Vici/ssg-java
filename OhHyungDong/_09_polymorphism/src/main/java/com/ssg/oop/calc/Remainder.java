package com.ssg.oop.calc;

public class Remainder extends Calculator {

    public Remainder(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calc(int i, int j) {
        int remainder = i % j;
        System.out.println("두 수를 나눴을 때 나머지는 " + remainder + " 입니다.");

    }
}
