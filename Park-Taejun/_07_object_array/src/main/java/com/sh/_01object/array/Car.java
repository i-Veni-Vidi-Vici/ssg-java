package com.sh._01object.array;

public class Car {

    private String name;

    private int maxSpeed;

    public Car(String name, int maxSpeed){
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public void run(){
        System.out.printf("%s가 최고시속 %d km/h로 달립니다 ...\n", this.name, this.maxSpeed);
    }
}
