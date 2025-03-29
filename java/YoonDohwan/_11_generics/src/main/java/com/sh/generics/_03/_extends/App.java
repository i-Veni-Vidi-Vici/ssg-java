package com.sh.generics._03._extends;

/**
 * Generics 상한/하한 제한
 * -<A extends B> B를 상속한 A타입만 가능
 * -<A super B>  B의 부모클래스인  A타입만 가능(하한 제한)
 *
 *
 */
public class App {
    public static void main(String[] args) {
        //RabbitFarm<T>
        //RabbitFarm<Animal> animalFarm = new RabbitFarm<>(new Mammal());
        RabbitFarm<Animal> animalFarm2 = new RabbitFarm<>(new Reptile() );
        RabbitFarm<Animal> animalFarm3= new RabbitFarm<>(new Rabbit());
        RabbitFarm<Animal> animalFarm4= new RabbitFarm<>(new Snake());


        RabbitFarm<Rabbit> rabbitFarm = new RabbitFarm<>(new Rabbit());
        RabbitFarm<Bunny> bunnyRabbitFarm = new RabbitFarm<>(new Bunny());
        RabbitFarm<DrunkenBunny> drunkenBunnyRabbitFarm = new RabbitFarm<>(new DrunkenBunny());

        Rabbit rabbit = rabbitFarm.getRabbit();
        rabbit.cry();

        //AnimalFarm<A extends Animal>
        AnimalFarm<Animal> animalFarm = new AnimalFarm<>();
        AnimalFarm<Reptile> reptileAnimalFarm = new AnimalFarm<>();


    }
}
