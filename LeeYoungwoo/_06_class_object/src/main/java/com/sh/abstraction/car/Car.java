package com.sh.abstraction.car;

public class Car {
    private boolean engineStarted; //기본값 false
    private int speed;
    // 시동켜기
    public void startEngine() {
        if(engineStarted) {
            engineStarted = true;
            System.out.println("시동을 켰습니다...");
        }
        else {
            System.out.println("시동이 이미 켜져 있습니다...");
        }
    }
    // 가속
    public void accelerate() {
        if(engineStarted) {
            speed += 10;
            System.out.println("속도를 더 냅니다. 현재속도는 " + speed + "km/h 입니다.");
        }
        else {
            System.out.println("시동이 꺼져 있습니다. 먼저 시동을 켜주세요...");
        }
    }
    // 감속
    public void brake() {
        if(engineStarted) {
            speed -= 10;
            System.out.println("속도를 더 냅니다. 현재속도는 " + speed + "km/h 입니다.");
        }
        else {
            System.out.println("시동이 꺼져 있습니다. 먼저 시동을 켜주세요...");
        }
    }
    // 시동끄기
    public void stopEngine() {
        if(speed == 0) {
            if (engineStarted) {
                engineStarted = false;
                System.out.println("시동을 껐습니다...");
            } else {
                System.out.println("시동이 이미 꺼져 있습니다...");
            }
        }
        else {
            System.out.println("주행중입니다. 시동을 끌 수 없습니다...");
        }
    }
}
