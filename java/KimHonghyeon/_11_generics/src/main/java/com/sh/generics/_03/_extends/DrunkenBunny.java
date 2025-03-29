package com.sh.generics._03._extends;

public class DrunkenBunny extends Bunny{
    @Override
    public void cry(){
        System.out.println("drunken bunny cry");
    }
    public void drink(){
        System.out.println("🍻🍻");
    }
}
