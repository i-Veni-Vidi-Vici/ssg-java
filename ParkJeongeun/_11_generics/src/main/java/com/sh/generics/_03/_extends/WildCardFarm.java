package com.sh.generics._03._extends;

// 메소드의 매개변수 안에도 와일드카드 사용 가능
public class WildCardFarm {
    public static void anyRabbit(RabbitFarm<?> rabbitFarm){
//        rabbitFarm.getRabbit().cry();
        Rabbit rabbit = rabbitFarm.getRabbit();
        rabbit.cry();
    }
    public static void anyBunny(RabbitFarm<? extends Bunny> bunnyRabbitFarm){
        Bunny bunny = bunnyRabbitFarm.getRabbit();
        bunny.cry();
    }
    public static void anyRabbitOrBunny(RabbitFarm<? super Bunny> bunnyRabbitFarm){
        Rabbit rabbit = bunnyRabbitFarm.getRabbit();
        rabbit.cry();
    }
}
