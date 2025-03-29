package com.sh.ineritance._02._extends;

/**
 * <pre>
 *  상속
 *  - 장점
 *   1. 기존 클래스를 재사용할 수 있다. (부모 클래스의 코드를 그대로 사용가능. 중복코드 방지)
 *   2. 클래스 계층구조를 만들어 다형성을 적용할 수 있다.
 *
 *  - 단점
 *  1. 부모 클래스 수정시 자식 클래스가 정상적으로 작동하는지 예측이 힘들다
 *  2. 부모 클래스 수정이 어렵다. -> 유지보수 악영향
 *  3. 부모 클랫으ㅢ 일부기능만 필요한 경우, 부분상속은 불가능하다.(불필요한 기능까지 상속)
 *
 *  - 무분별한 상속을 지양하고, Is - a상속 관계가 성립할 때만 상속을 적용하는 것이 좋다.
 *  - 객체지향에서 객체는 메세지에 대해 응답할 책임을 가진다. 이 책임의 규모가 적절해야 한다.
 *  - 상속을 통해서 책임을 역할의 관점으로 볼 수 있어야한다.
 *  - 부모 클래스를 추상화된 역할은 모든 자식클래스가 동일하게 수행 할 수 있다. .
 * </pre>
 */
public class App {

    public static void main(String[] args) {

//        Car car = new Car();
//        car.run();
//        car.honk();
//        car.stop();
//        car.honk();


        //소방차
//        FireEngine fireEngine = new FireEngine();
//        fireEngine.run();
//        fireEngine.honk();
//        fireEngine.stop();
//        fireEngine.honk();
//        //확장 기능
//        fireEngine.extingusih();

        //레이싱 카
        RacingCar racingCar = new RacingCar();
        racingCar.run();
        racingCar.honk();
        racingCar.stop();
        racingCar.honk();
    }

}
