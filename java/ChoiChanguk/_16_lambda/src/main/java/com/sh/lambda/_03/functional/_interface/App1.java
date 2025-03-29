package com.sh.lambda._03.functional._interface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * <pre>
 * jdk가 제공하는 함수형 인터페이스 5가지
 * 1. Runnable#run():void       매개변수 x -> 리턴 X
 * 2. Consumer#accep(P):void    매개변수 O -> 리턴 X
 * 3. Supplier#get():R          매개변수 X -> 리턴 O
 * 4. Function#apply(P):R       매개변수 O -> 리턴 O
 * 5. Predicate#test(V):boolean 매개변수 O -> bool
 *
 * 매개변수 x -> 리턴없음
 * 매개변수 O -> 리턴없음
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        // 매변수 없고, 리턴값도 없는 람다
        Runnable r=()->{ System.out.println("1. Runnable 람다입니다"); };
        r.run();

        //매개변수만 있고, 리턴값이 없는 람다 : 소비자
        Consumer<String > consumer=(String str)->{ System.out.println(str+" 입니다");};
        consumer.accept("2. Consumer");

        //매개변수 없음, 리턴값 존재 : 공급자
        Supplier<String > supplier=()->{ return "3. Supplier 입니다"; };
        System.out.println(supplier.get());

        // 매개변수 있음, 리턴값 있음 : 함수
        Function<String , Integer> function =(str)->str.length();
        System.out.println("4. Function 입니다"+"helloworld : "+function.apply("helloworld"));

        //매개변수 있음, 논리값 반환 : Predicate
        Predicate<Integer> predicate=(n)->n%2==0;
        System.out.println("5. predicate 입니다 : "+predicate.test(4));
        System.out.println("5. predicate 입니다 : "+predicate.test(7));
    }
}
