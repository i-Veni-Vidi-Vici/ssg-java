package com.sh.abstraction;

public class Car {
    private boolean engineStarted;      // 기본값 false
    private int speed;

    public void startEngine() {
        if (!engineStarted) {
            engineStarted = true;
            System.out.println("시동을 켰습니다...");
        }else {
            System.out.println("시동이 이미 켜져 있습니다...");
        }
    }

    public void accelerate() {
        // 유효성 검사, 시동이 켜져있을 때만 가속
        if (engineStarted) {
            speed += 10;
            System.out.println("속도를 더 냅니다. 현재 속도는 " + speed + "km/h입니다.");
        }
        else {
            System.out.println("시동이 꺼져 있습니다. 먼저 시동을 켜주세요...");
        }
    }

    public void brake() {
        // 유효성 검사
        if(engineStarted) {
        speed -= 10;
        System.out.println("속도를 줄입니다. 현재 속도는 " + speed + "km/h입니다.");
        } else {
            System.out.println("시동이 꺼져 있습니다. 먼저 시동을 켜주세요...");
        }
    }

    public void stopEngine() {
        // 유효성 검사, 이미 시동이 꺼져있는데 또 시동을 끌 수는 없다.
        if(engineStarted == true) {
            // 유효성 검사, 달리는 중에 시동을 끌 수 없다.
            if(speed > 0)
                System.out.println("달리는 중에는 시동을 끌 수 없습니다.");
        }
         else {
            System.out.println("시동이 이미 꺼져 있습니다...");
        }

//        engineStarted = false;
//        System.out.println("시동을 껐습니다...");
    }
}
