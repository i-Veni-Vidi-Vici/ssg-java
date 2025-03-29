package com.sh.polymorphism._01.casting;

public class Rabbit extends Animal{
    @Override
    public void eat() {
        System.out.println("토끼가 풀을 뜯어 먹습니다...");
    }
    public void run() {
        System.out.println("토끼가 달립니다...");
    }
    public void cry() {
        System.out.println("토끼가 울음소리를 냅니다...");
    }
    public void jump() {
        System.out.println("토끼가 점프합니다. 깡총깡총...");
    }
}
