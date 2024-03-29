package com.sh.generics._03._extends;

import java.time.LocalDate;

/**
 * <pre>
 *     ### Generic 상한/하한 제한
 *
 * - `<A extends B>` : B를 상속한 A타입만 가능 = `상한 제한` → 위로 끄는 것
 * - `<A super B>` : B의 부모클래스인 A 타입만 가능 = `하한 제한` → 아래로 끄는 것
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //RabbitFarm<T>
//        RabbitFarm<Animal> animalFarm = new RabbitFarm<>(new Mammal()); ;//다형성 적용
//        RabbitFarm<Animal> animalFarm2 = new RabbitFarm<>(new Reptile());
//        RabbitFarm<Animal> animalFarm3 = new RabbitFarm<>(new Rabbit());
//        RabbitFarm<Animal> animalFarm4 = new RabbitFarm<>(new Snake());
//        RabbitFarm<Animal> animalFarm5 = new RabbitFarm<>(LocalDate.now());

        //RabbitFarm<T extends Rabbit>
//        RabbitFarm<Animal> rabbitFarm = new RabbitFarm<>(new Rabbit()); //Type parameter 'com.sh.generics._03._extends.Animal' is not within its bound; should implement 'com.sh.generics._03._extends.Rabbit'

        RabbitFarm<Rabbit> rabbitFarm = new RabbitFarm<>(new Rabbit());
        RabbitFarm<Rabbit> rabbitFarm2 = new RabbitFarm<>(new Bunny()); //다형성 덕분에 new Rabbit()자리에 자식 클래스인 new Bunny()도 올 수 있음
        RabbitFarm<Rabbit> rabbitFarm3 = new RabbitFarm<>(new DrunkenBunny());//다형성 덕분에 new Rabbit()자리에 자식 클래스인 new DrunkenBunny()도 올 수 있음

        RabbitFarm<Bunny> bunnyRabbitFarm = new RabbitFarm<>(new Bunny());
        RabbitFarm<Bunny> bunnyRabbitFarm2 = new RabbitFarm<>(new DrunkenBunny()); //다형성 적용

        RabbitFarm<DrunkenBunny> drunkenBunnyRabbitFarm = new RabbitFarm<>(new DrunkenBunny());

        Rabbit rabbit = rabbitFarm.getRabbit();//return 타입이 rabbit일 것으로 예상!
        rabbit.cry(); //🐇🐇🐇
        Rabbit rabbit2 = rabbitFarm2.getRabbit();
        rabbit2.cry(); //🐰🐰🐰 -> 상속/다형성 적용 & 메소드 오버라이드 했을 경우 -> 동적 바인딩 / 정적 바인딩이 먼저 되고, 조건이 맞았을 경우 동적 바인딩이 적용됨!!!!!!!!!!

        //AnimalFarm <A extends Animal>
        AnimalFarm<Animal> animalFarm = new AnimalFarm<>();
        AnimalFarm<Reptile> reptileAnimalFarm = new AnimalFarm<>();
//        AnimalFarm<LocalDate> LocalDateAnimalFarm = new AnimalFarm<>(); //안됨!



    }
}
