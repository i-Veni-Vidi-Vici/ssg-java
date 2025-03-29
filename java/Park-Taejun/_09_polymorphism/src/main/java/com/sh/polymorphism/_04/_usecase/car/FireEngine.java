package com.sh.polymorphism._04._usecase.car;

public class FireEngine extends Car implements Soundable {


    @Override
    public void go(){
        System.out.println("소방차가 달립니다 .. .");
    }

    @Override
    public void stop(){
        System.out.println("소방차가 멈춥니다");
    }

    public void extinguish(){
        System.out.println("🧑‍🚒소방관이 불을 끕니다...");
    }

    @Override
    public void honk(String str) {
        System.out.println("🧑🏻‍🚒 뿌아앙아아아부아앙아앍 뽕뽕뽕");
    }
}
