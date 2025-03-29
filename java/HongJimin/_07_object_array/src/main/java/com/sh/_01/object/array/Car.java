package com.sh._01.object.array;

public class Car {
    private String name;
    private int maxspeed;

    public Car(String name, int maxspeed) {
        this.name = name;
        this.maxspeed = maxspeed;
    }

    public void run() {
        System.out.printf("%s가 최고시속 %d km/h로 달립니다~~\n", this.name, this.maxspeed);
    }
}
