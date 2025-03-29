package com.sh.generics._03._extends;

/**
 * <pre>
 * T extends Rabbit : Rabbit을 포함해서 Rabbit자식클래스만 허용(상한 제한)
 * </pre>
 */
public class RabbitFarm <T extends Rabbit>{ // T자리에 어떤 타입이 오면 아래에 T자리에도 똑같은 타입이 들어간다는 의미
    private T rabbit;
    public RabbitFarm(T rabbit){
        this.rabbit = rabbit;
    }
    public void setRabbit(T rabbit){
        this.rabbit = rabbit;
    }
    public T getRabbit(){
        return this.rabbit;
    }
}
