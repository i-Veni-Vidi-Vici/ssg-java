package com.sh.polymorphism_04._usecase.car;

public class FireEngine extends Car implements Soundable{
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void go() {
        System.out.println("🚒가 달립니다.");

    }

    @Override
    public void stop() {
        System.out.println("🚒가 멈춥니다.");
    }

    @Override
    public void honk(){
        System.out.println("🚒빵!.");

    }
}
