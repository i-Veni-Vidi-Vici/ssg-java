package com.sh.inheritance._01.simple;

public class GrandChild extends Child {
    @Override
    public void introduce(){
        System.out.println("손자입니다~~~");
    }

    @Override
    public void game() {
        System.out.println("피파 중입니다!");
    }
}
