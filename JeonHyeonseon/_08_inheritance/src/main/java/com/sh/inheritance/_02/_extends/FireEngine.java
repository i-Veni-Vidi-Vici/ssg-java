package com.sh.inheritance._02._extends;

public class FireEngine extends Car{

    /**
     * 상속시에는 부모생성자를 자동으로 먼저 호출한다.
     * - this() 클래스 자신이 다른 생성자 호출할 때 사용
     * - super() 부모클래스의 기본생성자를 호출할 때 사용
     *  - 딱한번, 맨첫줄에서만 호출가능하다.
     */
    public FireEngine(){
        super(); // 생략가능. compiler가 자동으로 작성해준다.
        System.out.println("FireEngine 기본생성자 호출!");
    }

    @Override
    public void honk(){
//        if(this.isRunning){ // 2. 부모클래스의 필드 접근제한자를 protected로 설정
        if(isRunning()){ //1. public getter 메소드를 이용해서 접근가능
            System.out.println("빵빵빠앙아아아앙아앙");
        }
        else {
            System.out.println("비켜주세요. 소방차가 지나가야합니다!! 빵빵ㅇ아앙");
        }
    }

    /**
     * 확장(부가)기능
     * - Car에는 없지만 FireEngine에는 제공하는 것
     */
    public void extinguish(){
        System.out.println("불을 끄는 중입니다..취치이ㅣ이ㅣ이잌");
    }
}
