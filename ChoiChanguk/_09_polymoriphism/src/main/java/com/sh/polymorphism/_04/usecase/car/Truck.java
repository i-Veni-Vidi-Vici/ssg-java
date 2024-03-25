package com.sh.polymorphism._04.usecase.car;

/**
 * go
 * stop
 * honk
 * load() //적재 하다
 */
public class Truck extends Car implements Soundable, Loadable {
    @Override
    public void go() {
        System.out.println("트럭이 갑니다");
    }

    @Override
    public void stop() {
        System.out.println("드럭이 멈춥니다");
    }

    @Override
    public void honk() {
        System.out.println("트럭이 갑니다~ 부딛치면 아파요~~~");
    }

    @Override
    public void load(String str) {
        System.out.println("트럭에 str(를)을 많이 적재합니다 ");
    }
}
