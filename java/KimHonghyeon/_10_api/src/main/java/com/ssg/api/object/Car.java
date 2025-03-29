package com.ssg.api.object;

public class Car {
    private String carName;
    private String carColor;
    private int engineCC;

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

    public Car(String carName, String carColor, int engineCC) {
        this.carName = carName;
        this.carColor = carColor;
        this.engineCC = engineCC;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Car))return false;
        else{
            Car anotherCar = (Car)obj;
            if(this.engineCC == anotherCar.getEngineCC()){
                if(this.carName!=null){
                    if(anotherCar.carName==null)return false;
                    else{
                        if(!this.carName.equals(anotherCar.getCarName()))return false;
                    }
                }
                if(this.carColor != null){
                    if(anotherCar.getCarColor()==null)return false;
                    else{
                        if(!this.carColor.equals(anotherCar.getCarColor()))return false;
                    }
                }
            }
            return true;
        }
    }

    @Override
    public int hashCode(){
        int code =1;
        final int PRIME_NUM = 31;
        if(this.carName!=null) code = code*PRIME_NUM + this.carName.hashCode();
        if(this.carColor!=null) code = code*PRIME_NUM+this.carColor.hashCode();
        return code;
    }
}
