package com.ssg.api.object.car;

import java.util.Objects;

public class Car {
    private String carName;
    private String carColor;
    private int engineCC;

    public Car() {
    }

    public Car(String carName, String carColor, int engineCC) {
        this.carName = carName;
        this.carColor = carColor;
        this.engineCC = engineCC;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getEngineCC() {
        return engineCC;
    }

    public void setEngineCC(int engineCC) {
        this.engineCC = engineCC;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object)
            return true;
        if(object == null)
            return false;
        if(!(object instanceof Car))
            return false;
        Car other = (Car) object;
        if(this.carName == null) {
            if(other.carName != null)
                return false;
        }else {
            if(!this.carName.equals(other.carName))
                return false;
        }
        if(this.carColor == null) {
            if(other.carColor != null)
                return false;
        }else {
            if(!this.carColor.equals(other.carColor))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        final int PRIME = 31;
        result = result * PRIME + (carName == null ? 0 : carName.hashCode());
        result = result * PRIME + (carColor == null ? 0 : carColor.hashCode());
//        result = result * PRIME + engineCC;
        return result;
    }
}
