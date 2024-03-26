package com.sh.polymorphism._04.usecase.car;

/**
 * go()
 * stop()
 * honk() 빵빵
 * load() 짐 싣다
 */
public class Truck extends Car implements Soundable, Loadable{

    @Override
    public void go() {
        System.out.println("🚚 트럭이 달립니다!");
    }

    @Override
    public void stop() {
        System.out.println("🚚 트럭이 멈춥니다!");
    }

    @Override
    public void honk() {
        System.out.println("🚚 빵빵!!");
    }


    @Override
    public void load(String str) {
        System.out.println("🚚 트럭에" + str + "을 싣습니다!");
    }
}
