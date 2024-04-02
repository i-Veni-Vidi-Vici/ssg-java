package com.sh.generics._03._extends;

/**
 * <pre>
 *  Generice 상한 / 하한 제한
 *  - <A extends B > B를 상속한 A타입만 가능 (상한 제한)
 *  - <A super B> B의 부모 클래스인 A타입만 가능 (하한 제한)
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //RabbitFarm<T> - Animal => Malmmal, Reptile, Rabbit, Snake : 다형성에 의존
//        RabbitFarm<Animal> animalRabbitFarm = new RabbitFarm<>(new Mammal());
//        RabbitFarm<Animal> animalRabbitFarm2 = new RabbitFarm<>(new Reptile());
//        RabbitFarm<Animal> animalRabbitFarm3= new RabbitFarm<>(new Rabbit());
//        RabbitFarm<Animal> animalRabbitFarm4= new RabbitFarm<>(new Snake());

        //RabbitFarm<T extends Rabbit> -> Rabbit, Bunny, DrukenBunny
        RabbitFarm<Rabbit> rabbitFarm = new RabbitFarm<>(new Rabbit());// 다형성에 의해서
        RabbitFarm<Rabbit> rabbitFarm2= new RabbitFarm<>(new Bunny());
        RabbitFarm<Rabbit> rabbitFarm3 = new RabbitFarm<>(new DrunkenBunny());

        RabbitFarm<Bunny> bunnyRabbitFarm = new RabbitFarm<>(new Bunny());
        RabbitFarm<Bunny> bunnyRabbitFarm2 = new RabbitFarm<>(new DrunkenBunny());

        RabbitFarm<DrunkenBunny> drunkenBunny = new RabbitFarm<>(new DrunkenBunny());

        Rabbit rabbit = rabbitFarm.getRabbit();
        rabbit.cry();
        Rabbit rabbit1 = rabbitFarm2.getRabbit();
        rabbit1.cry(); //동적 바인딩으로 인해서 new Bunny()에 있는 cry()메소드가 실행됨

        //AnimalFarm<A extends Animal>
        AnimalFarm<Animal> animalFarm = new AnimalFarm();
        AnimalFarm<Reptile> animalFarm2 = new AnimalFarm();

    }
}
