package com.sh.generics._03._extends;

public class App {
    public static void main(String[] args) {
        //RabbitFarm<Rabbit> rabbitFarm1 = new RabbitFarm<>(new Rabbit());
        RabbitFarm<Bunny> rabbitFarm2 = new RabbitFarm<>(new Bunny());
        RabbitFarm<DrunkenBunny> rabbitFarm3 = new RabbitFarm<>(new DrunkenBunny());

        AnimalFarm<Snake> snakeFarm = new AnimalFarm<>(new Snake());
        AnimalFarm<Rabbit> rabbitFarm = new AnimalFarm<>(new Rabbit());

        //RabbitFarm<?> rabbitFarm4 = new RabbitFarm<Rabbit>(new Rabbit());
        RabbitFarm<? extends Bunny> rabbitFarm5 = new RabbitFarm<>(new Bunny());
        RabbitFarm<? super Bunny> rabbitFarm6 = new RabbitFarm<>(new DrunkenBunny());
        rabbitFarm6.getRabbit();
        System.out.println(rabbitFarm6.getRabbit().getClass());
    }
}
