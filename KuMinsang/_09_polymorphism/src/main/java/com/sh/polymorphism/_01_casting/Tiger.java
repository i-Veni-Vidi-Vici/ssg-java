package com.sh.polymorphism._01_casting;

public class Tiger extends Animal {
    @Override
    public void eat() {
        System.out.println("🐯호랑이가 먹이를 먹습니다");
    }

    @Override
    public void run() {
        System.out.println("🐯호랑이가 달립니다....");
    }

    @Override
    public void cry() {
        System.out.println("🐯호랑이는 울부짖어");
    }

    public void bite(){
        System.out.println("🐯호랑이는 사람을 물어");
    }


}
