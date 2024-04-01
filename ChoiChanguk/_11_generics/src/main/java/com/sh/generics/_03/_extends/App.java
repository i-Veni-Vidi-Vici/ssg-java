package com.sh.generics._03._extends;

import com.sh.generics._01._class.Box;

import java.time.LocalDate;

/**
 *<pre>
 * Generics 상한/하한 제한
 * - <A extends B> B를 상송한 A타입만 가능 (상한 제한) // 이걸 많이 씀
 * - <A super > B의 부모클래스인 A타입만 가능 (하한 제한)
 *</pre>
 */
public class App {
    public void print()
    {
        System.out.println("안녕하세요");
    }
    public static void main(String[] args) {
        Boo

        //RabbitFarm
//    RabbitFarm<Animal> animalFarm=new RabbitFarm<>(new Mammal());// 다형성
//    RabbitFarm<Animal> animalFarm2=new RabbitFarm<>(new Reptile());
//    RabbitFarm<Animal> animalFarm3=new RabbitFarm<>(new Rabbit());
//    RabbitFarm<Animal> animalFarm4=new RabbitFarm<>(new Snake());
//    //RabbitFarm<Animal> animalFarm5=new RabbitFarm<>(LocalDate.now());
//
//    RabbitFarm<LocalDate> localDateRabbitFarm=new RabbitFarm<>(LocalDate.now());

//        RabbitFarm<T extends Rabbit>
        // 이거 이해 안됨 RabbitFarm<Mammal> rabbitFarm0=new RabbitFarm<>(new Rabbit());// 자손이 왜 부모로 못가는가 -> RabbitFarm에서 extends로 Rabbit까지만 해놯기 때문이다
        RabbitFarm<Rabbit> rabbitFarm=new RabbitFarm<>(new Rabbit());//다형성, 즉 부모인Rabbit아래 자손들이 들어 갈 수 있다
        RabbitFarm<Rabbit> rabbitFarm2=new RabbitFarm<>(new Bunny());//Bunny이긴 하지만 제네릭(여기서 부모 Rabbit) 기준으로 생성된다
        RabbitFarm<Rabbit> rabbitFarm3=new RabbitFarm<>(new DrunKenBunny());

        RabbitFarm<Bunny> bunnyRabbitFarm=new RabbitFarm<>(new Bunny());
        RabbitFarm<DrunKenBunny> drunKenBunnyRabbitFarm=new RabbitFarm<>(new DrunKenBunny());

        Rabbit rabbit = rabbitFarm.getRabbit();
        rabbit.cry();
        Rabbit rabbit1 = rabbitFarm2.getRabbit();
        rabbit1.cry();//동적바인딩 <- 조건들 : 상속/다형성 & 오버라이드
                    // 오버라이드가 먼저이기 때문에 즉 부모->자손(오버라이드된)

        AnimalFarm<Animal> animalAnimalFarm=new AnimalFarm<>();
        AnimalFarm<Reptile> reptileAnimalFarm=new AnimalFarm<>();

    }
}
