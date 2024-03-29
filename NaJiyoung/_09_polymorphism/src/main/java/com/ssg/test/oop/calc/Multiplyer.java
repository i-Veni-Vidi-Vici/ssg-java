package com.ssg.test.oop.calc;

public class Multiplyer extends Calculator{
    public Multiplyer() {}
    public Multiplyer(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public void calc() {
        System.out.println("> 계산기 결과 : " + (getNum1()*getNum2()));
        System.out.println();
    }
}
