package com.sh.inheritance._02._extends;

public class RacingCar extends Car {
//    public  RacingCar(){
//        super();
//    }
    // 생성자 안에서 할게 없다면 생략가능
//


    /**
     *
     * RacingCar 에는 필요없는 기능이지만, 무조건 상속 받는다.
     * - 불필요한 기능도 어쩔 수 없이 모두 상속받게 된다.
     *
     */
    @Override
    public void honk(){
        System.out.println("레이싱카는 경적을 울리지 않습니다...");
    }
    // alt + insert 하고 오버라이딩 메소드 하면 부모 클래스에서 뭐 오버라이딩 할껀지 선택하면 됨
}
