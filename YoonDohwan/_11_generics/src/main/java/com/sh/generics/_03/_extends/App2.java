package com.sh.generics._03._extends;
/**
 * 와일드카드 wildcard를 사용한 상/하한 제한
 * -제네릭클래스와 별도로 매개변수부에서 타입을 다시한번 제한 할 수 있따.
 * <?>모든 타입을 의미
 * <? extends A> A를 상속한 모든 타입(상한제한)
 * <? super B> B의 부모인 모든 타입(하한제한)
 *
 */
public class App2 {
    public static void main(String[] args) {
        //? 실제 RabbitFarm에서 허용하는 모든타입
        RabbitFarm<?> rabbitFarm = new RabbitFarm<>(new Rabbit());
        //RabbitFarm<?> rabbitFarm2 = new RabbitFarm<>(new Snake());

        RabbitFarm<?extends Bunny>bunnyFarm = new RabbitFarm<>(new Bunny());
        Bunny bunny = bunnyFarm.getRabbit();

        //? Super Bunny : Bunny 부모클래스만 허용
        RabbitFarm<? super Bunny> bunnyFarm3 = new RabbitFarm<Bunny>(new Bunny());
        //RabbitFarm<? super Bunny> bunnyFarm4= new RabbitFarm<DrunkenBunny>(new DrunkenBunny());
        bunnyFarm3.getRabbit();


    }
}
