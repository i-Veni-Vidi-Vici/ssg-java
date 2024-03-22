package com.sh.inheritance._02._extends;

// Car 클래스 상속

public class FireEngine extends Car {


    /**
     * 상속시에는 부모생성자를 자동으로 먼저 호출한다.
     * - this() 클래스 자신의 다른 생성자
     * - supper() 부모클래스의 기본생성자 호출
     * - 딱한번, !맨첫줄!에서만 호출가능
     */
    public FireEngine() {
        super(); // 생략가능 compiler 자동으로 작성해줌
        System.out.println("FireEngine 기본생성자 호출!");
    }

    @Override
    public void honk() {
//        if (isRunning) {
//        }
        // private로 선언한 것을 어떻게 접근할까?


        // 1. public getter 메소드를 이용해서 접근 가능
        if(isRunning()) {
            System.out.println("빵ㅇ삐ㅏㅇ바압아ㅏㅂ아ㅏ바아바ㅏㅏ아바ㅏ");
        }

//        //2. 상속받은 클래스(Car)가서 접근제한자를 protected로 바꾸기
//        if(this.isRunning) {
//
//        }
        else {
            System.out.println("비켜주세요~ 소방자가 지나나가야함니다.");

        }
    }

    /**
     *
     * 확장기능
     * -Car에는 없지만 FireEngine에는 제공하는것.
     */
    public void extinguish(){
        System.out.println("불을 끄는 중입니다..................취이이이잌~~~~~~🚒🚒");
    }
}
