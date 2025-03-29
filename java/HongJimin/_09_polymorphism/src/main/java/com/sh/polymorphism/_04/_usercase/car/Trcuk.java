package com.sh.polymorphism._04._usercase.car;

/**
 * go
 * stop
 * honk  - 빵빵
 * load - 적재하다
 */
public class Trcuk extends Car implements Soundable, Loadable{
    @Override
    public void go() {
        System.out.println("🚚트럭이 달립니다~!~");
    }

    @Override
    public void stop() {
        System.out.println("🚚트럭이 멈춥니다..");
    }

    @Override
    public void honk() {
        System.out.println("🚚빠라빠라랄라ㅏㄹ");
    }

    @Override
    public void load() {
        System.out.println("🧱짐을 싣습니다");
    }
}
