package com.sh.abstraction;

public class Car {
    private boolean engineStarged; // 기본값 false
    private int speed;

    public void startEngine() {
        if(!engineStarged) {
            this.engineStarged = true;
            System.out.println("시동을 켰습니다...");
        }
        else {
            System.out.println("시동이 이미 켜져 있습니다...");
        }
    }
    public void accelerate() {
        if(engineStarged) {
            speed += 10;
            System.out.println("속도를 더 냅니다. 현재 속도는 " + speed + "km/h입니다.");
        }
        else {
            System.out.println("시동이 꺼져 있습니다. 먼저 시동을 켜주세요...");
        }
    }
    public void brake() {
        if(engineStarged) {
            if(speed != 0) {
                speed -= 10;
                System.out.println("속도를 줄입니다. 현재 속도는 " + speed + "km/h입니다.");
            }
            else {
                System.out.println("현재 속도는 " + speed + "km/h입니다.");
            }
        }
        else {
            System.out.println("시동이 꺼져 있습니다. 먼저 시동을 켜주세요...");
        }
    }
    public void stopEngine() {
        if(speed > 0) {
            System.out.println("달리는 중엔 시동을 끌 수 없습니다.");
        }
        else {
            if(engineStarged) {
                this.engineStarged = false;
                System.out.println("시동을 껐습니다...");
            }
            else {
                System.out.println("시동이 이미 꺼져 있습니다.");
            }
        }
    }
}
