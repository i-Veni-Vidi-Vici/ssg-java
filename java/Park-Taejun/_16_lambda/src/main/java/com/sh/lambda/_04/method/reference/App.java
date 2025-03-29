package com.sh.lambda._04.method.reference;

import java.util.Arrays;
import java.util.function.*;

/**
 * <pre>
 * 메소드 참조
 * - 람다식을 더 간결하게 표현하는 문법.
 * - namespace::method -> 클래스 또는 객체 :: 메소드명
 *
 *

 - static method
 - non - static method
 - 특정객체 기준 메소드
 - 생성자

 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 매개인자가 하나 있고, 리턴값은 없는 람다 // 리턴값이 없다?!
//        Consumer<String> consumer = (str) -> System.out.println(str);
        Consumer<String> consumer = System.out::println;
        consumer.accept("홍길동");

        // Function<String, Integer>
        // "123" -> 123
//        Function<String, Integer> function = (str) -> Integer.parseInt(str);
        Function<String, Integer> function = Integer::parseInt;
        System.out.println(function.apply("123"));

        // "abcde" -> 5
//        Function<String, Integer> function2 = (str) -> str.length();
        ToIntFunction<String> fuction2 = String::length;
        System.out.println(fuction2.applyAsInt("abcde"));

        //특정객체 기준 메소드참조
//        BiFunction<String, String, Boolean>biFunction= (str1, str2) -> str1.equals(str2);
        BiFunction<String, String, Boolean> biFunction= String :: equals; //메소드 참조 짝 잘 기억
        System.out.println(biFunction.apply("Hello", "Hello"));
        System.out.println(biFunction.apply("Hello", "hello"));

        String str = "Hello";
//        Predicate<String> predicate = (txt) -> str.equals(txt);
        Predicate<String> predicate = str::equals; // str와 같니?
        System.out.println(predicate.test("Hello"));
        System.out.println(predicate.test("hello"));

        // 생성자 참조
//        Supplier<Person> supplier1 = () -> new Person();
        Supplier<Person> supplier1 = Person :: new;
        System.out.println(supplier1.get());
        //long 생성자 호출
//        Function<Long, Person> personFunction = (id) -> new Person(id);
        Function<Long, Person> personFunction = Person::new;
        System.out.println(personFunction.apply(1L));

        BiFunction<String, Integer, Person> pesonFunction2 = Person :: new; // string integer가 받는 생성자를 호출
        System.out.println(pesonFunction2.apply("홍길동", 33));

        //lo
        // Stok
        //long,String,int 생성자 호출
//        TriFunction<Long, String, Integer, Person>... //함수형 인터페이스를 먼저 작성해야한다
        // 배열생성
//        Function<Integer, int[]> intArrGenerater = (length) -> new int[length];
        Function<Integer, int[]> intArrGenerater = int[] :: new;
        System.out.println(Arrays.toString(intArrGenerater.apply(3)));
    }
}
