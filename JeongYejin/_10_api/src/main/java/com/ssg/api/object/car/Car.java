package com.ssg.api.object.car;

import com.sh.api._01.object.Book;

import java.util.Objects;

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

        // 동일 비교
        if (this == obj)
            return true;
        // null 비교
        if (obj == null)
            return false;
        // 타입 비교
        // obj가 Car의 객체가 아니면 오류가 남!
        if (!(obj instanceof Car))
            return false;
        // 필드 비교
        Car other = (Car) obj; // downcasting
        // obj이 Car객체가 아니면 Car필드에 접근할 수도 없고 비교할 수도 없다
        // 참조형 비교
        // Cannot invoke "String.equals(Object)" because "this.title" is null
        if (this.carName == null) {
            if (other.carName != null)
                return false;
        } else {
            if (!this.carName.equals(other.carName))
                return false;
        }
        if (this.carColor == null) {
            if (other.carColor != null)
                return false;
        } else {
            if (!this.carColor.equals(other.carColor))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        final int PRIME = 31;
        if (carName != null)
            result = result * PRIME + (carName == null ? 0 : carName.hashCode());
        if (carColor != null)
            result = result * PRIME + (carColor == null ? 0 : carColor.hashCode());
//        result = result * PRIME + engineCC;
        return result;
    }
}