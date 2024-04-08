package com.sh.lambda._04.method.reference;

import java.util.function.*;

/**
 * <pre>
 *     - 람다식을 더 간결하게 표현하는 문법
 *     - namespace::method -> 클래스or객체::메소드명
 *
 *     -static method
 *     -non-static method
 *     - 특정객체 기준 메소드
 *     - 생성자
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //매개인자가 하나 있고, 리턴값은 없는 람다
//        Consumer<String> consumer = (str) -> System.out.println(str);
        Consumer<String> consumer = System.out::println;
        consumer.accept("홍길동");

        Function<String , Integer> function = Integer::parseInt;
        System.out.println(function.apply("1234"));

        //"abcde" ->5
        Function<String , Integer> function2 = String::length;
        System.out.println(function2.apply("abcde"));

        //특정객체 기준 메소드 참조
        BiFunction<String, String, Boolean> biFunction = (str1, str2) -> str1.equals(str2);
        BiFunction<String, String, Boolean> biFunction2 = String::equals;

        System.out.println("두 문자열 비교 : "+biFunction.apply("123","123"));
        System.out.println("두 문자열 비교 : " + biFunction2.apply("hi", "hi"));

        String str = "Hello";
//        Predicate<String> predicate = (txt)->str.equals(txt);
        Predicate<String> predicate = str::equals;
        System.out.println(predicate.test("Hello"));
        System.out.println(predicate.test("hello"));

        //생성자 참조
//        Supplier<Person> supplier1 = () -> new Person();
        //생성자 호출
        Supplier<Person> supplier1 = Person::new;
        System.out.println(supplier1.get());

        //long 생성자 호출
        Function<Long, Person> personFunction = (id) -> new Person(id);
        System.out.println(personFunction.apply(1L));
        //long , String, int 생성자 호출


        Function<Long, Person> personFunction2 = Person::new;
        System.out.println(personFunction2.apply(1L));
        //String, int 생성자 호출
        BiFunction<String, Integer, Person>personFunction3 = Person::new;
        System.out.println(personFunction3.apply("홍길동",33));

        //Long String Integer
//        TriFunction<Long, String, Integer, Person> personFunction4 = Person::new;
//        System.out.println(personFunction4.);

        //배열생성
        Function<Integer, int[]>


    }
}
