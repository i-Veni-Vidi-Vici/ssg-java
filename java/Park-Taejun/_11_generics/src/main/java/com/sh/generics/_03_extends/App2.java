package com.sh.generics._03_extends;

/**
 * <pre>
 * 와일드카드를 사용한 상/하한 제한
 * - 제네릭 클래스와 별도로 매개변수부에서 타입을 다시한번 제한 할 수 있다.
 *
 *
 * <?> 모든 타입을 의미함 object와 같은 것
 * <? extneds A> A를 상속한 모든 타입이 됨 ( 상한제한)
 * <? super B> B의 부모인 모든 타입 (하한제한)
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // ? -> 모든 타입이라고 하지만 오브젝트를 의미하는 것은 아님 // 실제 RabbitFarm에서 허용하는 모든 타입
        RabbitFarm<?> rabbitFarm = new RabbitFarm<>(new Rabbit());
//        RabbitFarm<?> rabbitFarm2 = new RabbitFarm<>(new Snake()); 또한 Mamaml 도 안될 것임


        // ? extends Bunny 의 의미?
        // -> 실제 레빗 팜에서는 RabbitFarm < T extends Rabbit> 를 다시한번 상한 제한 한 것임.
        // Rabbit 도 걸러 낸 것임, 따라서 래빗은 X

        RabbitFarm<? extends Bunny> bunnyFarm = new RabbitFarm<>(new Bunny());
        RabbitFarm<? extends Bunny> bunnyFarm2 = new RabbitFarm<>(new DrunkenBunny());
//        RabbitFarm<? extends Bunny> bunnyFarm = new RabbitFarm<>(new Rabbit());
        Bunny bunny = bunnyFarm.getRabbit();
        bunny.cry();

        Bunny bunny2 = bunnyFarm2.getRabbit();
        bunny2.cry();

        // ? super Bunny
        // -> Bunny의 부모클래스만 허용
        // Drunken bunny 제외

        RabbitFarm<? super  Bunny> bunnyFarm3 = new RabbitFarm<Bunny>(new Bunny());
//        RabbitFarm<? super  Bunny> bunnyFarm4 = new RabbitFarm<DrunkenBunny>(new DrunkenBunny());
        // Bunny 가 생략되어서 오류가 안났던 것임

        Rabbit rabbit = bunnyFarm3.getRabbit();
        rabbit.cry();

        // 메소드호출
        WildCardFarm.anyRabbit(new RabbitFarm<Rabbit>(new Rabbit()));
        WildCardFarm.anyRabbit(new RabbitFarm<Bunny>(new Bunny()));
        WildCardFarm.anyRabbit(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));
        WildCardFarm.anyRabbitOrBunny(new RabbitFarm<Bunny>(new Bunny()));
    }
}
