package com.sh.stream._03.terminal.operation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * <pre>
 * match 단말연산
 * - anyMatch(Predicate<T>):boolean 하나라도 Predicate람다식의 결과가 true라면 , 최종 true반환
 * - allMatch(Predicate<T>):boolean 모든 요소의 Predicate람다식의 결과가  true라면 최종 true반환
 * - noneMath(Predicate<T>):boolean 모든 요소의 Predicate람다식의 결과가 false라면, 최좆 true반환
 * </pre>
 *
 *
 */


public class App4 {
    public static void main(String[] args) {
        List<String> stringList = List.of("Java","Spring","Springboot");
        boolean result = stringList.stream().anyMatch((str) -> str.contains("p"));
        System.out.println(result); // true
        result = stringList.stream().anyMatch((str) -> str.contains("z"));
        System.out.println(result); // false

        result = stringList.stream().allMatch((str) -> str.length() >= 4);
        System.out.println(result); // true
        result = stringList.stream().allMatch((str) -> str.length() > 4);
        System.out.println(result); // false

        result = stringList.stream().noneMatch((str) -> str.contains("z"));
        System.out.println(result); // true

        result = stringList.stream().noneMatch((str) -> str.contains("a"));
        System.out.println(result); // false

        // Stream<Person>을 제공하는 공급자 람다

        Supplier<Stream<Person>> supplier = () ->
                Arrays.asList(
                        new Person("홍길동" ,33),
                        new Person("신사임당" ,40),
                        new Person("이순신" ,27),
                        new Person("장영실" ,55),
                        new Person("홍길동" ,33)
                ).stream();

        // 50세 이상 이웃이 있는 지 검사 ( 한명이라도 있는지 !!)

        System.out.println(supplier.get().anyMatch(person -> person.getAge() >= 50));
        // 이름글자수가 3글자보다 많은 이웃이 있는지 검사 ( 한명이라도 있는지!!)
        System.out.println(supplier.get().anyMatch(person -> person.getName().length() >= 3));

        // 모든 이웃이 성인인지 검사
        System.out.println(supplier.get().allMatch(person -> person.getAge() > 20));
        System.out.println(supplier.get().noneMatch(person -> person.getAge() < 20)); // 모두 20살이 안넘긴다. true.
        // 가능은 하지만 부정표현은 하지 않는게 좋다.


    }
}
