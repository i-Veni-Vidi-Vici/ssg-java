package com.sh.inheritance._02_extends;

public class Car {
    /**
     * private 필드는 상속되지만, Car이외에 클래스에서는 직접접근 불가
     *
     * ptotected
     */
    private boolean isRunning;

    public Car() {
        System.out.println("Car 기본생성자 호출됨");
    }

    public void run() {
        this.isRunning=true;
        System.out.println("자동차가 달립니다...");
    }

    public void stop() {
        this.isRunning=false;
        System.out.println("자동차가 멈춥니다...");
    }

    public void honk() {
        if(this.isRunning)
        {
            System.out.println("빵빵~~");
        }
        else {
            System.out.println("주행중일때만 클락션을 울릴 수 있습니다.");
        }
    }

    public boolean isRunning()
    {
        return this.isRunning;
    }

}
