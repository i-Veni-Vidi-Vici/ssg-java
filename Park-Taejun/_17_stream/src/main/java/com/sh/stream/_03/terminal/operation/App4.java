package com.sh.stream._03.terminal.operation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * <pre>
 * match 단말연산
 * - anyMatch(Predicate<T>):boolean 각요소별로 predicate돌려서 하나라도 predicate 람다식의 결과가 true라면, 최종 true를 반환한다.
 * - allMatch(Predicate<T>):boolean 모든 요소의  predicate 람다식의 결과가 true라면, 최종 true를 반환한다.
 * - noneMatch(Predicate<T>):boolean predicate 람다식의 결과가 false라면, 최종 true를 반환한다. 만족하는게 없어야 한다....!
 * </pre>
 */
public class App4 {
    public static void main(String[] args) { //하나라도 트루
        List<String> stringList = List.of("Java", "Spring", "Springboot");

        boolean result = stringList.stream().anyMatch((str) -> str.contains("p"));
        System.out.println(result); //true
        result = stringList.stream().anyMatch((str) -> str.contains("z"));
        System.out.println(result); //false
        result = stringList.stream().allMatch((str) -> str.length() >=4);
        System.out.println(result);
        result = stringList.stream().allMatch((str) -> str.length() > 4);
        System.out.println(result);
        result = stringList.stream().noneMatch((str) -> str.contains("z"));
        System.out.println(result);
        result = stringList.stream().noneMatch((str) -> str.contains("a"));
        System.out.println(result);

        // Stream<Person> 을 제공하는 공급자 람다
        Supplier<Stream<Person>> supplier = () ->
        Arrays.asList(
                new Person("홍길동", 33),
                new Person("신사임당", 40),
                new Person("이순신", 27),
                new Person("장열실", 55),
                new Person("홍길동", 33)
        ).stream();
        supplier.get().forEach(System.out::println);

        //50세 이상 이웃이 있는지 검사
        System.out.println(supplier.get().anyMatch((person -> person.getAge() >=50)));
        //이름 글자 수가 3글자보다 많은 이웃이 있는지 검사
        System.out.println(supplier.get().anyMatch((person -> person.getName().length() > 3 )));
        // 모든 이웃이 성인인지 검사
        System.out.println(supplier.get().allMatch((person -> person.getAge() >= 20)));
        System.out.println(supplier.get().noneMatch((person -> person.getAge() < 20))); // 부정표현 사용하기 조심스러워욤!!
    }
}
