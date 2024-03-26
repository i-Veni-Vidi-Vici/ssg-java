package com.sh.polymorphism._04_usecase.car;

public class FireEngine extends Car implements Soundable{

    @Override
    public void go(){
        System.out.println("🚒소방차는 멈추지 않아 BOY..❤");
    }

    @Override
    public void stop(){
        System.out.println("🚒소방차가 멈춥니다...");
    }

    public void extinguish(){
        System.out.println("🚒소방차가 불을 끕니다...");
    }

    @Override
    public void honk() {
        System.out.println("🚒빵~~~~~ㅋㅋ~~~~");
    }
}
