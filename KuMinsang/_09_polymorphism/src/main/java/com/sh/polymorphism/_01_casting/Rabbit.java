package com.sh.polymorphism._01_casting;

public class Rabbit extends Animal{
    @Override
    public void eat(){
        System.out.println("🍀🍀토끼가 풀을 뜯어 먹습니다🍀🍀");
    }

    @Override
    public void cry() {
        System.out.println("🐇토끼가 운다");
    }

    @Override
    public void run() {
        System.out.println("🐇토끼는 달려");
    }

    public void jump(){
        System.out.println("토끼는 깡충깡총 뛰어");
    }
}
