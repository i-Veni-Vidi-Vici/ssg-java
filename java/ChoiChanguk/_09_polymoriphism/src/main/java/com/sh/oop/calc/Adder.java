package com.sh.oop.calc;

public class Adder extends Calculator{
    public Adder(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public void calc() {
        System.out.printf("두 수의 합 : %d 입니다\n",num1+num2);
    }
    //더하기
}
