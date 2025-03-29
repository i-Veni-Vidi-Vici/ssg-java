package com.sh.inheritance._02._extends;

public class FireEngine extends Car {

    /**
     * 상속시에는 부모생성자를 자동으로 먼저 호출하게 됨.
     * -this () 클래스 자신의 다른 생성자 호출
     * -super() 부모클래스의 기본생성자 호출
     * -딱한번, 맨첫줄에서만 호출이 가능함 this 도 마찬가지임
     */
    public FireEngine() {
        super(); // 이코드가 생략되어 있다고 봐야함 compiler가 자동으로 작성해줌. 이걸 밑에줄로 내린다거나 두번은 못씀
        System.out.println("FireEngine 기본생성자 호출!!");
    }

    @Override
    public void honk() {
//        if(this. isRunning){ //car의 isRunning 의 접근제한자가 private로 되어있기 때문임. 부모클래스의 필드 접근제한자를 protected로 설정하는 방법이 있음
        if (isRunning()) { // public getter 메소드를이용해서접근이 간으함 isRunning이 직접 접근 불가능해서
            System.out.println("빠아아아ㅏㅇ아아아아아아ㅏ앙우아아ㅏㅇ!!");

        } else {
            System.out.println("비켜주세요~~~ 소방차가 지나가야합니다~~~~~");
        }
    }
    /**
     * 확장기능
     * -Car에는 없지만 FireEngine에는 제공하는것
     */
    public void extinguish(){
        System.out.println("불을 끄는 중입니다..........추이이이이이이잉 이잉ㅇ!!");
    }
}