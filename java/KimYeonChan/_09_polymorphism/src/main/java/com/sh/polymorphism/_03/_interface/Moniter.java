package com.sh.polymorphism._03._interface;

public class Moniter implements IProduct {
    @Override
    public void printInfo() {
        System.out.println("모니터");
    }

    public void blink() {
        System.out.println("깜빡이는 중");
    }
}
