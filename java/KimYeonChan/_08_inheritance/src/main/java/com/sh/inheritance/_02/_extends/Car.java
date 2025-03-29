package com.sh.inheritance._02._extends;

public class Car {
    /**
     * private 필드는 상속되지만, Car 이외의 클래스에서는 직접 접근할 수 없다.
     * protected 필드 같은 패키지 접근, 다른패키지의 자식클래스에서도 직접 접근 가능하다.
     */
    protected boolean isRunning;

    public Car() {
        System.out.println("Car 기본 생성자 호출");
    }

    public void run() {
        isRunning = true;
        System.out.println("자동차가 달립니다.");
    }

    public void stop() {
        isRunning = false;
        System.out.println("자동차가 멈춥니다.");
    }

    public void honk() {
        if (this.isRunning) {
            System.out.println("bread");
        }
        else {
            System.out.println("주행 중일 때만 클락션을 울릴 수 있습니다.");
        }
    }

    public boolean isRunning() {
        return this.isRunning;
    }
}
