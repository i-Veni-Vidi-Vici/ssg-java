package com.ssg.test.api.object.car;

import com.sh.api._01.object.Book;

import java.util.Objects;

public class Car {
    private String carName;
    private String carColor;
    private int engineCC;

    public Car() {}
    public Car(String carName, String carColor, int engineCC) {
        this.carName = carName;
        this.carColor = carColor;
        this.engineCC = engineCC;
    }

    @Override
    public boolean equals(Object o) {
//        // 동일 비교
//        if(this == o)
//            return true;
//        // null 비교
//        if(o == null)
//            return false;
//        // 타입 비교
//        if(!(o instanceof Car))
//            return false;
//        // 필드 비교
//        Car other = (Car) o;
//
//        if(this.carName != null) {
//            if(!this.carName.equals(other.carName))
//                return false;
//        } else {
//            if(other.carName != null)
//                return false;
//        }
//
//        if(this.carColor != null) {
//            if(!this.carColor.equals(other.carColor))
//                return false;
//        } else {
//            if(other.carColor != null)
//                return false;
//        }
//
//        return true;

        if(this == o)   return true;
        if(o==null || getClass()!=o.getClass()) return false;
        Car other = (Car) o;
        return Objects.equals(carName, other.carName) && Objects.equals(carColor, other.carColor);
    }

    @Override
    public int hashCode() {
//        int result = 1;
//        final int PRIME = 31;
//
//        result = result * PRIME + (this == null ? 0 : this.carName.hashCode());
//        result = result * PRIME + (this == null ? 0 : this.carColor.hashCode());
//
//        return result;

        return Objects.hash(carName, carColor);
    }
}
