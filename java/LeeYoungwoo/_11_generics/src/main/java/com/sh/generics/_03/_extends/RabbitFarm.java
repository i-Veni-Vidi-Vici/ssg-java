package com.sh.generics._03._extends;

/**
 * <pre>
 * T extends Rabbit : Rabbit을 포함해서 Rabbit 자식클래스만 허용 (상한 제한)
 * </pre>
 * @param <T>
 */
public class RabbitFarm <T extends Rabbit>{
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
