package com.sh.inheritance._02_extends;

import java.util.Random;

/**
 * <pre>
 * 상속
 * - 장점
 *  1. 기존클래스를 재사용할 수 있다(부모클래스의 코드를 그대로 사용가능, 중복코드 방지_
 *  2. 클래스 계층구조를 만들어 다형성을 적용할 수 있다.
 *
 * - 단점
 *  1. 부모클래스 수정시 자식클래스 정상적으로 작동하는지 예측이 힘들 수 있다
 *  2. 부모클래스 수정이 어렵다 -> 유지보수 악영향
 *  3. 부모클래스의 일부 기능만 필요한 경우, 부분상속은 불가능하다. (불필요한 기능까지 상속하게 된다)
 *
 *   - 무분별한 상속을 지양하고, Is-a상속관계가 성립할때만 상속을 적용하는 것이 좋다.
 *   - 객체지향에서 객체는 메세지에 대해 응당할 책임을 가진다. 이 책입의 규모가 적절해야 한다
 *   - 상속을 통해서 책임을 역할의 관점으로 볼 수 있어야 한다.
 *   - 부모클래스의 추상화화된 역할을 모든 자식클래스가 동일한 수행(책임)할 수 있다.
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        Car car=new Car();
//        car.run();
//        car.honk();
//
//        car.stop();
//        car.honk();

        //소방차
//        FireEngine fireEngine=new FireEngine();
//        fireEngine.run();
//        fireEngine.honk();
//        fireEngine.stop();
//        fireEngine.honk();

        //확장기능
        //fireEngine.extinguish();

        //레이싱카
        RacingCar racingCar=new RacingCar();
        racingCar.run();
        racingCar.honk();//불필요 하지만 부분 상속은 없기 때문에 가지고 있다
        racingCar.stop();
        racingCar.honk();

    }
}
