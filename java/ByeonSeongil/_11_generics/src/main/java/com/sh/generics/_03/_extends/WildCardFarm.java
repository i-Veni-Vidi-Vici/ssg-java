package com.sh.generics._03._extends;

public class WildCardFarm {

    public static void anyRabbit(RabbitFarm<?> rabbitFarm) {
        Rabbit rabbit = rabbitFarm.getRabbit();
        rabbit.cry();
    }

    public static void anyBunny(RabbitFarm<? extends Bunny> bunnyRabbitFarm) {
        Bunny rabbit = bunnyRabbitFarm.getRabbit();
        rabbit.cry();
    }

    public static void anyRabbitOrBunny(RabbitFarm<? super Bunny> bunnyRabbitFarm) {
        Rabbit rabbit = bunnyRabbitFarm.getRabbit();
        rabbit.cry();

    }
}
