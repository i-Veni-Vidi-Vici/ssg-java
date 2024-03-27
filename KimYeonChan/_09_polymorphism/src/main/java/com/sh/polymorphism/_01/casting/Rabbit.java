package com.sh.polymorphism._01.casting;

public class Rabbit extends Animal{
    @Override
    public void eat() {
        System.out.println("\uD83D\uDC30토끼가 풀을 뜯어 먹습니다...");
    }

    @Override
    public void run() {
        System.out.println("\uD83D\uDC30토끼가 달립니다.");
    }

    @Override
    public void cry() {
        System.out.println("\uD83D\uDC30토끼가 울음 소리를 냅니다.");
    }

    public void jump() {
        System.out.println("토끼가 튀어오릅니다.");
    }
}
