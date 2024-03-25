package com.sh.polymorphism._01.casting;

import java.util.jar.Attributes;

public class Rabbit extends Animal {
    @Override
    public void eat(){
        System.out.println("토끼가 풀을 뜯어 먹습니다🐇🐇🐇");
    }@Override
    public void run(){
        System.out.println("토끼가 달립니다🐇🐇🐇");
    }@Override
    public void cry(){
        System.out.println("토끼가 웁니다🐇🐇🐇");

    }

    public void jump() {
        System.out.println("토끼가 점프를 깡총깡총합니다🐇🐇🐇");
    }
}
