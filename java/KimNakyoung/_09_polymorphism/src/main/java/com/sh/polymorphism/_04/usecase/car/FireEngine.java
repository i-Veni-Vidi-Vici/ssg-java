package com.sh.polymorphism._04.usecase.car;

// 추상메소드 있으면 꼭 구현ㅅ해줘라
public class FireEngine extends Car implements Soundable{
    @Override
    public void go() {
        System.out.println("소방차 달림");
    }

    @Override
    public void stop() {
        System.out.println("소방차 멈춤");
    }

    public void extinguish(){
        System.out.println("소방차가 불을 끕니다~~~~~~~~~~~~~~~");
    }

    // 추상메소드인 honk 구현해줘라!! 그래야 오류 안난다!
    @Override
    public void honk(String str) {
        System.out.println("빵ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ아앙");
    }



}
