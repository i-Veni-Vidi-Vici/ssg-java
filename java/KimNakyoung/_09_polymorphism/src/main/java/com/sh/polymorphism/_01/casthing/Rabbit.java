package com.sh.polymorphism._01.casthing;

public class Rabbit extends Animal{
    @Override
    public void eat(){
        System.out.println("토끼☁가 풀을 뜯어 먹습니다.....");
    }
    @Override
    public void run(){
        System.out.println("토끼 달림");
    }
    @Override
    public void cry(){
        System.out.println("토끼 울음 ...끼잉");
    }

    public void jump(){
        System.out.println("토끼 점프 깡총깡총");
    }

}
