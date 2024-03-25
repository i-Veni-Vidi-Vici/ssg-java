package com.sh.inheritance._02._extends;

public class Car extends Object {
    /**
     * private필드는 상속되지만, Car 이외의 클래스에서는 직접 접근할 수 없다.
     */
    private boolean isRunning;
    /**
     * protected필드 같은 패키지 접근, 다른 패키지의 자식클래스에서도 직접 접근 가능하다.
     */
//    protected boolean isRunning;

    public Car() {
        super();
        System.out.println("Car 기본생성자 호출!!!");
    }

    public void run(){
        this.isRunning = true;
        System.out.println("자동차가 달립니다...");
    }

    public void stop() {
        this.isRunning = false;
        System.out.println("자동차가 멈춥니다...");
    }

    public void honk() {
        if(this.isRunning) {
            System.out.println("빵빵~");
        }
        else {
            System.out.println("주행중일때만 클락션을 울릴수 있습니다...");
        }
    }

    public boolean isRunning() {    // public getter 메소드
        return this.isRunning;
    }
}