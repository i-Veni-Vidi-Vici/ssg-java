package com.sh.inheritance._02._extends;

/**
 *<pre>
 *상속
 * -장점
 * 1. 기존클래스를 재사용할 수 있다. (부모클래스의 코드를 그대로 사용가능. 중복코드를 방지할 수 있다.
 * 2. 클래스 계층구조를 만들어 다형성을 적용할 수 있다.
 *
 * -단점
 * 1. 부모클래스 수정 시 자식클래스가 정상적으로 작동하는지 예측이 힘들 수 있음.
 * 2. 부모클래스 수정이 어려움 만약 자식클래스가 100가 있으면 확인 어려움 -> 유지보수에 악영향을 끼칠 수 있다
 * 3. 부모클래스의 일부기능만 필요한 경우, 부분상속같은건 없음 따라서 불필요한 기능까지 상속할 수 있음
 *
 * - 무분별한 상속을 지양하고 , Is - a 상속관계가 성립할때만 상속을 적용하는 것이 좋다. 코드 재사용에 대한 입장을 본다면 다른 방법도 존재함
 * - 객체지향에서 객체는 메세지에 대해 응답할 책임을 가진다. 이 책임의 규모가 적절해야한다.
 * - 상속을 통해서 책임을 역할의 관점으로 볼 수 있어야 한다.
 * - 부모클래스의 추상화된 역할은 모든 자식클래스가  동일하게 수행(책임)할 수 있다.
 *
 *
 *</pre>
 */
public class App {
    public static void main(String[] args) {

//        Car car = new Car();
//        car.run();
//        car.honk();
//        car.stop();
//        car.honk();

        // 소방차
//        FireEngine fireEngine = new FireEngine(); //기본 생성자도 호출되고 있음
//        fireEngine.run();
//        fireEngine.honk();
//        fireEngine.stop();
//        fireEngine.honk();
//        //확장기능
//        fireEngine.extinguish();

        // 레이싱카
        RacingCar racingCar = new RacingCar();
        racingCar.run();
        racingCar.honk(); // 불필요하지만 가지고 있는 기능
        racingCar.stop();
        racingCar.honk();


    }
}
