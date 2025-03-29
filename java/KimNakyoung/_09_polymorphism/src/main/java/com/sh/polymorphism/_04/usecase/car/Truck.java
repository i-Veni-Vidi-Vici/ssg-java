package com.sh.polymorphism._04.usecase.car;

/**
 * go
 * stop
 * honk
 * load() 짐 실는 메소드
 *
 */
public class Truck extends Car implements Soundable,Loadable{
    @Override
    public void go() {
        System.out.println("트럭간다~~~~~~~");

    }

    @Override
    public void stop() {
        System.out.println("트럭멈춤");

    }

    @Override
    public void honk(String str) {

        System.out.println("트럭 빵빵");

    }
    @Override
    public void load() {
        System.out.println("짐 실으는 중입니다 비켜비켜");
    }

}
