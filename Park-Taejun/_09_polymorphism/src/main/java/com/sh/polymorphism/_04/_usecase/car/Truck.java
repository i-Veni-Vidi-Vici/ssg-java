package com.sh.polymorphism._04._usecase.car;

/**
 * go
 * stop
 * honk 빵빵
 * load () 짐을 싣는 메소드
 */
public class Truck extends Car implements Soundable, Loadable{

    @Override
    public void go() {
        System.out.println("🍗🍗🍗갑니다");

    }

    @Override
    public void stop() {
        System.out.println("🍗🍗멈춥니다");

    }

    public void honk(String str){
        System.out.println("🍗🍗빵빵");



    }



    @Override
    public void load(String str) {
        System.out.println("🍗🍗트럭에 " + str + "를 싣습니다,,,");

    }
}
