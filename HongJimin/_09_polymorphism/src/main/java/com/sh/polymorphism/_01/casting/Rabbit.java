package com.sh.polymorphism._01.casting;

public class Rabbit extends Animal{
    @Override
    public void eat(){
        System.out.println("🐇토끼가 풀을 뜯어먹어요🐇");
    }
    @Override

    public void run(){
        System.out.println("🐇토끼가 달려요~!🐇️");
    }
    @Override

    public void cry(){
        System.out.println("🐇토끼가 울어요ㅜㅡㅜ🐇");
    }

    public void jump() {
        System.out.println("🐇토끼가 점프해요~~~!🐇");
    }
}
