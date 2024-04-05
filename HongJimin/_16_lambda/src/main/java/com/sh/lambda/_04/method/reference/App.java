package com.sh.lambda._04.method.reference;

import java.util.Arrays;
import java.util.function.*;

/**
 * <pre>
 *    **메소드 참조 - 람다식을 더 간결하게 표현하는 문법**
 *      - namespace : : method → 클래스 or 객체 : : 메소드 명
 *
 *      - static method
 *      - non-static method
 *      - 특정 객체의 기준 method
 *      - 생성자
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //매개인자가 하나 있고, 리턴값은 없는 람다
//        Consumer<String> consumer = (str) -> System.out.println(str);
        Consumer<String> consumer = System.out::println; //받아온 것을 그대로 반환할 때 사용, 가공은 불가!
        consumer.accept("홍길동");

        //"123" -> 123
//        Function<String, Integer> function = (str) -> Integer.parseInt(str);
        Function<String, Integer> function = Integer::parseInt; //✨모양확인하기✨
        System.out.println(function.apply("123")); //123

        //"abcde" -> 5
//        Function<String, Integer> function2 = (str) -> str.length();
//        ToIntFunction<String> function3 = (str) -> str.length();

        ToIntFunction<String> function3 = String::length; //✨모양확인하기✨
        System.out.println(function3.applyAsInt("abcde")); //5

        //특정 객체 기준 메소드 참조
//        BiFunction<String, String, Boolean> biFunction = (str1, str2) -> str1.equals(str2);
        BiFunction<String, String, Boolean> biFunction = String::equals;
        System.out.println(biFunction.apply("Hello", "Hello")); //true
        System.out.println(biFunction.apply("Hello", "hello")); //false

        String str = "Hello";
//        Predicate<String> predicate = (txt) -> str.equals(txt);
        Predicate<String> predicate = str::equals;
        System.out.println(predicate.test("Hello"));//true
        System.out.println(predicate.test("hello"));//false

        //생성자 참조
        //기본 생성자 호출
//        Supplier<Person> supplier1 = () -> new Person();
        Supplier<Person> supplier1 = Person::new;
        System.out.println(supplier1.get()); //Person{id=0, name='null', age=0}

        //long 생성자 호출
        Function<Long, Person> personFunction = (id) -> new Person(id);
        System.out.println(personFunction.apply(1L)); //Person{id=1, name='null', age=0}

        //String, int 생성자 호출(String, int) -> Person
        BiFunction<String, Integer, Person> personBiFunction2 = Person::new;
        System.out.println(personBiFunction2.apply("홍길동", 33)); //Person{id=0, name='홍길동', age=33}


        //long, String, int 생성자 호출
        //TriFunction<Long, String, Integer, Person> ...


        //배열 생성
//        Function<Integer, int[]> intArrGenerator = (length) -> new int[length];
        Function<Integer, int[]> intArrGenerator = int[]::new;
        System.out.println(Arrays.toString(intArrGenerator.apply(3))); //[0, 0, 0]
    }
}
