package com.sh.inheritance._02._extends;

public class RacingCar extends Car{

//    public RacingCar(){
//        super(); 생성자가 호출디어 있는 것임
//    }

    /**
     * RacingCar에는 필요없는 기능이지만, 무조건 상속 받는다라고 볼 수 있음.
     * - 불필요한 기능도 어쩔 수 없이 모두 상속받게 됨.
     */
    @Override
    public void honk(){
        System.out.println("레이싱카는 경적을 울리지 않습니다...");
        //경주차는 클락션을 울리지 않음, 즉 Car가 가진 기능을 그대로 가져다가 쓰는 것은 어색할 수 있음.

    }

}
