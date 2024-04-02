package com.sh.generics._03._extends;

/**
 * <pre>
 *  와일드 카드Wildcard 를 사용한 상/하한 제한
 *  - 제네릭 클래스와 별도로 매개변수부에서 타입을 다시한번 제한 할 수 있음.
 *
 *  <?> : 와일드 카드
 *  - 모든 타입을 의미함
 *  - <? extends A> : A를 상속한 모든 타입 가능 (상한 제한)
 *  - <? super B> : B의 부모인 모든 타입 (하한 제한)
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // ? : 모든 타입이라고 해도 Object를 의미하는 것이 아니고, RabbitFarm에서 허용하는 모든 타입
        RabbitFarm<?> rabbitFarm = new RabbitFarm<>(new Rabbit());
//        RabbitFarm<?> rabbitFarm2 = new RabbitFarm<>(new Snake()); : rabbit으로 상한이 걸려있기 때문에 Rabbit을 상속하는 클래스만 가능함.

        // ? extends Bunny : RabbitFarm<T extends Rabbit>를 다시한번 상한제한 -> Bunny를 상한제한으로 수정함
        RabbitFarm<? extends Bunny> bunnyFarm = new RabbitFarm<>(new Bunny());
        Bunny bunny = bunnyFarm.getRabbit();

        // ? super Bunny : Bunny의 부모 클래스만 허용
        RabbitFarm<? super Bunny> bunnyFarm3 = new RabbitFarm<Bunny>(new Bunny());
//        RabbitFarm<? super Bunny> bunnyFarm3 = new RabbitFarm<DrunkenBunny>(new DrunkenBunny());
        Rabbit rabbit = bunnyFarm3.getRabbit();
        rabbit.cry();

        //메소드 호출
        WildCardFarm.anyRabbit(new RabbitFarm<Rabbit>(new Rabbit()));
        WildCardFarm.anyBunny(new RabbitFarm<Bunny>(new Bunny()));
        WildCardFarm.anyBunny(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));
        WildCardFarm.anyRabbitorBunny(new RabbitFarm<Bunny>(new Bunny()));
    }
}
