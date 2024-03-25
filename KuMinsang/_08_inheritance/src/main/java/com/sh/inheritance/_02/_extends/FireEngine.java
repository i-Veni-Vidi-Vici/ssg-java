package com.sh.inheritance._02._extends;

public class FireEngine extends Car{
    /**
     *  상속시에는 부모 생성자를 자동을 먼저 호출한다.
     *  - this 클래스 자신의 다른 생성자 호출
     *  - super() 부모 클래스의 기본 생성자 호출
     */
    public FireEngine(){
        super();//부모 생성자의 기본 생성자를 호출하며 생략 가능하고 생략하면 컴파일러가 기본을 작성해줌
        System.out.println("FireEngine 기본 생성자 호출");
    }

    @Override
    public void honk(){
        if(isRunning){  //car의 isRunning의 접근 제한자가 private면 접근 불가
                        //=> 2. 부모클래스의 필드 접근 제한자를 protected로 설정
//        if(isRunning()){    // 1. public getter메소드를 이용해서 접근
            System.out.println("📢📢📢📢📢📢📢📢📢📢📢📢📢📢📢📢📢📢📢📢📢📢📢📢📢📢📢📢");
        }else{
            System.out.println("비켜주세요 소방차가 지나가야 합니다📣📣📣📣📣📣📣");
        }
    }
    /**
     * 확장기능
     * - Car에는 없지만 FireEngine에는 있어야 하는 기능
     */
    public void extinguish(){
        System.out.println("불을 끄는 중입니다............애애애애오오오오옹옹");
    }
}
