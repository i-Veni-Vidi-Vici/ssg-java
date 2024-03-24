package com.sh.ineritance._02._extends;

public class RacingCar extends Car
{
    /**
     * RacingCar에서는 필요없는 기능이지만, 무조건 상속받는다.
     * - 불필요한 기능도 어쩔수 없이 모두 상속받게 된다.
     */
    @Override
    public void honk(){
        System.out.println("레이싱카는 경적을 울리지 않습니다..");
    }
}
