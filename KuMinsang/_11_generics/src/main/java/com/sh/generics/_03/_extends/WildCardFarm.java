package com.sh.generics._03._extends;

public class WildCardFarm {
<<<<<<< HEAD
    public void anyRabbit(RabbitFarm<?> rabbitFarm){
=======

    public static void anyRabbit(RabbitFarm<?> rabbitFarm){
>>>>>>> 97aa7183c9fb127e3cf611ff187d772054906c64
        Rabbit rabbit = rabbitFarm.getRabbit();
        rabbit.cry();
    }

<<<<<<< HEAD
    // ? extends Bunny : Bunny 자식 클래스만 허용
    public  void anyBunny(RabbitFarm<? extends  Bunny> bunnyRabbitFarm){
=======
    public static void anyBunny(RabbitFarm<? extends Bunny> bunnyRabbitFarm) {
>>>>>>> 97aa7183c9fb127e3cf611ff187d772054906c64
        Bunny bunny = bunnyRabbitFarm.getRabbit();
        bunny.cry();
    }

<<<<<<< HEAD
    // ? super Bunny : Bunny 부모 클래스만 허용
    public void anyRabbitOrBunny(RabbitFarm<? super Bunny> bunnyRabbitFarm){
        Rabbit rabbit = bunnyRabbitFarm.getRabbit();
        rabbit.cry();
    }


=======
    public static void anyRabbitOrBunny(RabbitFarm<? super Bunny> bunnyRabbitFarm) {
        Rabbit rabbit = bunnyRabbitFarm.getRabbit();
        rabbit.cry();
    }
>>>>>>> 97aa7183c9fb127e3cf611ff187d772054906c64
}
