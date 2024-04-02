package com.ssg.oop.calc;

public class Substractor extends Calculator {


    public Substractor(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public void calc(int i, int j) {
        int sub = i -j;
        System.out.println("두 수의 차는 " + sub + " 입니다.");

    }
}
