package com.sh.inheritance._02._extends;

public class RacingCar extends Car {

//    public RacingCar() {
//        super();
//    }

    /**
     * <pre>
     *     RacingCar에는 필요 없는 기능이지만, 무조건 상속 받는다.
     *     - 불필요한 기능도 어쩔 수 없이 모두 상속받게 된다.
     * </pre>
     */
    @Override
    public void honk() {
        System.out.println("");
    }
}
