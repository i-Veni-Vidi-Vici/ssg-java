package com.sh.generics._03_extends;

public class WildCardFarm {

    public static void anyRabbit(RabbitFarm<?> rabbitFarm){
        Rabbit rabbit = rabbitFarm.getRabbit();
        rabbit.cry();
    }

    public static void anyRabbitOrBunny(RabbitFarm<Bunny> bunnyRabbitFarm) {
    }

    public void anyBunny(RabbitFarm<? extends Bunny> bunnyRabbitFarm){
     Bunny bunny   = bunnyRabbitFarm.getRabbit();
     bunny.cry();
    }

    public void anyRabbbitOrBunny(RabbitFarm<? super Bunny> bunnyRabbitFarm){
        bunnyRabbitFarm.getRabbit();
    }
}
