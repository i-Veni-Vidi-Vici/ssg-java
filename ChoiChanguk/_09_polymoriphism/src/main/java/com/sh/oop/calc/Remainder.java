package com.sh.oop.calc;

public class Remainder extends Calculator{
    //나머지

    public Remainder(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public void calc() {
        System.out.printf("num1/num2 나머지 : %d 입니다\n",num1%num2);
    }
}
