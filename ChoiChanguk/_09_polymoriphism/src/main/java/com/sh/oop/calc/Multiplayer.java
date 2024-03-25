package com.sh.oop.calc;

public class Multiplayer extends Calculator{
    //곱하기
    public Multiplayer(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public void calc() {
        System.out.printf("두 수의 곱 : %d 입니다\n",num1*num2);
    }
}
