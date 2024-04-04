package com.sh._04.method.reference;

import java.util.function.*;

/**
 * 메소드 참조
 * 람다식을 더 간결하게 표현하는 문법.
 * namespce::method -> 클래스 또는 객체 :: 메소드명
 */
public class App {
    public static void main(String[] args) {
        Consumer<String> consumer = (str) -> System.out.println(str);
        consumer.accept("홍길동");

        Function<String, Integer> function = (str) ->Integer.parseInt(str);
        System.out.println(function.apply("123"));

        ToIntFunction<String> function2 = String :: length;
        System.out.println(function2.applyAsInt("abcde"));

        //특정객체 기준 메소드참조
       // BiFunction<String,String,Boolean> biFunction= (str1,str2)-> str1.equals(str2);
        BiFunction<String,String,Boolean> biFunction = String::equals;

        //생성자 참조
        Supplier<Person> supplier1 = Person::new;
        System.out.println(supplier1.get());

        Function<Long,Person> personFunction = Person::new;
        System.out.println(personFunction.apply(1L));

        //String int 생성자 호출
        BiFunction<String, Integer,Person> personFunction2 = Person::new;

        //long,String,int 생성자 호출
        //TriFunction<Long,String,Integer,Person>...
        //배열생성


    }
}
