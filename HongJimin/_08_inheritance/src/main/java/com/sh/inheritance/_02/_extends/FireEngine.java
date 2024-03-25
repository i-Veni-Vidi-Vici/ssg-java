package com.sh.inheritance._02._extends;

public class FireEngine extends Car{
    /**
     * 상속 시에는 부모 생성자를 자동으로 먼저 호출한다.
     * - this( ) 클래스 자신의 다른 생성자 호출
     * - super() 부모 클래스의 기본생성자 호출
     */

    public FireEngine() {
        super(); //생략 가능. compiler가 자동으로 작성해줌
        System.out.println("FrieEngine 기본 생성자 호출!");
    }

    @Override
    public void honk() {
        if (this.isRunning) {//2. 부모 클래스의 필드 접근 제한자를 protected로 작성
//        if (isRunning()) { //1. public getter 메소드를 이용해 접근 가능
            System.out.println("빵빵ㅂ아바압ㅇ빵빠아ㅃ아ㅃ아빵");
        }
        else {
            System.out.println("비켜주세요~~ 소방차가 지나가야 합니다~!~! 빵ㅃ아방방방ㅂ빵빵");
        }
    }

    /**
     * 확장 기능
     * - Car에는 없지만 FireEngine에는 제공하는 것
     */
    public void extinguish() {
        System.out.println("불 끄는 중,,💦💦💦💦💦");
    }
}
