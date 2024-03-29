package com.ssg.api.object.car;

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

    @Override
    public int hashCode() {
        int result = 1;
        final int PRIME_NUMBER = 31;
        if (carName != null)
            result = result * PRIME_NUMBER + carName.hashCode();
        if(carColor!=null)
            result = result * PRIME_NUMBER + carColor.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
        {
            return true;
        }
        if(obj==null)
            return false;

        if(!(obj instanceof Car))//같은 타입 및, 같은 부모가 아니라면 false반환
        {
            return false;
        }
        Car temp=(Car) obj;// obj를 Book으로 DownCasting; 이제 여기부터는 필드값 비교

        //carColor null 확인(String은 참조 변수 이므로 null값까지 확인해야 한다)
        if(this.carColor==null)
        {// this는 null인데, temp는 null이 아니네?? 그럼 false 리턴
            if(temp.carColor!=null)
            {
                return false;
            }
        }
        else {
            if(this.carColor!= temp.carColor)
            {
                return false;
            }
        }

        if(this.carName==null)
        {// this는 null인데, temp는 null이 아니네?? 그럼 false 리턴
            if(temp.carName!=null)
            {
                return false;
            }
        }
        else {
            if(this.carName!= temp.carName)
            {
                return false;
            }
        }
        return true;

    }

//    public String getCarName() {
//        return carName;
//    }
//
//    public void setCarName(String carName) {
//        this.carName = carName;
//    }
//
//    public String getCarColor() {
//        return carColor;
//    }
//
//    public void setCarColor(String carColor) {
//        this.carColor = carColor;
//    }
//
//    public int getEngineCC() {
//        return engineCC;
//    }
//
//    public void setEngineCC(int engineCC) {
//        this.engineCC = engineCC;
//    }
}
