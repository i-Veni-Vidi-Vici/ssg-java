package com.ssg.oop.calc;

public class Subtractor extends Calculator{
    public Subtractor() {}

    public Subtractor(int num1, int num2) {
        super(num1, num2);
    }

    public void calc(){
        System.out.println(getNum1() - getNum2());
    }


}
