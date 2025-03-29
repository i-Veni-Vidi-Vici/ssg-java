package com.sh.custom.type.abstraction;

public class Car {
    private boolean engineStarted;
    private int speed;

    public void StartEngine(){
        if(engineStarted){
            System.out.println("이미 시동이 켜져 있습니다.");
        }else{
            engineStarted = true;
            System.out.println("시동을 켰습니다...");
        }

    }
    public void brake(){
        speed -=10;
        System.out.println("속도를 줄입니다. 현재 속도는" + speed+"km/h 입니다");
    }
    public void accelerate(){
        speed += 10;
        System.out.println("속도를 높입니다. 현재 속도는" + speed+"km/h 입니다");
    }

    public void stopEngine(){
        if(engineStarted){
            engineStarted = false;
            System.out.println("시동을 껐습니다....");
        }else{
            System.out.println("시동이 이미 꺼져 있습니다.");
        }

    }

}
