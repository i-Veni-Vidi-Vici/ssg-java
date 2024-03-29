package com.sh.generics._03._extends;

/**
 * <pre>
 * 와일드카드 Wildcard를 사용한 상/하한 제한
 * - 제네릭클래스와 별도로 매개변수부에서 타입을 다시 한번 제한 가능
 *
 * - <?> : 모든 타입 의미
 * - <? extends A> : A를 상속한 모든 타입 (상한제한)
 * - <? super B> : B의 부모인 모든 타입 (하한제한)
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // ? 실제 RabbitFarm에서 허용하는 모든 타입 (Object 포함 X)
        RabbitFarm<?> rabbitFarm = new RabbitFarm<>(new Rabbit());
//        RabbitFarm<?> rabbitFarm2 = new RabbitFarm<>(new Snake()); // 안됨
//        RabbitFarm<?> rabbitFarm2 = new RabbitFarm<>(new Mammal()); // 안됨

        // ? extends Bunny : RabbitFarm<T extends Rabbit>을 Bunny까지로 다시 한번 상한제한
        RabbitFarm<? extends Bunny> bunnyFarm = new RabbitFarm<>(new Bunny());
        RabbitFarm<? extends Bunny> bunnyFarm2 = new RabbitFarm<>(new DrunkenBunny());
//        RabbitFarm<? extends Bunny> bunnyFarm3 = new RabbitFarm<>(new Rabbit()); // 안됨
        Bunny bunny = bunnyFarm.getRabbit(); // Bunny까지로 제한을 걸었기때문에 타입은 Bunny
        bunny.cry(); // 🐇
        Bunny bunny2 = bunnyFarm2.getRabbit();
        bunny2.cry(); // 🐰🍺🍺

        // ? super Bunny : Bunnny의 부모클래스만 허용
        RabbitFarm<? super Bunny> bunnyFarm3 = new RabbitFarm<Bunny>(new Bunny());
//        RabbitFarm<? super Bunny> bunnyFarm4 = new RabbitFarm<DrunkenBunny>(new DrunkenBunny()); // 안됨
        Rabbit rabbit = bunnyFarm3.getRabbit(); // 위에서 extends Bunny 한 후 super Bunny 해서 여전히 Rabbit이 상한제한
        rabbit.cry(); // 🐇

        // 메소드 호출
        WildCardFarm.anyRabbit(new RabbitFarm<Rabbit>(new Rabbit())); // 🐰
        WildCardFarm.anyBunny(new RabbitFarm<Bunny>(new Bunny())); // 🐇
        WildCardFarm.anyBunny(new RabbitFarm<DrunkenBunny>(new DrunkenBunny())); // 🐰🍺🍺
        WildCardFarm.anyRabbitOrBunny(new RabbitFarm<Bunny>(new Bunny())); // 🐇
    }
}
