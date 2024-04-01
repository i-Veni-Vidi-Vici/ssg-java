package com.sh.generics._extends;

/**
 * <pre>
 * Generics 상한/하한 제한
 * - <A extends B>
 * - <A super B>
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // RabbitFarm<T>
//        RabbitFarm<Animal> animalFarm = new RabbitFarm<>(new Mammal()); // 다형성 적용
//        RabbitFarm<Animal> animalFarm2 = new RabbitFarm<>(new Reptile());
//        RabbitFarm<Animal> animalFarm3 = new RabbitFarm<>(new Rabbit());
//        RabbitFarm<Animal> animalFarm4 = new RabbitFarm<>(new Snake());

        // RabbitFarm<T extends Rabbit>
        RabbitFarm<Rabbit> rabbitFarm = new RabbitFarm<>(new Rabbit()); // 다형성
        RabbitFarm<Rabbit> rabbitFarm2 = new RabbitFarm<>(new Bunny());
        RabbitFarm<Rabbit> rabbitFarm3 = new RabbitFarm<>(new DrunkenBunny());

        RabbitFarm<Bunny> bunnyRabbitFarm = new RabbitFarm<>(new Bunny());
        RabbitFarm<Bunny> bunnyRabbitFarm2 = new RabbitFarm<>(new DrunkenBunny());

        RabbitFarm<DrunkenBunny> drunkenBunnyRabbitFarm = new RabbitFarm<>(new DrunkenBunny());

        Rabbit rabbit = rabbitFarm.getRabbit();
        rabbit.cry();

        Rabbit rabbit2 = rabbitFarm2.getRabbit();
        rabbit2.cry(); // 상속/다형성 & 오버라이드 -> 동적바인딩

        // AnimalFarm<A extends Animal>
        AnimalFarm<Animal> animalFarm = new AnimalFarm<>();
        AnimalFarm<Reptile> reptileAnimalFarm = new AnimalFarm<>();
    }
}
