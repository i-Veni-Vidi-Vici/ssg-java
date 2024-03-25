package com.sh.polymorphism._04.usecase.car;

public class Truck extends Car implements Soundable, Loadable{
    @Override
    public void go() {
        System.out.println("🚛 트럭이 달립니다...");
    }

    @Override
    public void stop() {
        System.out.println("🚛 트럭이 멈춥니다...");
    }

    @Override
    public void honk() {
        System.out.println("🚛 트럭 경적 빵빵~~~");
    }

    @Override
    public void load(String str) {
        System.out.println("🚛 트럭에" + str + "를 싣습니다.");
    }

}
