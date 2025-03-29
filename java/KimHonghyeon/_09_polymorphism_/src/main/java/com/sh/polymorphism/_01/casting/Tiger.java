package com.sh.polymorphism._01.casting;

public class Tiger extends Animal{
    @Override
    public void eat() {
        System.out.println("Tiger eats...🐯");
    }

    @Override
    public void run() {
        System.out.println("Tiger runs...🐅");
    }

    @Override
    public void cry() {
        System.out.println("Tiger cries...🐯");
    }

    public void bite(){
        System.out.println("Tiger bites...🐅");
    }
}
