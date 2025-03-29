package com.ssg.api.object.car;

import java.util.Objects;

public class Car {
    private String carName;
    private String carColor;
    private int engineCC;

    public Car(){}

    public Car(String carName, String carColor, int engineCC) {
        this.carName = carName;
        this.carColor = carColor;
        this.engineCC = engineCC;
    }

    @Override
    public boolean equals(Object obj){
        // 같은 객체면 내용 같음
        if(this == obj)
            return true;

        // null비교
        if(obj == null)
            return false;
        //obj가 Car객체가 아니라면
        if(!(obj instanceof Car))
            return false;

        //필드 비교
        Car other = (Car) obj;

        // Name필드(참조형) 비교
        if(this.carName == null){
            if(other.carName != null)
                return false;
        }else{
            // 문자열 비교 equls
            if(!this.carName.equals(other.carName))
                return false;
        }

        // carColor필드(참조형) 비교
        if(this.carColor == null){
            if(other.carColor != null)
                return false;
        }else{
            // 문자열 비교 equls
            if(!this.carColor.equals(other.carColor))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(carName, carColor);
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
}
