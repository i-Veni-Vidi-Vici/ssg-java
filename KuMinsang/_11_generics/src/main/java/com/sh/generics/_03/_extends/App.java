package com.sh.generics._03._extends;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import java.time.LocalDate;

/** <pre>
 * Generic 상한/하한 제한
 * - <A extends B> B를 상속한 A타입만 가능 (상한 제한)
 * - <A super B> B의 부모클래스인 A타입만 가능 (하한 제한)
 * -
 * </pre>
 *
 */
public class App {
    public static void main(String[] args) {
//        //RabbitFarm<T>
//        RabbitFarm<Animal> animalFarm = new RabbitFarm<>(new Mammal());
//        RabbitFarm<Animal> animalFarm2 = new RabbitFarm<>(new Reptile());
//        RabbitFarm<Animal> animalFarm3 = new RabbitFarm<>(new Rabbit());
//        RabbitFarm<Animal> animalFarm4 = new RabbitFarm<>(new Snake());
//        // RabbitFarm<Animal> animalFarm4 = new RabbitFarm<>(LocalDate.now());  //Animal의 하위 클래스가 아니어서 불가
//
//        RabbitFarm<LocalDate> localDateRabbitFarm = new RabbitFarm<>(LocalDate.now());
//

        RabbitFarm<Rabbit> rabbitFarm = new RabbitFarm<>(new Rabbit());
        RabbitFarm<Rabbit> rabbitFarm2 = new RabbitFarm<>(new Bunny());
        RabbitFarm<Rabbit> rabbitFarm3 = new RabbitFarm<>(new DrunkenBunny());

        RabbitFarm<Bunny> bunnyRabbitFarm = new RabbitFarm<>(new Bunny());
        RabbitFarm<Bunny> bunnyRabbitFarm2 = new RabbitFarm<>(new DrunkenBunny());

        RabbitFarm<DrunkenBunny> drunkenBunnyRabbitFarm = new RabbitFarm<>(new DrunkenBunny());

        Rabbit rabbit = rabbitFarm.getRabbit();
        rabbit.cry();

        Rabbit rabbit2 = rabbitFarm2.getRabbit();
        rabbit2.cry();  //동적바인딩, 오버라이딩된 메소드가 출력



    }
}
