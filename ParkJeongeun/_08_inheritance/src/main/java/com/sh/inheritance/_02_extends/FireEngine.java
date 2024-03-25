package com.sh.inheritance._02_extends;

/**
 * 상속 시 부모생성자를 자동으로 먼저 호출함
 * - this() : 클래스 자신의 다른 생성자 호출
 * - super() : 부모클래스의 기본생성자 호출
 *   - 딱 한번, 맨 첫줄에서만 호출가능
 */

public class FireEngine extends Car {
    public FireEngine(){
        super(); // 생략해도 compiler가 자동작성해줌
        System.out.println("FireEngine 기본생성자 호출!");
    }

    @Override
    public void honk(){
//        if (this.isRunning) { // Car클래스에서 isRunning이 private이어서 사용X
        if (isRunning()){ // 1. getter메소드 사용 (2번보다 1번 사용하기)
//        if (this.isRunning) {  // 2. 부모클래스의 필드 접근제한자를 protected로 설정
            System.out.println("빵빵빵빵빵빵빵빵빵!");
        } else {
            System.out.println("비켜주세요. 소방차가 지나가야합니다!");
        }
    }

    /**
     * 확장 기능
     */
    public void extinguish(){
        System.out.println("불을 끄는 중입니다.");
    }
}
