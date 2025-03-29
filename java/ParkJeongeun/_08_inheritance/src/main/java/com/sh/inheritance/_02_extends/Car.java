package com.sh.inheritance._02_extends;

public class Car {

    /**
     * private 필드도 상속되지만, Car 이외의 클래스에서는 직접 접근 못함
     *
     * protected 필드
     * - 같은 패키지 접근 가능
     * - 다른 패키지의 자식 클래스에서 직접 접근 가능
     */
    private boolean isRunning;
//    protected boolean isRunning;

    public Car(){
//        super(); // 생략되어있음(아무것도 상속하지 않은 클래스에는 extends Object 생략되어있음)
        System.out.println("Car 기본생성자 호출!");
    }
    public void run(){
        this.isRunning = true;
        System.out.println("자동차가 달립니다.");
    }

    public void stop(){
        this.isRunning = false;
        System.out.println("자동차가 멈춥니다.");
    }

    public void honk(){
        if (this.isRunning == true){
            System.out.println("빵빵🌞");
        } else {
            System.out.println("주행 중에만 클락션을 울릴 수 있습니다.");
        }
    }

    public boolean isRunning(){ // boolean타입의 getter 생성시 필드명이 이미 is로 시작하면 is를 추가로 더 붙이지 않아도 됨
        return this.isRunning;
    }
}
