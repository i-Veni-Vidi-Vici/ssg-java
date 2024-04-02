package com.sh.generics._03._extends;

public class WildCardFarm {

    public static void anyRabbit(RabbitFarm<?> rabbitFarm){
        Rabbit rabbit = rabbitFarm.getRabbit();
        rabbit.cry();
    }

    public static void anyBunny(RabbitFarm<? extends Bunny> bunnyRabbitFarm){
        Bunny bunny = bunnyRabbitFarm.getRabbit();
        bunny.cry();
    }

    public static void anyRabbitorBunny(RabbitFarm<? super Bunny> bunnyRabbitFarm){
        Rabbit rabbit = bunnyRabbitFarm.getRabbit();
        rabbit.cry();
    }
//     WildCardFarm.anyRabbit(new RabbitFarm<Rabbit>(new Rabbit()));
//        WildCardFarm.anyBunny(new RabbitFarm<Bunny>(new Bunny()));
//        WildCardFarm.anyBunny(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));
//        WildCardFarm.anyRabbitorBunny(new RabbitFarm<Bunny>(new Bunny()));
}
