package com.sh.generics._03._extends;

/**
 * T extends Rabbit : Rabbit을 포함해서 Rabbit자식클래스만 허용(상한 제한)
 * @param <T>
 */

public class RabbitFarm <T extends Rabbit>{//여기서 T는 아래 T들은 같은 T가 된다
    private T rabbit;
    public RabbitFarm(T rabbit)
    {
        this.rabbit=rabbit;
    }

    public void setRabbit(T rabbit) {
        this.rabbit=rabbit;
    }

    public T getRabbit() {
        return this.rabbit;
    }
}
