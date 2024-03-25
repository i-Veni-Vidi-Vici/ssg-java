package com.sh.ineritance._02._extends;



/**
 * 상속시에는 부모생성자를 자동으로 먼저 호출한다.
 * - this() 클래스 자신의 다른 생성자 호출
 * - super() 부모 클래스의 기본 생성자 호출
 * - 딱 한번, 맨첫줄에서만 호출 가능
 */
public class FireEngine extends Car {

    /**
     * private 필드는 상속되지만, Car이외의 클래스에서는 직접 접근 할 수 없다.
     */


    private boolean isRunning = false;
    public FireEngine()
    {
        super(); //생략 가능. compiler가 자동으로 작성해줌
        System.out.println("fireEngine 기본생성자 호출 ");
    }

    @Override
    public void honk(){
     if (isRunning()){ //1. publice getter메소드를 이용해서 접근 가능
   //    if (this.isRunning){ //2. 부모 클래스의 필드 접근제한자를 protected로 사용

            System.out.println("빵빵빷");
        }
        else{
            System.out.println("비켜주세요 소방차가 지나가야 합니다 .");
        }
    }

    /**
     * 확장 기능
     * -Car에는 없지만 FireEngine에는 제공하는 것
     *
     */
    public void extingusih(){
        System.out.println("불을 끄는중입니다.");
    }
}
