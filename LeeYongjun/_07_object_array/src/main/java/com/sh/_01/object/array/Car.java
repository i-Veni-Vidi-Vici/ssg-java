package com.sh._01.object.array;

public class Car {
    private String name;
    private int maxSpeed;

    // 생성자 초기화
    public Car(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public void run(){
        System.out.printf("%s가 최고시속 %dkm/h로 달립니다...\n",name,maxSpeed);
    }
}
