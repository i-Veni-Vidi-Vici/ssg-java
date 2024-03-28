package com.sh.generics._03._extends;

public class WildCardFarm {
    public void anyRabbit(RabbitFarm<?> rabbitFarm){
        Rabbit rabbit = rabbitFarm.getRabbit();
        rabbit.cry();
    }

    // ? extends Bunny : Bunny 자식 클래스만 허용
    public  void anyBunny(RabbitFarm<? extends  Bunny> bunnyRabbitFarm){
        Bunny bunny = bunnyRabbitFarm.getRabbit();
        bunny.cry();
    }

    // ? super Bunny : Bunny 부모 클래스만 허용
    public void anyRabbitOrBunny(RabbitFarm<? super Bunny> bunnyRabbitFarm){
        Rabbit rabbit = bunnyRabbitFarm.getRabbit();
        rabbit.cry();
    }


}
