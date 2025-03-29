package com.sh.generics._03._extends;

/**
 * <pre>
 * 와일드카드 Wildcard를 사용한 상/하한 제한
 * - 제네릭클래스와 별도로 매개변수부에서 타입을 다시 한 번 제한할 수 있다.
 *
 * <?> = 모든 타입을 의미한다.
 *  <? extends A> : A를 상속한 모든 타입(상한 제한)
 *  <? super B> : B의 부모인 모든 타입(하한 제한)
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        RabbitFarm<?> rabbitFarm = new RabbitFarm<>(new Rabbit());
        // ? 실제 RabbitFarm에서 허용하는 모든 타입을 말한다 (Object를 말하는 것은 아니다.)
//        RabbitFarm<?> rabbitFarm2 = new RabbitFarm<>(new Snake());
//        RabbitFarm<?> rabbitFarm3 = new RabbitFarm<>(new Mammal());

        // ? extends Bunny : RabbitFarm<T extends Rabbit>를 다시 한 번 상한제한 한 것
        RabbitFarm<? extends Bunny> bunnyFarm = new RabbitFarm<>(new Bunny());
        RabbitFarm<? extends Bunny> bunnyFarm2 = new RabbitFarm<>(new DrunkenBunny());
//        RabbitFarm<? extends Bunny> bunnyFarm = new RabbitFarm<>(new Rabbit());
        Bunny bunny = bunnyFarm.getRabbit();
        bunny.cry();
        Bunny bunny2 = bunnyFarm2.getRabbit();
        bunny2.cry();

        // ? super Bunny : Bunny의 부모클래스만 허용
        RabbitFarm<? super Bunny> bunnyFarm3 = new RabbitFarm<Bunny>(new Bunny());
        // DrunkendBunny는 Bunny의 부모가 아니기에 될 수가 없다.
//        RabbitFarm<? super Bunny> bunnyFarm4 = new RabbitFarm<DrunkenBunny>(new DrunkenBunny());
        Rabbit rabbit = bunnyFarm3.getRabbit();
        rabbit.cry();

        // 메소드호출
        WildCardFarm.anyRabbit(new RabbitFarm<Rabbit>(new Rabbit()));
        WildCardFarm.anyBunny(new RabbitFarm<Bunny>(new Bunny()));
        WildCardFarm.anyBunny(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));
        WildCardFarm.anyRabbitOrbunny(new RabbitFarm<Bunny>(new Bunny()));

    }
}
