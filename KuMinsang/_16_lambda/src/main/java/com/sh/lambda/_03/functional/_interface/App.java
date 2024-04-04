package com.sh.lambda._03.functional._interface;

import java.util.function.*;

/**
 * <pre>
 *     jdk가 제공하는 함수형 인터페이스 5가지
 *     1. Runnable#run():void
 *     2. Consumer#accept(P):void
 *     3. supplier#get():R
 *     4. Function#apply(P):R
 *     5. Predicate#test(V):Boolean
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //매개변수 없고, 리턴 값도 없는 람다 => 상호작용이 없다
        Runnable runnable = () -> System.out.println("🎈🎈🎈🎈🎈🎈");
        runnable.run();

        //매개변수만 있고, 리턴 값은 없는 람다 : 소비자
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept("💎💎💎💎");

        //매개변수가 없고, 리턴 값만 있는 람다 : 공급자
        Supplier<Integer> supplier = () -> (int) Math.random() * 100;
        System.out.println(supplier.get());

        //매개변수도 있고, 리턴값도 있는 람다 : 함수
        Function<String, Integer> fuction = (str) -> str.length();
        System.out.println(fuction.apply("5글자란다"));

        // 매개변수를 받아서, 논리 값을 반환하는 람다 : Predicate
        Predicate<Integer> predicate = (n) -> (n % 2) == 0;
        System.out.println(predicate.test(10)); //true
        System.out.println(predicate.test(7));  //false




    }
}
