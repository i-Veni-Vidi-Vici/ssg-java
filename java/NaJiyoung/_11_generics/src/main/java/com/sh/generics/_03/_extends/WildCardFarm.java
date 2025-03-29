package com.sh.generics._03._extends;

public class WildCardFarm {

    public static void anyRabbit(RabbitFarm<?> rabbitFarm) {
        Rabbit rabbit = rabbitFarm.getRabbit();
//        Bunny bunny = rabbitFarm.getRabbit(); // 오류
        rabbit.cry();
    }

    public static void anyBunny(RabbitFarm<? extends Bunny> bunnyRabbitFarm) {
        Bunny bunny = bunnyRabbitFarm.getRabbit(); // 자기 자신 가능
        bunny.cry();
//        Rabbit rabbit = bunnyRabbitFarm.getRabbit(); // Bunny의 상위 클래스 가능
//        rabbit.cry();
//        DrunkenBunny drunkenBunny = bunnyRabbitFarm.getRabbit(); // Bunny의 하위 클래스 불가
//        drunkenBunny.cry();
    }

    public static void anyRabbitOrBunny(RabbitFarm<? super Bunny> bunnyRabbitFarm) {
        Rabbit rabbit = bunnyRabbitFarm.getRabbit(); // Bunny의 상위 클래스 가능
        rabbit.cry();
//        Bunny bunny = bunnyRabbitFarm.getRabbit(); // 자기 자신 불가
//        bunny.cry();
//        DrunkenBunny drunkenBunny = bunnyRabbitFarm.getRabbit(); // Bunny의 하위 클래스 불가
//        drunkenBunny.cry();
    }
}
