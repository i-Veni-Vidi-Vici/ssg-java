package com.sh.generics._03._extends;

/**
 * <pre>
 * 와일드카드 Wildcard를 사용한 /상/하한 제한
 * - 제네릭크래스와 별도로 매개변수부에서 타입을 다시 한 번 제한 할 수 있다.
 *
 * <?> 모든 타입을 의미
 * <? extends A> A를 상속한 모든 타입이 가능 (상한제한)
 * <? super B> B의 부모인 모든 타입이 가능 (하한제한)
 *
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // ? 모든 타입이지만 object가 아니다
        // ? 실제 RabbitFarm에서 허용하는 모든 타입
        RabbitFarm<?> rabbitFarm=new RabbitFarm<>(new Rabbit());
//        RabbitFarm<?> rabbitFarm2=new RabbitFarm<>(new Snake());//상한제한 되어 있는 RabbitFarm이기 때문에 자손들만 된다

        // ? extends Bunny : RabbitFarm<T extends Rabbit>를 다시 한 번 상한 제한
        RabbitFarm<? extends Bunny> bunnyFarm = new RabbitFarm<>(new Bunny());
        RabbitFarm<? extends Bunny> bunnyFarm2 = new RabbitFarm<>(new DrunKenBunny());

        Bunny bunny=bunnyFarm.getRabbit();
        bunny.cry();


        //? super Bunny

        //Bunny의 부모클래스만 가능하다
        RabbitFarm<? super Bunny> bunnyFarm3 = new RabbitFarm<Bunny>(new Bunny());
        //RabbitFarm<? super Bunny> bunnyFarm4 = new RabbitFarm<DrunKenBunny>(new DrunKenBunny());
        Rabbit rabbit = bunnyFarm3.getRabbit();
        rabbit.cry();


        //메소드호출
        WildCardFarm.anyRabbit(new RabbitFarm<Rabbit>(new Rabbit()));
        WildCardFarm.anyBunny(new RabbitFarm<Bunny>(new Bunny()));
        WildCardFarm.anyBunny(new RabbitFarm<>(new DrunKenBunny()));
        WildCardFarm.anyRabbitOrBunny(new RabbitFarm<>(new Bunny()));


    }
}
