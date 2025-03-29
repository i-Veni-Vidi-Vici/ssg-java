package com.sh.polymorphism._04_usecase.car;
/**
 * go()
 * stop()
 * honk() 빵빵
 * load() 짐을 싣다
 */
public class Truck extends Car implements Soundable, Loadable {

    @Override
    public void go() {
        System.out.println("🚛 트럭이 달립니다...");
    }

    @Override
    public void stop() {
        System.out.println("🚛 트럭이 멈춥니다...");
    }

    @Override
    public void load() {
        System.out.println("🚛 트럭이 짐을 싣습니다...");
    }

    @Override
    public void honk() {
        System.out.println("🚛트럭이 경적을 울립니다! 빵~~~빠아빠빠빠빠아아앙~~~!");
    }
}
