package com.sh.polymorphism._04.usecase.car;

/**
 * go
 * stop
 * honk
 * load : 짐 싣다
 */
public class Truck extends Car implements Soundable, Loadable{
    @Override
    public void go() {
        System.out.println("🚚 트럭이 움직입니다...");
    }

    @Override
    public void stop() {
        System.out.println("🚚 트럭이 멈춥니다...");
    }

    @Override
    public void honk() {
        System.out.println("🚚 뿌앙~~");
    }

    @Override
    public void load(String str) {
        System.out.println("🚚 트럭이" + str + "을/를 싣는중입니다...");
    }
}
