package com.sh.stream._03.terminal.operation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * match 단말 연산
 * - anyMatch(Predicate<T>) : boolean 반환 -> 하나라도 Predicate람다식의 결과가 true라면 최종 true 반환
 * - allMatch(Predicate<T>) : boolean 반환 -> 모든 요소의 람다식의 결과가 true라면 최종 true 반환
 * - noneMatch(Predicate<T>) : boolean 반환  -> 모든 요소의 람다식의 결과가 false라면 최종 true 반환
 */
public class App4 {
    public static void main(String[] args) {
        List<String> stringList = List.of("java", "Spring", "Springboot");
        boolean result = stringList.stream().anyMatch(str -> str.contains("p"));
        System.out.println(result);
        result =stringList.stream().anyMatch(str -> str.contains("z"));
        System.out.println(result);

        result =stringList.stream().allMatch(str -> str.length() >=4);
        System.out.println(result);
        result =stringList.stream().allMatch(str -> str.length() >4);
        System.out.println(result);

        result =stringList.stream().noneMatch(str -> str.contains("z"));
        System.out.println(result);

        //Supplier은 Stream<Person>을 제공하는 공급자 람다, supplier은 매개변수는 없고, 리턴값만 있음.
        Supplier<Stream<Person>> supplier =  ()->
            Arrays.asList(
                    new Person("홍길동", 33),
                    new Person("신사임당", 40),
                    new Person("이순신", 27),
                    new Person("장영실", 55),
                    new Person("홍길동", 55))
        .stream();

        //50세 이상이 있는지 검사
        boolean b = supplier.get().anyMatch(person -> person.getAge() >= 50);
        System.out.println(b);

        //이름의 글자수가 3글자보다 많은 이웃이 있는지 검사
        boolean b1 = supplier.get().map(Person::getName).anyMatch(str -> str.length() >= 3);
        System.out.println(b);

        //모든 이웃이 성인인지 검사 ->
        boolean b2 = supplier.get().allMatch(person -> person.getAge() >= 20);
        System.out.println(b2);
    }
}
