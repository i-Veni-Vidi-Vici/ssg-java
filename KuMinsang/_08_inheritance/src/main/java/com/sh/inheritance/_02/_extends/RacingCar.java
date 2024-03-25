package com.sh.inheritance._02._extends;

public class RacingCar extends Car{
    /**
     * honk는 RacingCar에 필요 없는 기능이지만 상속 포기할 방법이 없다
     * - 불필요한 기능도 어쩔수 없이 모두 상속받게 된다
     */
    @Override
    public void honk(){
        System.out.println("레이싱카는 경적을 울리지 않습니다...");
    }
}
