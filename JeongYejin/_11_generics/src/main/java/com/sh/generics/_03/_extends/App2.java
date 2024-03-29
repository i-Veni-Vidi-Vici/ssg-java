package com.sh.generics._03._extends;

/**
 * <pre>
 * 와일드카드 Wildcard를 사용한 상/하한 제한
 * - 제네릭클래스와 별도로 매개변수부에서 타입을 다시한번 제한할 수 있다.
 *
 * - <?> 모든 타입을 의미
 * - <? extends A> A를 상속한 모든 타입 (상한제한)
 * - <? super B> B의 부모인 모든 타입 (하한제한)
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // ? 실제 RabbitFarm에서 허용하는 모든 타입
        // T extends Rabbit <= Rabbit을 상속하는 객체 타입 (Bunny, DrunkenBunny)
        RabbitFarm<?> rabbitFarm = new RabbitFarm<>(new Rabbit());
        RabbitFarm<?> rabbitFarm2 = new RabbitFarm<>(new Bunny());
        RabbitFarm<?> rabbitFarm3 = new RabbitFarm<>(new DrunkenBunny());
//        RabbitFarm<?> rabbitFarm4 = new RabbitFarm<>(new Snake()); // (X)
//        RabbitFarm<?> rabbitFarm3 = new RabbitFarm<>(new Mammal()); // (X)

        // ? extends Bunny : RabbitFarm<T extends Rabbit>를 다시한번 상한제한
        // Bunny, DrunkenBunny
        RabbitFarm<? extends Bunny> bunnyFarm = new RabbitFarm<>(new Bunny());
//        RabbitFarm<? extends Bunny> bunnyFarm2 = new RabbitFarm<>(new Rabbit()); // (X)
        RabbitFarm<? extends Bunny> bunnyFarm3 = new RabbitFarm<>(new DrunkenBunny());
        Bunny bunny = bunnyFarm.getRabbit(); //꺼내면 최소한 바니
        bunny.cry();
        Bunny bunny2 = bunnyFarm3.getRabbit();
        bunny2.cry();

        // ? super Bunny : Bunny 부모클래스만 허용, Rabbit의 자식클래스만 허용
        // Rabbit, Bunny
        RabbitFarm<? super Bunny> bunnyFarm4 = new RabbitFarm<Rabbit>(new Rabbit());
        RabbitFarm<? super Bunny> bunnyFarm5 = new RabbitFarm<Bunny>(new Bunny());
        RabbitFarm<? super Bunny> bunnyFarm6 = new RabbitFarm<Rabbit>(new DrunkenBunny());
//        RabbitFarm<? super Bunny> bunnyFarm6 = new RabbitFarm<DrunkenBunny>(new DrunkenBunny());
        Rabbit rabbit = bunnyFarm4.getRabbit();
        rabbit.cry();
        Rabbit rabbit1 = bunnyFarm5.getRabbit();
        rabbit1.cry();
        Rabbit rabbit2 = bunnyFarm6.getRabbit();
        rabbit2.cry();

        // 메소드호출
//        WildCardFarm.anyRabbit(new RabbitFarm<Reptile>(new Rabbit())); // (X)
        WildCardFarm.anyRabbit(new RabbitFarm<Rabbit>(new Rabbit())); // Rabbit을 상속해야 함!
        // Bunny를 상속하는 자식 객체
        // Bunny, DrunkenBunny
//        WildCardFarm.anyBunny(new RabbitFarm<Rabbit>(new Bunny()));
        WildCardFarm.anyBunny(new RabbitFarm<Bunny>(new Bunny()));
        WildCardFarm.anyBunny(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));
        // Bunny의 부모 객체
        // Rabbit, Bunny
        WildCardFarm.anyRabbitOrBunny(new RabbitFarm<Rabbit>(new Rabbit()));
        WildCardFarm.anyRabbitOrBunny(new RabbitFarm<Rabbit>(new Bunny()));
        WildCardFarm.anyRabbitOrBunny(new RabbitFarm<Rabbit>(new DrunkenBunny()));
        WildCardFarm.anyRabbitOrBunny(new RabbitFarm<Bunny>(new Bunny()));
        WildCardFarm.anyRabbitOrBunny(new RabbitFarm<Bunny>(new DrunkenBunny()));
//        WildCardFarm.anyRabbitOrBunny(new RabbitFarm<Bunny>(new Rabbit()));
//        WildCardFarm.anyRabbitOrBunny(new RabbitFarm<DrunkenBunny>(new DrunkenBunny())); // (X)
    }
}