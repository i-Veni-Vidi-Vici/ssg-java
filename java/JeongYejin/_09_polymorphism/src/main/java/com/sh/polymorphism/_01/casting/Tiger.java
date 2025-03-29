package com.sh.polymorphism._01.casting;

public class Tiger extends Animal {

    @Override
    public void eat() {
        System.out.println("🐅🐅🐅호랑이가 먹이를 먹습니다...🥩🥩🥩");
    }

    @Override
    public void run() {
        System.out.println("🐅🐅🐅호랑이가 달립니다...🐅🐅🐅");
    }

    @Override
    public void cry() {
        System.out.println("🐯🐯🐯호랑이가 울부짖습니다...어흥🐯🐯🐯");
    }

    public void bite() {
        System.out.println("🐅🐅🐅호랑이가 물어뜯습니다...🐅🐅🐅");
    }

}
