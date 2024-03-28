package com.sh.generics._03._extends;

public class Bunny extends Rabbit{
    @Override
    public void cry() {
        super.cry();
        System.out.println("🐰🐰🐰🐰🐰🐰🐰🐰");
    }
}
