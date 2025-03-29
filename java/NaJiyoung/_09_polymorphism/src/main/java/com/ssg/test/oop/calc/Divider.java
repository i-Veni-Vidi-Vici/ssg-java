package com.ssg.test.oop.calc;

public class Divider extends Calculator{
    public Divider() {}
    public Divider(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public void calc() {
        System.out.println("> 계산기 결과 : " + (getNum1()/getNum2()));
        System.out.println();
    }
}
