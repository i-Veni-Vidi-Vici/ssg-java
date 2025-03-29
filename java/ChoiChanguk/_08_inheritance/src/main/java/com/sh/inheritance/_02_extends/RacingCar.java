package com.sh.inheritance._02_extends;

public class RacingCar extends Car{

//    public RacingCar()
//    {
//        super();//이게 숨어있다
//    }

    /**
     * RacingCar에는 필요없는 기능이지만, 부분 상속은 불가하기 떄문에 무조건 상속 받는다
     * - 불필요한 기능도 어쩔 수 없이 모두 상속받게 된다.
     */
    @Override
    public void honk()
    {
        System.out.println("레이싱카 입니다");
    }
}
