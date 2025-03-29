package com.sh.abstraction.car;

public class Car {
    private boolean engineStarged; // 기본값 false
    private int speed;

    public void startEngine() {
        if (!engineStarged ) {
            engineStarged = true; // 시동 킴
            System.out.println("시동을 켰습니다..");
        }
    }
    public void acclerate() {
        if (engineStarged) {
            speed += 10;
            System.out.println("속도를 더 냅니다. 현재 속도는" + speed + "km입니다.");

        }
        else {
            System.out.println("시동이 꺼져 있습니다. 먼저 시동을 켜주세요...");
        }
    }

    public void brake() {

        if (engineStarged) {
            if(speed > 0) {
                speed -= 10;
                System.out.println("속도를 감속합니다. 현재 속도는" + speed + "km/h입니다.");
            }else {
                engineStarged =false;
                System.out.println("시동을 껐습니다...");
            }

        }else {
            System.out.println("시동이 꺼져 있습니다. 먼저 시동을 켜주세요..");
        }
    }

    public void stopEngine() {

        if(engineStarged) {
            engineStarged = false;
            System.out.println("시동을 껐습니다...");
        }
        else {
            System.out.println("시동이 이미 꺼져 있습니다.");
        }
    }

}
