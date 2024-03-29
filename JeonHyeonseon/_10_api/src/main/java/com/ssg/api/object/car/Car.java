package com.ssg.api.object.car;

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
    public boolean equals(Object obj){
        // 동일비교
        if(this == obj)
            return true;
        // null 비교
        if(obj == null)
            return false;
        // 타입비교
        if(!(obj instanceof Car))
            return false;
        // 필드비교
        Car other = (Car) obj;
        // name필드 비교
        if(this.carName == null){
            if(other.carName != null)
                return false;
        }
        else {
            if(!this.carName.equals(other.carName))
                return false;
        }
        // color필드 비교
        if(this.carColor == null) {
            if(other.carColor != null)
                return false;
        }
        else {
            if(!this.carColor.equals(other.carColor))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        int result = 1;
        final int PRIME = 31;
        // name필드
        result = result * PRIME + (carName == null ? 0 : carName.hashCode());
        // carColor필드
        if(carColor != null)
            result = result * PRIME + (carColor == null ? 0 : carColor.hashCode());
        // engineCC필드
//        result = result * PRIME + engineCC;

        return result;
    }

}
