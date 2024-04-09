package com.sh._04.method.reference;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * <pre>
 * 메서드 참조
 * - 람다식을 더 간결하게 표현하는 문법.
 * - namespace::method -> 클래스 또는 객체::메소드명
 *
 * - static method
 * - non-static method
 * - 특정객체 기준 메서드
 * - 생성자
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 매개인자 하나 있고, 리턴값은 없는 람다
//        Consumer<String> consumer = (str) -> System.out.println(str);
        Consumer<String> consumer = System.out::println;
        consumer.accept("홍길동");

        // "123" -> 123
//        Function<String, Integer> function = (str) -> Integer.parseInt(str);
        Function<String, Integer> function = Integer::parseInt;
        System.out.println(function.apply("123"));

        // "abcde" -> 5
//        Function<String, Integer> function1 = (str) -> str.length();
        Function<String, Integer> function1 = String::length;
        System.out.println(function1.apply("abcde"));

        // 특정 객체 기준 메서드참조
//        BiFunction<String, String, Boolean> biFunction = (str1, str2) -> str1.equals(str2);
        BiFunction<String, String, Boolean> biFunction = String::equals;
        System.out.println(biFunction.apply("Hello", "Hello")); // true
        System.out.println(biFunction.apply("Hello", "hello")); // false

        String str = "Hello";
//        Predicate<String> predicate = (txt) -> str.equals(txt);
        Predicate<String> predicate = str::equals;
        System.out.println(predicate.test("Hello")); // true
        System.out.println(predicate.test("hello")); // false

        // 생성자 참조
        // 기본 생성자 호출
//        Supplier<Person> supplier1 = () -> new Person();
        Supplier<Person> supplier1 = Person::new;
        System.out.println(supplier1.get());

        // long 생성자 호출
//        Function<Long, Person> personFunction = (id) -> new Person(id);
        Function<Long, Person> personFunction = Person::new;
        System.out.println(personFunction.apply(1L));

        // String, int 생성자 호출
        BiFunction<String, Integer, Person> function2 = Person::new;
        System.out.println(function2.apply("홍길동", 12));

        // long, String, int 생성자 호출
        // TriFunction<Long, String, Integer, Person>

        // 배열 생성
//        Function<Integer, int[]> intArrGenerator = (length) -> new int[length];
        Function<Integer, int[]> intArrGenerator = int[]::new;
        System.out.println(Arrays.toString(intArrGenerator.apply(3)));

    }
}
