package com.sh.generics._03._extends;

<<<<<<< HEAD
public class App2 {
    public static void main(String[] args) {
=======
/**
 * <pre>
 * 와일드카드 Wildcard를 사용한 상/하한 제한
 * - 제네릭클래스와 별도로 매개변수부에서 타입을 다시한번 제한 할수 있다.
 * 
 * - <?> 모든 타입을 의미
 * - <? extends A> A를 상속한 모든 타입 (상한제한)
 * - <? super B> B의 부모인 모든 타입 (하한제한)
 *     
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // ? 실제 RabbitFarm에서 허용하는 모든 타입
>>>>>>> 97aa7183c9fb127e3cf611ff187d772054906c64
        RabbitFarm<?> rabbitFarm = new RabbitFarm<>(new Rabbit());
//        RabbitFarm<?> rabbitFarm2 = new RabbitFarm<>(new Snake());
//        RabbitFarm<?> rabbitFarm3 = new RabbitFarm<>(new Mammal());

<<<<<<< HEAD
        // ? extends Bunny : RabbitFarm<T extends Rabbit>를 다시 한번 상한 제한
        RabbitFarm<? extends Bunny> bunnyFarm = new RabbitFarm<>(new Bunny());
        RabbitFarm<? extends Bunny> bunnyFarm2 = new RabbitFarm<>(new DrunkenBunny());

//        RabbitFarm<? extends Bunny> bunnyFarm2 = new RabbitFarm<>(new Rabbit());
=======
        // ? extends Bunny : RabbitFarm<T extends Rabbit>를 다시한번 상한제한
        RabbitFarm<? extends Bunny> bunnyFarm = new RabbitFarm<>(new Bunny());
        RabbitFarm<? extends Bunny> bunnyFarm2 = new RabbitFarm<>(new DrunkenBunny());
//        RabbitFarm<? extends Bunny> bunnyFarm = new RabbitFarm<>(new Rabbit());
>>>>>>> 97aa7183c9fb127e3cf611ff187d772054906c64
        Bunny bunny = bunnyFarm.getRabbit();
        bunny.cry();
        Bunny bunny2 = bunnyFarm2.getRabbit();
        bunny2.cry();

<<<<<<< HEAD
        // ? super Bunny : Bunny 부모 클래스만 허용
        RabbitFarm<? super Bunny> bunnyFarm3 = new RabbitFarm<>(new Bunny());
//        RabbitFarm<? super Bunny> bunnyFarm4 = new RabbitFarm<DrunkenBunny>(new DrunkenBunny());
        //제네릭의 특징 : 컴파일 타임에 체크하고 런타임에 제거된다

=======
        // ? super Bunny : Bunny 부모클래스만 허용
        RabbitFarm<? super Bunny> bunnyFarm3 = new RabbitFarm<Bunny>(new Bunny());
//        RabbitFarm<? super Bunny> bunnyFarm4 = new RabbitFarm<DrunkenBunny>(new DrunkenBunny());
        Rabbit rabbit = bunnyFarm3.getRabbit();
        rabbit.cry();

        // 메소드호출
        WildCardFarm.anyRabbit(new RabbitFarm<Rabbit>(new Rabbit()));
        WildCardFarm.anyBunny(new RabbitFarm<Bunny>(new Bunny()));
        WildCardFarm.anyBunny(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));
        WildCardFarm.anyRabbitOrBunny(new RabbitFarm<Bunny>(new Bunny()));
>>>>>>> 97aa7183c9fb127e3cf611ff187d772054906c64
    }
}
