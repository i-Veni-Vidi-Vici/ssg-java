package com.sh.generics._03._extends;

public class DrunkenBunny extends Bunny{
    @Override
    public void cry() {
        super.cry();
        System.out.println("🐰🍺🐰🍺🐰🍺🐰");
    }
}
