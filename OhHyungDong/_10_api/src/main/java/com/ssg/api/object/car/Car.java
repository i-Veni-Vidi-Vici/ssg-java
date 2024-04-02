package com.ssg.api.object.car;

import com.sh.api._01.object.Book;

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


//    @Override
//    public boolean equals(Object obj){
//        // 동일 비교
//        if(this == obj){
//            return true;
//        }
//        // null 비교
//        if(obj == null){
//            return false;
//        }
//        //타입 비교
//        if(!(obj instanceof  Book)) return false;
//        // 필드 비교
//        Book other = (Book) obj; // 다운 캐스팅
//        //code 필드(기본형) 비교
//        if(this.code != other.code) return false;
//
//        //title필드(참조형) 비교
//        if(this.title == null){
//            //현재 객체의 title이 null인데, other객체의 title이 null이 아닌 경우
//            if(other.title != null) return false;
//        }else{
//            //오버라이드 된 String #equals 대신 호출
//            if(!this.title.equals(other.title)) return false;
//
//        }
//        //author 필드(참조형) 비교
//        if(this.author == null){
//            if(other.author != null) return false;
//        }
//        else{
//            if(!this.author.equals(other.author)) return false;
//
//        }
//
//        return true;
//    }


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
