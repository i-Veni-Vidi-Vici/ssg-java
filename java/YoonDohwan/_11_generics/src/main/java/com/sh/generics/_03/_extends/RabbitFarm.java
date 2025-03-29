package com.sh.generics._03._extends;

public class RabbitFarm<T>{
    private T rabbit;
    public RabbitFarm(T rabbit){
        this.rabbit=rabbit;
    }

    public void setRabbit(T rabbit){
        this.rabbit=rabbit;
    }
    public T getRabbit(){
        return this.rabbit;
    }
}
