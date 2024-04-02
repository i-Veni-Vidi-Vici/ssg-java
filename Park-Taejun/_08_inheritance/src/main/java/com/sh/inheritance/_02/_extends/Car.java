package com.sh.inheritance._02._extends;

public class Car { // 아무것도 상속하지 않앆다면 extends Object가 생략된것과 같음 object로 물려받은 field는 없ㅇㅁ
    // 모든 클래스의 부모는 object이다.
    /**
     * protected 필드 같은 패키지도 접근이 가능하지만, 다른 패키지의 자식클래스에서도 직접 접근이 가능하다.
     */
    private boolean isRunning;
//    protected boolean isRunning;

    public Car() {
        //super();
        /**
         *p private 필드는 상속되지만, Car 이외의 클래스에서는 직접 접근할 수 없음.
         */
        //기본 생성자
        System.out.println("Car 기본생성자 호출!!!");
    }

    public void run() {
        this.isRunning = true;
        System.out.println("자동차가 달립니다...");
    }

    public void stop() {
        this.isRunning = false;
        System.out.println("자동차가 멈춥니다...");

    }

    public void honk() {
        if (this.isRunning) {
            System.out.println("빵빵!!");
        } else {
            System.out.println("주행중일때만 클락션을 울리 수 있습니다....");
        }
    }

    public boolean isRunning(){
        return this.isRunning;
    }
}