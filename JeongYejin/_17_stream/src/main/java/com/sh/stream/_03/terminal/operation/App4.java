package com.sh.stream._03.terminal.operation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <pre>
 * match 단말연산
 * - anyMatch(Predicate<T>):boolean Predicate 하나라도 람다식의 결과가 true라면, 최종 true 반환
 * - allMatch(Predicate<T>):boolean 모든 요소의 Predicate 람다식의 결과가 true라면, 최종 true 반환
 * - noneMatch(Predicate<T>):boolean 모든 요소의 Predicate 람다식의 결과가 false라면, 최종 true 반환
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        List<String> stringList = List.of("Java", "Spring", "Springboot");
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
                    new Person("홍길동", 33),
                    new Person("신사임당", 40),
                    new Person("이순신", 27),
                    new Person("장영실", 55),
                    new Person("홍길동", 33)
            ).stream();

        supplier.get().forEach(System.out::println);

        // 50세 이상 이웃이 있는지 검사
        result = supplier.get().anyMatch((o) -> o.getAge() > 50);
        System.out.println(result);
        // 이름이 3글자보다 많은 이웃이 있는지 검사
        result = supplier.get().anyMatch((o) -> o.getName().length() > 3);
        System.out.println(result);
        // 모든 이웃이 성인인지 검사
        result = supplier.get().allMatch((o) -> o.getAge() > 18);
        System.out.println(result);
        result = supplier.get().noneMatch((o) -> o.getAge() < 19);
        System.out.println(result);

        // 동명이인이 있는지 검사
        // 20대가 있는지 검사
    }
}