package com.ssg.api.object.car;

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
        //동일비교
        if(this == object)
            return true;
        //object가 null인가
        if(object == null)
            return false;
        //object가 Car 클래스인가
        if(!(object instanceof Car))
            return false;
        //object를 Car 클래스로 다운캐스팅
        Car other = (Car)object;
        //carName
        if(this.carName == null) {
            if (other.getCarName() != null)
                return false;
        }else if (!this.carName.equals(other.getCarName())){
            return false;
        }
        //carColor
        if(this.carColor == null) {
            if (other.getCarColor() != null)
                return false;
        }else if (!this.carColor.equals(other.getCarColor())){
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        final int PRIME = 31;

        result = result * PRIME +(carName == null ? 0 : carName.hashCode());
        result = result * PRIME +(carColor == null ? 0 : carColor.hashCode());
        return result;
    }
}
