package com.sh.ineritance._02._extends;

/**
 * private 필드는 상속되지만, Car 이외의 클래스에서는 직접 접근할 수 없다.
 *
 * protected 필드 같은 패키지 접근, 다른패키지의 자식 클래스에서도 직접 접근 가능하다.
 */
public class Car {
 //  private boolean isRunning ;
    protected boolean isRunning ;

    public Car()
    {
        System.out.println("기본 생성자 호출 ! ");
    }
    public void run(){
        this.isRunning = true;
        System.out.println("자동차가 달린다.");

    }

    public boolean isRunning() {
        return isRunning;
    }

    public void stop()
    {
        this.isRunning = false;
        System.out.println("자동차가 멈춥니다.");

    }

    public void honk()
    {
        if(this.isRunning) System.out.println("빵빵");
        else {
            System.out.println("주힝중일 떄만 클락션을 울릴 수 있습니다.");
        }

    }

    public boolean Istrue(){
        return this.isRunning;
    }

}
