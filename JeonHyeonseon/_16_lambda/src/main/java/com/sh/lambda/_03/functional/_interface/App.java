package com.sh.lambda._03.functional._interface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * <pre>
 * jdk가 제공하는 함수형 인터페이스 5가지
 * 1. Runnable#run():void 매개변수 없고 리턴타입도 없다
 * 2. Consumer#accept(P):void 매개변수(P)있고 리턴타입은 없다
 * 3. Supplier#get():R 매개변수 없고 반환한다.
 * 4. Function#apply(P):R 매개변수 받고 반환한다.
 * 5. Predicate#test(V):boolean 하나를 받고 boolean
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 매개변수 없고, 리턴값도 없는 람다 Runnable#run():void
        Runnable runnable = () -> System.out.println("⚽");  // runnable객체가 만들어진 것
        runnable.run();

        // 매개변수만 있고 리턴값은 없는 람다 : 소비자 Consumer#accept(P):void
        Consumer<String> consumer = (String s) -> System.out.println(s);
        consumer.accept("🥨🥨");
//        consumer.accept(123); // String타입이기 때문에 오류발생

        // 매개변수는 없고, 리턴값만 있는 람다 : 공급자 Supplier#get():R
        Supplier<Integer> supplier = () -> (int) (Math.random() * 100);
        System.out.println(supplier.get()); // supplier가 주는 것을 가져와라 .get()

        // 매개변수도 있고, 리턴값도 있는 람다 : 함수 Function#apply(P):R
        Function<String, Integer> function = (str) -> str.length(); // 매개변수, 리턴값 둘 다 받아야 한다.
        System.out.println("helloworld : " + function.apply("helloworld"));

        // 매개변수를 받아서, 논리값을 반환하는 람다 : Predicate Predicate#test(V):boolean
        Predicate<Integer> predicate = (n) -> (n % 2) == 0;
        System.out.println(predicate.test(20)); // true
        System.out.println(predicate.test(33)); // false

    }
}
