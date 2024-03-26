package com.sh.polymorphism._04.usecase.car;

/**
 * go()
 * stop() 멈춰
 * honk() 빵빵
 * load() 짐 실다
 */
public class Truck extends Car implements Soundable, Loadable {
    @Override
    public void go() {
        System.out.println("🚚🚚트럭이 지나갑니다🚚🚚");
    }

    @Override
    public void stop() {
        System.out.println("🚚트럭이 멈춥니다🚚");
    }

    // soundable 인터페이스 구현
    @Override
    public void honk() {
        System.out.println("🚚트럭이 빵빵~~~~!!! 합니다");
    }

    // loadable 인터페이스 구현
    @Override
    public void load(String str) {
        System.out.println("🚚트럭에" + str + "을 싣습니다.");
    }
}
