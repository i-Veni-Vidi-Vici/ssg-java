package com.ssg.oop.calc;

public class Multiplyer extends Calculator{
    public Multiplyer() {
    }

    public Multiplyer(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public void calc() {

        System.out.println("두수의 곱 " + (getNum1() * getNum2()));
    }
}
