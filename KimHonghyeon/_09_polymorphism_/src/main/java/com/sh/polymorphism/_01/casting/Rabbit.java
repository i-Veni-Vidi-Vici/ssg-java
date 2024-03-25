package com.sh.polymorphism._01.casting;

public class Rabbit extends Animal{
    @Override
    public void eat() {
        System.out.println("Rabbit eats...🐰");
    }

    @Override
    public void run() {
        System.out.println("Rabbit runs...🐇");
    }

    @Override
    public void cry() {
        System.out.println("Rabbit cries...🐰");
    }

    public void jump(){
        System.out.println("Rabbit jumps...🐇");
    }
}
