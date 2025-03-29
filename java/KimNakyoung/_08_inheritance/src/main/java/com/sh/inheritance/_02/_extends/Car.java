package com.sh.inheritance._02._extends;

public class Car extends  Object{

    // 캡슐화 적용

    /**
     * private 필드는 상속되지만, Car이외의 클래스에서는 직접 접근 할 수 없다.
     *
     */

    private  boolean isRunning;


    /**
     * protected필드 같은 패키지 접근, 다른패키지의 자식클래스에서도 ! 직접 접근가능 !
     */
//    protected boolean isRunning;


    public Car() {
        super();  // 생략 되있는데 카의 부모는 머임? 아무것도 상속되어있지 않는 경우 extends  Object 되어있는거임
        System.out.println("Car 기본생성자 호출");
    }

    public void run(){
        this.isRunning = true; // 자동차 달리니까 트루로 바꿔주기
        System.out.println("자동차 달림.....");
    }

    public void stop(){
        this.isRunning = false;
        System.out.println("자동차 멈춤.....");
    }

    public void honk() {
        // 클락션
        if(this.isRunning == true) {
            System.out.println("🚨🚨🚨");
        }
        else {
            System.out.println("주행중일 때만 클락션 울릴 수 있습니다");
        }
    }

    //getter

    //필드가 이미 isRunning이라고 되어있지만 그냥 쓴다.
    public boolean isRunning() {
        return this.isRunning;
    }
}
