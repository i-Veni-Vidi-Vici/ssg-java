package com.sh.generics._03_extends;


/**
 * T extends Rabbit : T 자리에 Rabbit 을 포함해서 Rabbit 자식클래스만 허용한다 ( 상한 제한 )
 * @param <T>
 */
public class RabbitFarm <T extends Rabbit> { //타입 변수 하나 타입을 주면 T 를 다 주겠다 //T 에 올 수있는건 무조건 Rabbit 의 자식 클래스다
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
