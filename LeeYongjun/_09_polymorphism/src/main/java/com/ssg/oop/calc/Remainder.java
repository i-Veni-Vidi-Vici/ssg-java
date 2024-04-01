package com.ssg.oop.calc;

public class Remainder extends Calculator{
    public Remainder() {
    }

    public Remainder(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public void calc() {

        System.out.println("두수의 나머지 " + (getNum1() % getNum2()));
    }
}

