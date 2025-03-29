package com.sh.polymorphism._04.usecase.car;

public class Truck extends Car implements Soundable, Loadable {
    @Override
    public void go() {
        System.out.println("🚛트럭이 달립니다....");

    }

    @Override
    public void stop() {
        System.out.println("🚛트럭이 멈춥니다....");

    }

    @Override
    public void honk() {
        System.out.println("🚛빠아아아아아앙~~~~");

    }

    @Override
    public void load(String str) {
        System.out.println("🚛트럭이"+str +"을 싣습니다.");

    }
}
