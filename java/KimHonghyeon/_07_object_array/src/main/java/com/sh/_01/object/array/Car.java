package com.sh._01.object.array;

public class Car {

    private String name;
    private int maxSpeed;

    public Car(String name, int maxSpeed){
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public void run(){
        System.out.println("name: " +this.name +" maxSpeed: "+ this.maxSpeed);
    }
}
