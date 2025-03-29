package com.sh.generics._03._extends;

/**
 * <pre>
 * T extends Rabbit : Rabbit을 포함해서 Rabbit자식클래스만 허용 (상한 제한)
 * - 너무 어려우면 (T extends)는 생략해서 Rabbit만 있다고 생각하자..
 * </pre>
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
