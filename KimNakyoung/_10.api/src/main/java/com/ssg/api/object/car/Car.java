package com.ssg.api.object.car;

import java.util.Objects;

/**
 *
 * 다음 Car클래스를 이용한 App의 실행코드가 적절히 실행될수 있도록 메소드를 오버라이드하세요.
 *
 * 단, 차이름과 차색깔이 같다면 같은 객체로 처리합니다.
 */
public class Car {

    private String carName;
    private String carColor;
    private int engineCC;

    public Car(String carName, String carColor, int engineCC) {
        this.carName = carName;
        this.carColor = carColor;
        this.engineCC = engineCC;

    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return carName == car.carName && carColor == car.carColor && Objects.equals(carName, car.carName) && Objects.equals(carColor, car.carColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, carColor);
    }

}
