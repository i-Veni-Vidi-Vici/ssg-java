package com.sh.generics_03._extends;

/**
 * 와일드카드 Wildcard를 사용한 상/하한 제한
 * - 제네릭클래스와 별도로 매개변수부에서 타입을 다시 한번 제한 할 수 있다.
 * - <?> 모든 타입을 의미
 * - <? extends A> A를 상속한 모든 타입 (상한제한)
 * - <? super B> B의 부모인 모든 타입 (하한제한)
 */
public class App2 {
    public static void main(String[] args) {
        // ? 실제 RabbitFarm에서 허용하는 모든 타입
        RabbitFarm<?> rabbitFarm = new RabbitFarm<>(new Rabbit());
        // ? extends Bunny : RabbitFarm<T extends Rabbit>를 다시 한번 상한 제한
        RabbitFarm<? extends Bunny> bunnyFarm = new RabbitFarm<>(new Bunny());
        RabbitFarm<? extends Bunny> bunnyFarm2 = new RabbitFarm<>(new DrunkenBunny());
        Bunny bunny = bunnyFarm.getRabbit();
        bunny.cry();

        // ? super Bunny
        RabbitFarm<? super Bunny> bunnyFarm3 = new RabbitFarm<>(new Bunny());
        RabbitFarm<? super Bunny> bunnyFarm4 = new RabbitFarm<>(new DrunkenBunny());
        Rabbit rabbit = bunnyFarm3.getRabbit();

    }
}
