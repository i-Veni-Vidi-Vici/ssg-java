package com.ssg.oop.calc;

public class Adder extends Calculator{

    public Adder(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public void calc() {
        System.out.println(getNum1()+" + "+getNum2() +" = " + (getNum1()+getNum2()));
    }
}
