package com.sgg.api.object.car;

import com.sh.api._01.object.Book;

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
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(!(obj instanceof Car))
            return false;


        Car other = (Car) obj;

        if(this.carName == null){
            if(other.getCarName() != null){
                return false;
            }
        }else{
            if(!this.carName.equals(other.getCarName()))
                return false;
        }

        if(this.carColor == null){
            if(other.getCarColor()!= null){
                return false;
            }
        }else{
            if(!this.carColor.equals(other.getCarColor()))
            return false;
        }


        return true;
    }
    @Override
    public int hashCode(){
        int result = 1;
        final int PRIME = 31;

        if(carColor != null)
        {
            result = result * PRIME + carColor.hashCode();}


        return result;
    }

}
