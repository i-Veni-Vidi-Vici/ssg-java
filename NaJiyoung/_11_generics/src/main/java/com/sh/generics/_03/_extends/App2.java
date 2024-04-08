package com.sh.generics._03._extends;

/**
 * <pre>
 * 와일드카드 WildCard를 사용한 상/하한 제한
 * - 제네릭클래스와 별도로 매개변수부에서 타입을 다시한번 제한할 수 있다.
 *
 * - <?> 모든 타입을 의미
 * - <? extends A> A를 상속한 모든 타입 (상한제한)
 * - - 너무 어려우면 (? extends)는 생략해서 A만 있다고 생각하자..
 * - <? super B> B의 부모인 모든 타입 (하한제한) - 자주 쓰지 않는다
 *
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // ? 실제 RabbitFarm에서 허용하는 모든 타입
        RabbitFarm<?> rabbitFarm = new RabbitFarm<>(new Rabbit());
//        RabbitFarm<?> rabbitFarm2 = new RabbitFarm<>(new Snake());
//        RabbitFarm<?> rabbitFarm3 = new RabbitFarm<>(new Mammal());

        // ? extends Bunny : RabbitFarm<T extends Rabbit>를 다시한번 상한제한
        RabbitFarm<? extends Bunny> bunnyFarm = new RabbitFarm<>(new Bunny());
        RabbitFarm<? extends Bunny> bunnyFarm2 = new RabbitFarm<>(new DrunkenBunny());
//        RabbitFarm<? extends Bunny> bunnyFarm = new RabbitFarm<>(new Rabbit());
        Bunny bunny = bunnyFarm.getRabbit();
        bunny.cry(); // "🐰🐰🐰🐰🐰"
        Bunny bunny2 = bunnyFarm2.getRabbit();
        bunny2.cry(); // "🐰🍺🐰🍺🐰🍺🐰🍺"

        // ? super Bunny : Bunny 부모클래스만 허용
        RabbitFarm<? super Bunny> bunnyFarm3 = new RabbitFarm<Bunny>(new Bunny());
//        RabbitFarm<? super Bunny> bunnyFarm4 = new RabbitFarm<DrunkenBunny>(new DrunkenBunny()); // DrunkenBunny를 안쓰면 Bunny가 자동으로 되어 오류가 안남
        Rabbit rabbit = bunnyFarm3.getRabbit();
        rabbit.cry(); // "🐰🐰🐰🐰🐰"

        // 메소드호출
        WildCardFarm.anyRabbit(new RabbitFarm<Rabbit>(new Rabbit()));
        WildCardFarm.anyBunny(new RabbitFarm<Bunny>(new Bunny()));
        WildCardFarm.anyBunny(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));
        WildCardFarm.anyRabbitOrBunny(new RabbitFarm<Bunny>(new Bunny()));
//        WildCardFarm.anyRabbitOrBunny(new RabbitFarm<DrunkenBunny>(new Bunny())); // <DrunkenBunny>를 가지고 있는 RabbitFarm은 전달할 수 없다.
    }
}
