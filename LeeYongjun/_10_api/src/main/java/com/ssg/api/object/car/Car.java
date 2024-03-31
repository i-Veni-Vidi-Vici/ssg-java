package com.ssg.api.object.car;

import com.sh.api._01.object.Book;

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
    public boolean equals(Object obj) {

        // 동일비교
        if(this == obj){
            return true;
        }
        // null비교
        if(obj == null){
            return false;
        }
        // 타입비교
        if(!(obj instanceof Car)){
            return false;
        }

        Car other = (Car) obj; // 다운캐스팅
        // id필드(기본형) 비교
        if(this.carName != other.carName){
            return false;
        }
        // title필드(참조형) 비교
        if(this.carColor == null){
            // 현재객체의 title이 null인데, other객체의 title이 null이 아닌 경우
            if(other.carColor != null){
                return false;
            }
        }
        else {
            // 오버라이드된 String#equals 대신 호출
            if(!this.carColor.equals(other.carColor)){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1; // 누적곱 연산의 준비값
        final int PRIME = 31;
        // title핃드
        if(carColor != null) {
            result = result * PRIME + carColor.hashCode();
        }
        // author필드
        if(carName != null) {
            result = result * PRIME + carName.hashCode();
        }
        return result;
    }
}


