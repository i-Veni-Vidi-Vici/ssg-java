package com.sh.generics._03._extends;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <pre>
 * Generics 상한/하한 제한
 * - <A extends B> : B를 상속한 A타입만 가능 (상한 제한) -> 주로 사용
 * - <A super B> : B의 부모클래스인 A타입만 가능 (하한 제한)
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

        RabbitFarm<Bunny> bunnyRabbitFarm = new RabbitFarm<>(new Bunny()); // 다형성
        RabbitFarm<Bunny> bunnyRabbitFarm2 = new RabbitFarm<>(new DrunkenBunny());

        RabbitFarm<DrunkenBunny> drunkenBunnyRabbitFarm = new RabbitFarm<>(new DrunkenBunny());

        Rabbit rabbit = rabbitFarm.getRabbit();
        rabbit.cry();
        Rabbit rabbit2 = rabbitFarm2.getRabbit();
        rabbit2.cry(); // 상속/다형성이 적용되고 오버라이드가 됐을 때 동적바인딩이 된다.

        // AnimalFarm<A extends Animal>
        AnimalFarm<Animal> animalFarm = new AnimalFarm<>();
        AnimalFarm<Reptile> reptileAnimalFarm = new AnimalFarm<>();
    }
}
