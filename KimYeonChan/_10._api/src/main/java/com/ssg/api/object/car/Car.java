package com.ssg.api.object.car;

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
    public boolean equals(Object obj) {
        // 동일 비교
        if (this == obj)
            return true;

        // null 비교
        if (obj == null)
            return false;

        // 필드 비교
        Car other = (Car)(obj);
        if (other.carName == null)
            return false;
        else
            if (!this.carName.equals(other.carName))
                return false;


        if (other.carColor == null)
            return false;
        else
            if (!this.carColor.equals(other.carColor))
                return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        final int PRIME = 31;
        result = PRIME * result + ((this.carName == null) ? 0 : this.carName.hashCode());
        result = PRIME * result + ((this.carColor == null) ? 0 : this.carColor.hashCode());

        return result;
    }
}
