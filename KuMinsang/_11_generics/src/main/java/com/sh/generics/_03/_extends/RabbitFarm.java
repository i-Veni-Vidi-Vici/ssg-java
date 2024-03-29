package com.sh.generics._03._extends;

<<<<<<< HEAD
public class RabbitFarm <T extends Rabbit>{
    private T rabbit;

    public RabbitFarm(T rabbit){
=======
/**
 * <pre>
 *  T extends Rabbit : Rabbit을 포함해서 Rabbit자식클래스만 허용 (상한 제한)
 * </pre>
 * @param <T>
 */
public class RabbitFarm<T extends Rabbit>{
    private T rabbit;

    public RabbitFarm (T rabbit) {
>>>>>>> 97aa7183c9fb127e3cf611ff187d772054906c64
        this.rabbit = rabbit;
    }

    public void setRabbit(T rabbit) {
        this.rabbit = rabbit;
    }

    public T getRabbit() {
        return this.rabbit;
    }
}
