package com.sh.generics._extends;

/**
 * T extends Rabbit : Rabbit을 포함해서 Rabbit 자식클래스만 허용 (상한 제한)
 * @param <T>
 */

public class RabbitFarm<T extends Rabbit> {
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
