package com.sh.generics_03._extends;

public class WildCardFarm {
    public void anyRabbit(RabbitFarm<?> rabbitFarm){
        Rabbit rabbit = rabbitFarm.getRabbit();
        rabbit.cry();
    }
    public void anyBunny(RabbitFarm<? extends Bunny> bunnyRabbitFarm){
        Bunny bunny = bunnyRabbitFarm.getRabbit();
        bunny.cry();
    }
    public void anyRabbitOrBunny(RabbitFarm<? super Bunny> bunnyRabbitFarm){
        Rabbit rabbit = bunnyRabbitFarm.getRabbit();
        bunnyRabbitFarm.getRabbit();
        rabbit.cry();
    }
}
