package com.ssg.oop.calc;

public class Multiplyer extends Calculator{
    public Multiplyer() {}

    public Multiplyer(int num1, int num2) {
        super(num1, num2);
    }

    public void calc(){
        System.out.println(getNum1() * getNum2());
    }
}
