package com.sh.polymorphism._04.usercase.car;

public class FireEngine extends Car implements Soundable{
    @Override
    public void go() {
        System.out.println("FireEngine Goes..🚒");
    }

    @Override
    public void stop() {
        System.out.println("FireEngine stops..🚒");
    }

    public void extinguish(){
        System.out.println("FireEngine extinguishes..🌊");
    }

    @Override
    public void honk() {
        System.out.println("FireEngine Honks..pee..poo..pee..poo🚨");
    }
}
