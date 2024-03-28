package com.sh.generics._03._extends;

public class App2 {
    public static void main(String[] args) {
        RabbitFarm<?> rabbitFarm = new RabbitFarm<>(new Rabbit());
//        RabbitFarm<?> rabbitFarm2 = new RabbitFarm<>(new Snake());
//        RabbitFarm<?> rabbitFarm3 = new RabbitFarm<>(new Mammal());

        // ? extends Bunny : RabbitFarm<T extends Rabbit>를 다시 한번 상한 제한
        RabbitFarm<? extends Bunny> bunnyFarm = new RabbitFarm<>(new Bunny());
        RabbitFarm<? extends Bunny> bunnyFarm2 = new RabbitFarm<>(new DrunkenBunny());

//        RabbitFarm<? extends Bunny> bunnyFarm2 = new RabbitFarm<>(new Rabbit());
        Bunny bunny = bunnyFarm.getRabbit();
        bunny.cry();
        Bunny bunny2 = bunnyFarm2.getRabbit();
        bunny2.cry();

        // ? super Bunny : Bunny 부모 클래스만 허용
        RabbitFarm<? super Bunny> bunnyFarm3 = new RabbitFarm<>(new Bunny());
//        RabbitFarm<? super Bunny> bunnyFarm4 = new RabbitFarm<DrunkenBunny>(new DrunkenBunny());
        //제네릭의 특징 : 컴파일 타임에 체크하고 런타임에 제거된다

    }
}
