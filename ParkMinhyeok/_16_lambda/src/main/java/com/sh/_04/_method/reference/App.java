package com.sh._04._method.reference;

import java.util.Arrays;
import java.util.Deque;
import java.util.function.*;

/**
 * <pre>
 * - 람다식을 더 간결하게 표현하는 문법.
 * - namespace::method -> 클래스 또는 객체::메소드명
 *
 * - static method
 * - non-static method
 * - 특정객체 기준 메소드
 * - 생성자
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 매개인자가 하나 있고, 리턴값은 없는 람다
//        Consumer<String> consumer = (str) -> System.out.println(str);
        Consumer<String> consumer = System.out::println;
        consumer.accept("홍길동");

        // Function<String, Integer>
//        Function<String, Integer> function = (str) -> Integer.parseInt(str))
        Function<String, Integer> function = Integer::parseInt;
        System.out.println(function.apply("123"));

        // "abcde" -> 5
//        Function<String, Integer> function2 = (str) -> str.length();
        Function<String, Integer> function2 = String::length;
        System.out.println(function2.apply("abcde"));

        ToIntFunction<String> function3 = String::length;
        System.out.println(function3.applyAsInt("abcde"));

        // 특정객체 기준 메소드 참조
//        BiFunction<String, String, Boolean> biFunction = (str1, str2) -> str1.equals(str2);
        BiFunction<String, String, Boolean> biFunction = String::equals;
        System.out.println(biFunction.apply("Hello", "Hello"));
        System.out.println(biFunction.apply("Hello", "hello"));

        String str = "Hello";
        Predicate<String> predicate = str::equals;
        System.out.println(predicate.test("Hello"));
        System.out.println(predicate.test("hello"));

        // 생성자 참조
        // 기본생성자 호출
//        Supplier<Person> supplier1 = () -> new Person();
        Supplier<Person> supplier1 = Person::new;
        System.out.println(supplier1.get());
        // long 생성자 호출
//        Function<Long, Person> personFunction = (id) -> new Person(id);
        Function<Long,Person> personFunction = Person::new;
        System.out.println(personFunction.apply(1L));
        // String, int 생성자 호출
        BiFunction<String, Integer, Person> personBiFunction = Person::new;
        System.out.println(personBiFunction.apply("홍길동", 33));

        // long, String, int 생성자 호출
//        TriFunction<Long, String, Integer, Person> ...

        // 배열생성
//        Function<Integer, int[]> intArrGenerator = (length) -> new int[length];
        Function<Integer, int[]> intArrGenerator = int[]::new;
        System.out.println(Arrays.toString(intArrGenerator.apply(3)));
    }
}