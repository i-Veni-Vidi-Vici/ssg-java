package com.sh.polymorphism._04._usercase.car;

public class FireEngine extends Car implements Soundable{

    @Override
    public void go() {
        System.out.println("🚒소방차가 달립니다!");
    }

    @Override
    public void stop() {
        System.out.println("🚒소방차가 멈춥니다~~");
    }

    public void extinguish(){
        System.out.println("🚒소방차가 불을 끕니다..");
    }

    @Override
    public void honk() { //Soundable interface에서 물려받은 것
        System.out.println("🚒 빵빵빵ㅂ빵ㅃㅃㅃ압아ㅃㅇ빵ㅂㅇ빵");

    }
}

