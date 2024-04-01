package com.sh.polymorphism_04._usecase.car;

public class Truck extends Car implements Soundable, Loadable
{
    @Override
    public void go() {
        System.out.println("🚛이 출발합니다.");

    }

    @Override
    public void stop() {
        System.out.println("🚛이 멈춥니다. ");

    }

    @Override
    public void honk() {
        System.out.println("🚛이 경적 소리를 냅니다.");

    }


    @Override
    public void load(String str){
        System.out.println(str+"를 트럭에 짐을 실어요.");
    }
}
