package com.sh.inheritance._02_extends;

public class FireEngine extends Car{


    /**
     * 상속시에는 부모생성자를 먼저 호출한다
     * - this() 클래스 자신의 다른 생성자 호출
     * - super() 부모클래스의 기본생성자 호출
     * - 딱 한 번, 맨첫줄에서만 호출가능
     */
    public FireEngine(){
        super();// 생략가능 compiler 자동으로 작성해줌
        System.out.println("FireEngine 기본생성자 호출");
    }

    @Override
    public void honk() {
//        if(this.isRunning){
//            //1. pulic getter 메소드를 이용해서 접근 가능
//            //2. 부모클래스에서 접근제한자를 protected로 하면 가능
//        }

        if(isRunning())
        {
            System.out.println("빵빵빵빵빵빵빵빵빵빵빵빵빵빵빵빵빵빵빵");
        }
        else {
            System.out.println("비켜쥇요~~~ 소방차가 지나가야 합니다~~~~");
        }

    }

    /**
     * 확장기능
     * - Car에는 없지만 FireEngine에는 제공하는 것.
     */
    public void extinguish() {
        System.out.println("불을 끄는 중입니다~~~~쉬이이이이익~~~");
    }
}
