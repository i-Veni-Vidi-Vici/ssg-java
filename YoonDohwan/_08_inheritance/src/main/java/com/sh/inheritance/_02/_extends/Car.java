package com.sh.inheritance._02._extends;

public class Car {
    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    /**
     * private 필드는 상속되지만, Car이외의 클래스에서는 직접 접근할 수 없다.
     */
    protected boolean isRunning;

    /**
     * protected 필드 같은 패키지 접근, 다른패키지의 ㅈ
     */
    public Car(){
        System.out.println("Car 기본생성자 호출!!!");
    }
    public void run(){
        this.isRunning=true;
        System.out.println("자동차가 달립니다....");
    }
    public void stop(){
        this.isRunning=false;
        System.out.println("자동차가 멈춥니다....");
    }
    public void hank(){
        if(this.isRunning){
            System.out.println("빵빵");
        }
        else{
            System.out.println("주행중일 때만 클락션을 울릴 수 있습니다.");
        }
    }
}
