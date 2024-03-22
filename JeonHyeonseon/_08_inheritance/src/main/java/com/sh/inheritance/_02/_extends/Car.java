package com.sh.inheritance._02._extends;


/**
 * 모든 클래스의 부모는 Object이다..
 */
public class Car extends Object{

    /**
     * private 필드는 상속되지만, Car이외의 클래스에서는 직접 접근할 수 없다.
     */
//    private boolean isRunning;
    /**
     * protected필드 같은 패키지 접근이 가능하고, 다른 패키지의 자식클래스에서도 직접 접근가능하다.
     */
    protected boolean isRunning;

    public Car(){
        super();  // 아무것도 상속하지 않았다면 extends Object를 한 것이다.
        System.out.println("Car 기본생성자 호출!!");
    }

    public void run(){
        this.isRunning = true;
        System.out.println("자동차가 달립니다아");
    }

    public void stop() {
        this.isRunning = false;
        System.out.println("자동차가 멈춥니다아");
    }

    public void honk(){
        if(this.isRunning) {
            System.out.println("빵빵");
        }
        else {
            System.out.println("주행중일때만 클락션을 울릴 수 있습니다");
        }
    }

    public boolean IsRunning(){
        return this.isRunning;
    }
}
