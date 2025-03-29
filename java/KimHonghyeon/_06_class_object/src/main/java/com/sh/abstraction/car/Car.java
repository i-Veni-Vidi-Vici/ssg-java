package com.sh.abstraction.car;

public class Car {
    private boolean engineStarted;
    private int speed;
    public void startEngine(){
        if(this.engineStarted== false){
            this.engineStarted = true;
            System.out.println("시동을 켰습니다.");
        }
        else{
            System.out.println("이미 시동이 켜져 있습니다.");
        }

    }
    public void accelerate(){
        if(this.engineStarted==true){
            this.speed+=10;
            System.out.println("가속합니다. 현재 속도: "+ this.speed);
        }
        else{
            System.out.println("시동이 꺼져있습니다. 먼저 시동을 켜주세요.");
        }
    }
    public void brake(){
        if(this.engineStarted==true){
            if(this.speed>10){
                speed -=10;
                System.out.println("감속합니다. 현재 속도: "+ this.speed);
            }
            else{
                speed =0;
                System.out.println("더 이상 감속할 수 없습니다. 현재 속도: "+ this.speed);
            }
        }
        else{
            System.out.println("시동이 꺼져있습니다. 먼저 시동을 켜주세요.");
        }
    };
    public void stopEngine(){
        if(engineStarted== true){
            if(this.speed<=0){
                this.engineStarted = false;
                System.out.println("시동을 껐습니다.");
            }
            else{
                System.out.println("운행 중입니다. 먼저 감속을 해주세요.");
            }
        }
        else{
            System.out.println("이미 시동이 꺼져 있습니다.");
        }
    }
}
