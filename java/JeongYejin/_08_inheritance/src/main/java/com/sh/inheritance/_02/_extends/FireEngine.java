package com.sh.inheritance._02._extends;

public class FireEngine extends Car {

    /**
     * 상속시에는 부모생성자를 자동으로 먼저 호출한다.
     * - this() 클래스 자신의 다른 생성자 호출
     * - super() 부모클래스의 기본생성자 호출
     * - 딱 한번, 맨 첫줄에서만 호출 가능
     */
    public FireEngine() {
        super(); // 생략가능. compiler 자동으로 작성해줌.
        System.out.println("FireEngine 기본생성자 호출!");
    }

    @Override
    public void honk() {
//        if (this.isRunning) { // 부모클래스의 필드 접근제한자를 protected로 설정
        if (isRunning()) { // public getter 메소드를 이용해서 접근 가능
            System.out.println("💥💥💥💥💥💨💨💨💨💨💨");
        } else {
            System.out.println("비켜주세요! 소방차 지나가요!");
        }
    }

    /**
     * 확장기능
     * - Car에는 없지만 FireEngine에는 제공하는 것.
     */
    public void extinguish() {
        System.out.println("---------");
    }
}
