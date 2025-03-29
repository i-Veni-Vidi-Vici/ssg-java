package com.sh.polymorphism._04.usecase.car;

public class FireEngine extends Car implements Soundable {
    @Override
    public void go() {
        System.out.println("🚒🚒🚒소방차가 달립니다...🚒🚒🚒");
    }

    @Override
    public void stop() {
        System.out.println("🚒🚒🚒소방차가 멈춥니다...🚒🚒🚒");
    }

    public void extinguish() {
        System.out.println("🚒🚒🚒소방차가 불을 끕니다...🚒🚒🚒");
    }

    @Override
    public void honk() {
        System.out.println("💥💥💥💥💥💥");
    }
}