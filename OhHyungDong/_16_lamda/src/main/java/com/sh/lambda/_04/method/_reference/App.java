package com.sh.lambda._04.method._reference;

import java.util.Arrays;
import java.util.function.*;

/**
 * 메소드 참조
 * - 람다식을 더 간겨하게 표현하는 문법
 * - namespace :: method -> 클래스 또는 객체::메소드명
 *
 * - static method
 * - non-static method
 * - 특정객체 기준 메소드
 * - 생성자
 *
 */
public class App {
    public static void main(String[] args) {
        //매개인자는 하나 있고, 리턴값은 없는 람다
//        Consumer<String> consumer = (str) -> System.out.println(str);
        Consumer<String> consumer = System.out::println; //println == System.out.println
        consumer.accept("홍길동");

//        Function<String, Integer> function = (str) -> Integer.parseInt(str);
        Function<String, Integer> function = Integer::parseInt;
        System.out.println(function.apply("123"));

//
//        Function<String,Integer> function2 = (str) ->str.length();
//        ToIntFunction<String> function3 = (str) ->str.length();
        ToIntFunction<String> function3 = String::length;
        System.out.println(function3.applyAsInt("abcde"));

        //특정객체 기준 메소드 참조
//        BiFunction<String, String, Boolean> biFunction = (str1, str2) -> str1.equals(str2);
        BiFunction<String, String, Boolean> biFunction = String::equals;

        String str = "Hello";
//        Predicate<String> predicate = (txt) -> str.equals(txt);
        Predicate<String> predicate =  str::equals;
        System.out.println(predicate.test("Hello"));
        System.out.println(predicate.test("hello"));

        //생성자 참조
//        Supplier<Person> supplier1 = () -> new Person();
        Supplier<Person> supplier1 = Person::new;
        System.out.println(supplier1.get());

        //long 생성자 호출 - 서로 다른 생성자이지만 함수형 인터페이스가 다르기 때문에 서로 다른 생성자가 호출된다.
//        Function<Long, Person> function1 = (id) -> new Person(id);
        Function<Long, Person> function1 = Person::new;
        System.out.println(function1.apply(1L));

        //String int 생성자 호출 - BiFunction(이름,나이,클래스 생성자(리턴값))
        BiFunction<String,Integer,Person> function2 = Person::new;
        System.out.println(function2.apply("홍길동",20));

        //long, String, int 생성자 호출 - JDK는 매개인자를 2개까지만 받는 메소드 참조가 있다.
//        TriFunction<Long,String,Integer,Person>

        //배열 생성
//        Function<Integer, int[]> intArrGenerator = (length) -> new int[length];
        Function<Integer,int[]> intArrGenerator = int[]::new;
        System.out.println(Arrays.toString(intArrGenerator.apply(3)));
    }
}
