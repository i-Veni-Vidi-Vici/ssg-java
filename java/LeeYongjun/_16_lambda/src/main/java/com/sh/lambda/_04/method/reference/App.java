package com.sh.lambda._04.method.reference;

import java.util.Arrays;
import java.util.function.*;

/**
 * <pre>
 * 메소드 참조
 * - 람다식을 더 간결하게 표현하는 문법.
 * - namespace::method -> 클래스 또는 객체::메소드명
 *
 * - static method
 * - non-static method
 * - 특정객체 기준 메소드
 * - 생성자
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 매개인자가 하나 있고, 리턴값은 없는 람다
//        Consumer<String>consumer = (str) -> System.out.println(str);
        Consumer<String>consumer = System.out::println;
        consumer.accept("홍길동");

        // "123" -> 123
        Function<String, Integer> function = (str) -> Integer.parseInt(str);
        System.out.println(function.apply("123"));

        // "abcde" -> 5
        Function<String,Integer> function2 = (str) -> str.length();
        System.out.println(function2.apply("abcde"));

        ToIntFunction<String> function3 = String::length;
        System.out.println(function3.applyAsInt("abcde"));

        // 특정객체 기준 메소드참조
//        BiFunction<String,String,Boolean> booleanBiFunction = (str1,str2) -> str1.equals(str2);
        BiFunction<String,String,Boolean> booleanBiFunction = String::equals;
        System.out.println(booleanBiFunction.apply("Hello","Hello"));
        System.out.println(booleanBiFunction.apply("Hello","hello"));

        String str = "Hello";
        Predicate<String>predicate = (txt) -> str.equals(txt);
        System.out.println(predicate.test("Hello"));
        System.out.println(predicate.test("hello"));


        // 생성자 참조
        // 기본생성자 호출
//        Supplier<Person> supplier1 = () -> new Person();
        Supplier<Person> supplier1 = Person::new;
        System.out.println(supplier1.get());
        // long 생성자 호출
        Function<Long,Person> personFunction = (id) -> new Person(id);
        System.out.println(personFunction.apply(1L));

        // String , int 생성자 호출
//        BiFunction<String,Integer,Person> biFunction = (name,age) -> new Person(name,age);
        BiFunction<String,Integer,Person> biFunction = Person::new;
        System.out.println(biFunction.apply("이용준",27));

        // long,String,int 생성자 호출
//        TriFunctopm<Long,String,Integer,Person>...

        // 배열생성
//        Function<Integer,int[]> intArrGenerater = (length) -> new int[length];
        Function<Integer,int[]> intArrGenerater = int[]::new;
        System.out.println(Arrays.toString(intArrGenerater.apply(3)));
    }
}
