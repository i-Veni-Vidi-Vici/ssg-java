package com.sh.abstraction;

public class Car {
    private boolean engineStarted; //기본 값 false
    private int speed;

    public void startEngine() {
        if(!engineStarted ) {
            engineStarted = true; //시동켜기
            System.out.println("시동을 켰습니다🚗");
        }
        else {
            System.out.println("시동이 이미 켜져있네요!🤭");
        }
    }

    public void accelerate() {
        if(engineStarted) {
            speed += 10;
            System.out.println("속도를 더 냅니다. 현재 속도는 " + speed + "km/h입니다!");
        }
        else {
            System.out.println("시동이 꺼져 있습니다. 먼저 시동을 켜주세요..!!");
        }
    }

    public void brake() {
        if(engineStarted) {
            speed -= 10;
            System.out.println("속도를 줄입니다. 감소한 현재 속도는 " + speed + "km/h입니다!");
        }
        else {
            System.out.println("시동이 꺼져 있습니다. 먼저 시동을 켜주세요!!");
        }
    }

    public void stopEngine() {
        if (engineStarted) {
            if (speed > 0) {
                System.out.println("달리는 중입니다..! 시동을 끌 수 없어요ㅜ");
            }
            else {
                engineStarted = false;
                System.out.println("시동을 껐습니돠...");
            }
        }
        else {
            System.out.println("시동이 이미 꺼져있네요!");
        }
    }
}
