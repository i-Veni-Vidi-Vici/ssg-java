package com.sh.lambda._04.method.reference;

import com.sh.lambda._02.anonymous.clazz.Func;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.function.*;

/**
 * <pre>
 * 메소드 참조
 *  - 람다식을 더 간결하게 표현하는 문법.
 *  - namespace::method -> 클래스 또는 객체::메소드명      ===> 표현 가능
 *
 *  <사용 가능한 것들>
 *  - static method
 *  - non-static method
 *  - 특정객체의 기준 메소드
 *  - 생성자
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 매개인자가 하나 있고, 리턴값은 없는 람다
//        Consumer<String> consumer = (str) -> System.out.println(str);
        Consumer<String> consumer = System.out::println; // 위의 식을 이렇게 바꿔서 사용할 수 있다.
        consumer.accept("홍길동");

        // "123" -> 123  : 매개변수도 있고 리턴값도 있다.
        // Function<String, Integer> String으로 받고 Integer로 반환한다.
//        Function<String, Integer> function = (str) -> Integer.parseInt(str);
        Function<String, Integer> function = Integer::parseInt;
        System.out.println(function.apply("123"));

        // "abcde" -> 5(글자 수 반환)
//        Function<String, Integer> function2 = (str) -> str.length();
//        ToIntFunction<String> function3 = (str) -> str.length(); 이렇게도 작성할 수 있다.
        Function<String, Integer> function2 = String::length;
        System.out.println(function2.apply("abcde"));

        // 특정 객체 기준 메소드참조
//        BiFunction<String, String, Boolean> biFunction = (str1, str2) -> str1.equals(str2); // 동등비교
        BiFunction<String, String, Boolean> biFunction = String::equals; // 위의 식을 이렇게 바꿔서 사용 가능하다.
        System.out.println(biFunction.apply("Hello", "Hello"));  // true
        System.out.println(biFunction.apply("Hello", "hello"));  // false

        String str = "Hello";
//        Predicate<String> predicate = (txt) -> str.equals(txt); // equals는 str와 txt를 비교하는 식이다
        Predicate<String> predicate = str::equals; // equals는 str와 txt를 비교하는 식이다
        System.out.println(predicate.test("Hello")); // true
        System.out.println(predicate.test("hello")); // false

        // 생성자 참조
        // 기본생성자 호출
//        Supplier<Person> supplier1 = () -> new Person();
        Supplier<Person> supplier1 = Person::new;  // 메소드 참조 가능한 식, 위의 식과 동일
        System.out.println(supplier1.get());
        // long 생성자 호출
//        Function<Long, Person> personFunction = (id) -> new Person(id);
        Function<Long, Person> personFunction = Person::new;
        System.out.println(personFunction.apply(1L));
        // String, int 생성자 호출(String, int) -> Person
//        BiFunction<String, Integer, Person> personBiFunction2 = (name, age) -> new Person(name, age);
        BiFunction<String, Integer, Person> personBiFunction2 = Person::new;
        System.out.println(personBiFunction2.apply("홍길동", 33));

        // long, String, int 생성자 호출 -> 3개를 받는 함수형 인터페이스 작성해보기(과제)
//        TriFunction<Long, String, Integer, Person> ...

        // 배열생성
        // 크기가 ~인 배열을 출력해주세요
//        Function<Integer, int[]> intArrGenerator = (length) -> new int[length];
        Function<Integer, int[]> intArrGenerator = int[]::new; // 위의 식과 동일
        System.out.println(Arrays.toString(intArrGenerator.apply(3)));  // 크기가 3인 int배열 출력



    }
}
