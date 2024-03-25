package com.sh.polymorphism._01.casting;

public class Tiger extends Animal {
    @Override
    public void eat() {
        System.out.println("🐯호랑이가 먹이를 먹어요🐯");
    }

    @Override
    public void run() {
        System.out.println("🐯호랑이 달려~🐯");
    }

    @Override
    public void cry() {
        System.out.println("🐯호랑이 운다~ 어흥!-!🐯");
    }

    public void bite() {
        System.out.println("🐯호랑이가 물어요 꺅🐯");
    }
}
