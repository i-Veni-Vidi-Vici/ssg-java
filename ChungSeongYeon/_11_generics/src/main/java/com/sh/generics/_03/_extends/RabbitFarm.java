package com.sh.generics._03._extends;

/**
 * T extends Rabbit : T 자리에 Rabbit을 포함해서 Rabbit의 자식클래스만 허용(상한 제한)
 * @param <T>
 */

public class RabbitFarm<T extends Rabbit>{
    private T rabbit;

    public RabbitFarm (T rabbit) {
        this.rabbit = rabbit;
    }

    public void setRabbit(T rabbit) {
        this.rabbit = rabbit;
    }

    public T getRabbit() {
        return this.rabbit;
    }
}
