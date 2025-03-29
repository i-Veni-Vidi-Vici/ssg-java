package com.sh.generics._03._extends;

/**
 * T extends Rabbit : T자리에 Rabbit을 포함해서 Rabbit 자식 클래스만 허용 (상한 제한)
 * @param <T>
 */
public class RabbitFarm<T extends Rabbit>{

    private T rabbit;
    // Rabbit rabbit = new Bunny() -> rabbit.cry() 구현하면 Bunny에 있는 값 메소드 실행

    public void setRabbit(T rabbit){
        this.rabbit = rabbit;
    }
    public T getRabbit(){
        return this.rabbit;
    }

    public RabbitFarm(T rabbit) {
        this.rabbit = rabbit;
    }
}
