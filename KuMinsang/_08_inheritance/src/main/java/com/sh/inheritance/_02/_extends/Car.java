package com.sh.inheritance._02._extends;

public class Car {
    protected boolean isRunning;

    /**
     * private 필드는 상속되지만 Car이외의 클래스는 직접 접근할수 없다
     */
    /**
     * protected필드는 같은 패키지에서 접근 가능 , 자식클래스에서 접근 가능
     */

    public Car(){
        System.out.println("Car 기본 생성자 호출");

    }

    public void run(){
        this.isRunning = true;
        System.out.println("자동차가 달립니다...");
    }

    public void stop(){
        this.isRunning = false;
        System.out.println("자동차가 멈춥니다...");
    }

    public void honk(){
        if(this.isRunning){
            System.out.println("📢📢📣");
        }else{
            System.out.println("주행중일 때만 경적을 울릴수 있습니다");
        }
    }

    //boolean형이라 isisRuning이라고 써야할것 같지만 그렇게 하지는 않는다
    public boolean isRunning(){
        return this.isRunning;
    }
}
