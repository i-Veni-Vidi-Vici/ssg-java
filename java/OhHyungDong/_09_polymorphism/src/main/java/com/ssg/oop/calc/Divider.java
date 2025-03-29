package com.ssg.oop.calc;

public class Divider extends Calculator {

    public Divider(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calc(int i, int j) {
        int divide = i/j;
        System.out.println("두 수의 나눗셈 몫은 " + divide + " 입니다.");

    }
}
