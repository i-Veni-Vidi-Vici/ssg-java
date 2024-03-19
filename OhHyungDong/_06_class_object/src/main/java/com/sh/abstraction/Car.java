package com.sh.abstraction;

public class Car {
    private boolean engineStarted; //기본값 false
    private int speed = 0;

    public void startEngine(){
        if(!engineStarted) {
            this.engineStarted = true; //ON
            System.out.println("시동 : ON");
        }
        else{
            System.out.println("시동이 이미 켜져있습니다. ");
        }
    }
    public void acccelerate()
    {
        if(engineStarted) {
            speed += 10;
            System.out.println("속도를 증가시킵니다. 현재속도는 " + speed + "km/h입니다.");
        }
        else System.out.println("시동이 꺼져있습니다. 시동을 먼저 걸어주세요.");
    }

    public void brake(){
        if(engineStarted) {
            speed -= 10;
            System.out.println("속도를 감소시킵니다. 현재속도는 " + speed + "km/h입니다.");
        }
        else System.out.println("시동이 꺼져있습니다. 시동을 먼저 걸어주세요.");

    }

    public void stopEngine(){
        if(engineStarted){
            if(speed !=0)
            {
                System.out.println("차를 정차한 후에 시동을 꺼주세요.");
            }
            else {
                engineStarted = false;
                System.out.println("시동을 껐습니다. ");
            }
        }
        else System.out.println("시동이 이미 꺼져있습니다.");

    }
}
