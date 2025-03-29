package com.sh.generics._03._extends;

public class RabbitFarm<T extends Bunny> {
    private T rabbit;

    public T getRabbit() {
        return rabbit;
    }

    public void setRabbit(T rabbit) {
        this.rabbit = rabbit;
    }

    public RabbitFarm(T rabbit) {
        this.rabbit = rabbit;
    }
}
