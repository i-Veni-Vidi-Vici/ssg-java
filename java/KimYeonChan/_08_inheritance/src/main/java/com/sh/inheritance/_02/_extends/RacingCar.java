package com.sh.inheritance._02._extends;

public class RacingCar extends Car {
    /**
     * RacingCar 에는 필요 없는 기능이지만, 무조건 상속 받는다.
     */
    @Override
    public void honk() {
        System.out.println("레이싱카는 경적을 울리지 않습니다...");
    }
}
