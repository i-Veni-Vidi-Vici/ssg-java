package com.sh.inheritance._02_extends;

public class RacingCar extends Car {
    /**
     * RacingCar에는 필요없는 기능이지만, 무조건 상속받음
     */
    @Override
    public void honk(){
        System.out.println("레이싱카는 경적을 울리지 않습니다.");
    }
}
