package com.sh.abstraction.car;

public class Car {
    private boolean engineStarged;// 기본값 false
    private int speed;

    public void startEngine() {
        if(!engineStarged) {
            engineStarged = true; // 시동을 킨다
            System.out.println("시동을 켰습니다");
        }
        else {
            System.out.println("시동이 이미 켜져 있습니다");
        }
    }

    public void accelerate() {
        if(engineStarged) {
            speed += 10;
            System.out.printf("속도를 올립니다, 현재속도 %d입니다\n", speed);
        }
        else {
            System.out.println("시동이 꺼져 있습니다. 시동을 먼저켜주세요");
        }
    }

    public void brake() {
        if(engineStarged) {
            speed -= 10;
            System.out.printf("속도를 내립니다, 현재속도 %d입니다\n", speed);
        }
        else {
            System.out.println("시동이 꺼져 있습니다. 시동을 먼저켜주세요");
        }
    }

    public void stopEngine() {

        if(engineStarged)
        {
            if(speed>0)
            {
                System.out.println("달리는 중이므로 시동을 끌 수 없습니다.");
            }
            else {
                engineStarged = false;
                System.out.println("시동을 껐습니다");
            }
        }
        else {
            System.out.println("시동이 이미 꺼져 있습니다.");
        }
    }
}
