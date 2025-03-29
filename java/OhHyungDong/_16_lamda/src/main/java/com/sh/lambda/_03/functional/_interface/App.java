package com.sh.lambda._03.functional._interface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * <pre>
 *  jdk가 제공하는 함수형 인터페이스 5가지
 *  1. Runnable#run() : void - run()
 *  2. Consumer#accept(P):void - accept()
 *  3. Supplier#get():R - get()
 *  4. Function#apply(P) : R - apply()
 *  5. Predicate#test(V):boolean - test()
 * </pre>
 *
 */
public class App {
    public static void main(String[] args) {
        //매개변수 없고, 리턴값도 없는 람다
        Runnable runnable = () -> System.out.println("풍선풍선풍선");
        runnable.run();

        //매개변수만 있고, 리턴값은 없는 람다 : 소비자
        Consumer<String> consumer = (s) -> System.out.println(s);//리턴값이 없어서 s를 System.out.println(s)가 되도록 출력
        consumer.accept("🌧🌧🌧");

        //매개변수는 없고, 리턴값만 있는 ㄹ마다 : 공급자
        Supplier<Integer> supplier = () -> (int) (Math.random() * 100);
        System.out.println(supplier.get());

        //매개변수도 있고, 리턴값도 있는 람다 : 함수
        Function<String, Integer> function = (str) -> str.length();//매개벼수 str -> 리턴값 : str.length
        System.out.println("helloworld : " + function.apply("helloworld"));

        //매개변수를 받아서, 논리값을 반환하는 람다 : Predicate
        Predicate<Integer> predicate = (n) -> n % 2 ==0;
        System.out.println(predicate.test(20));
        System.out.println(predicate.test(33));
    }
}
