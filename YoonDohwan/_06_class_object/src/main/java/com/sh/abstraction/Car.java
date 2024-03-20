package com.sh.abstraction;

public class Car {
    private boolean engineStarted; // 기본값 false
    private int speed;

    public void startEngine(){
        if(!engineStarted){
        engineStarted = true; // 시동을 켜기
        System.out.println("시동을 켰습니다....");
        }
        else{
            System.out.println("시동이 이미 켜져 있습니다...");
        }

    }
    public void accelerate(){
        if (engineStarted) {

            speed += 10;
            System.out.println("속도를 더 냅니다. 현재 속도는" + speed + "km입니다.");
        }
        else {
            System.out.println("시동이 꺼져있습니다. 시동을 켜주세요....");
        }

    }
    public void brake(){
        if(engineStarted) {
            speed -= 10;
            System.out.println("속도를 줄입니다. 현재 속도는" + speed + "km입니다.");
        }
        else{
            System.out.println("시동이 꺼져 있습니다. 먼저 시동을 켜주세요....");
        }
    }
    public void stopEngine(){
        if(engineStarted) {
            if (speed == 0) {
                engineStarted = false;
                System.out.println("시동을 껐습니다.....");
            }
            else {
                System.out.println("달리는 중에는 시동을 끌 수 없습니다....");
            }
        }
        else {
            System.out.println("시동이 이미 꺼져 있습니다....");
        }
    }

}
