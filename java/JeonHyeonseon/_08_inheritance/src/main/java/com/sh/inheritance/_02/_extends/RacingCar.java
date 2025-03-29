package com.sh.inheritance._02._extends;

public class RacingCar extends Car{
//    public RacingCar(){
//        super();
//    } 4 - 6줄은 써도 되고 안써도 된다

    /**
     * RacingCar에는 필요없는 기능이지만, 무조건 상속받는다.
     *  - 불필요한 기능도 어쩔 수 없이 모두 상속받게 된다.
     */
    @Override
    public void honk(){
        System.out.println("레이싱카는 경적을 울리지 않습니다.");
    }
}
