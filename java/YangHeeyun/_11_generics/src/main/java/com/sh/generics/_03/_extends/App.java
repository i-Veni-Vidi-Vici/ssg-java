package com.sh.generics._03._extends;

import java.time.LocalDate;

/**
 * <pre>
 *  Generics 상한/하한 제한
 *  <A extends B> B를 상속한 A타입만 가능 (상한 제한)
 *  타입문자    실제 클래스  자리
 *  <A super B> B의 부모클래스인 A타입만 가능(하한 제한)
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // RabbitFarm<T>
//    RabbitFarm<Animal> animalFarm = new RabbitFarm<>(new Mammal()); // 다형성 적용
//    RabbitFarm<Animal> animalFarm2 = new RabbitFarm<>(new Reptile());
//    RabbitFarm<Animal> animalFarm3 = new RabbitFarm<>(new Rabbit());
//    RabbitFarm<Animal> animalFarm4 = new RabbitFarm<>(new Snake());
////    RabbitFarm<LocalDate> animalFarm5 = new RabbitFarm<>(LocalDate.now());

        // RabbitFarm <T extends Rabbit>
        RabbitFarm<Rabbit> rabbitFarm = new RabbitFarm<>(new Rabbit());
        // 다형성 덕분에 Rabbit뿐 아니라 자식클래스도 가능
        RabbitFarm<Rabbit> rabbitFarm2 = new RabbitFarm<Rabbit>(new Bunny());
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
//        AnimalFarm<LocalDate> localDateAnimalFarm = new AnimalFarm<>();
    }
}
