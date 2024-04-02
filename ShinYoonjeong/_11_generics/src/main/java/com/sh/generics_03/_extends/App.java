package com.sh.generics_03._extends;

import java.time.LocalDate;

/**
 * Generics 상한/하한
 * - < A extends B> B를 상속한 A타입만 가능 (상한 제한)
 * - < A super B> B의 부모 클래스인 A타입만 가능 (하한 제한)
 */
public class App {
    public static void main(String[] args) {
        // RabbitFarm<T>
        // 다형성 적용
        //RabbitFarm<Animal> animalFarm = new RabbitFarm<>(new Mammal());
        //RabbitFarm<Animal> animalFarm2 = new RabbitFarm<>(new Rabbit());
        //RabbitFarm<Animal> animalFarm3 = new RabbitFarm<>(new Reptile());
        //RabbitFarm<Animal> animalFarm4 = new RabbitFarm<>(new Bunny());
        //RabbitFarm<Animal> animalFarm5 = new RabbitFarm<>(new DrunkenBunny());

        //RabbitFarm<LocalDate> localDateRabbitFarm = new RabbitFarm<>(LocalDate.now());
        RabbitFarm<Rabbit> rabbitFarm = new RabbitFarm<>((new Rabbit())); // 다형성
        RabbitFarm<Rabbit> rabbitFarm2 = new RabbitFarm<Rabbit>((new Rabbit()));
        RabbitFarm<Rabbit> rabbitFarm3 = new RabbitFarm<>((new DrunkenBunny()));
        RabbitFarm<Bunny> bunnyRabbitFarm = new RabbitFarm<>((new Bunny()));
        RabbitFarm<Bunny> bunnyRabbitFarm1 = new RabbitFarm<>((new DrunkenBunny()));
        RabbitFarm<DrunkenBunny> drunkenBunnyRabbitFarm = new RabbitFarm<>((new DrunkenBunny()));
        Rabbit rabbit = rabbitFarm.getRabbit();
        rabbit.cry();
        Rabbit rabbit2 = rabbitFarm2.getRabbit();
        rabbit2.cry();

        // AnimalFarm<A extends Animal>
        AnimalFarm<Animal> animalFarm = new AnimalFarm<>();
        AnimalFarm<Reptile> reptileAnimalFarm = new AnimalFarm<>();

    }
}
