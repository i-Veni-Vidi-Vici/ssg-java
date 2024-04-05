package com.sh.stream._03.terminal.operation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * <pre>
 *     match 단말연산
 *     - anyMatch(Predicate<T>):boolean 하나라도 Predicate 람다식의 결과가 true라면, 최종 true반환
 *     - allMatch(Predicate<T>):boolean 하나라도 predicate 람다식의 결과가 true라면 최종 true반환
 *     - nonMatch(Predicate<T>):boolean 모든 요소의 Predicate람다식의 결과가 false라면, 최종 true반환
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        List<String> stringList = List.of("Java", "Spring", "SpringBoot");
        boolean result = stringList.stream().anyMatch((str) ->str.contains("p"));
        System.out.println(result); //true
        result = stringList.stream().anyMatch((str)->str.contains("p"));
        System.out.println(result); //false

        result = stringList.stream().allMatch((str) ->str.length() >=4);
        System.out.println(result); //true
        result = stringList.stream().allMatch((str)->str.length()>4);
        System.out.println(result); //false

        result = stringList.stream().noneMatch((str)->str.contains("z"));
        System.out.println(result); //true
        result = stringList.stream().noneMatch((str)->str.contains("a"));
        System.out.println(result); //false

        Supplier<Stream<Person>> supplier= () ->
                Arrays.asList(
                        new Person("홍길동", 33),
                        new Person("박철민", 40),
                        new Person("황희정", 27),
                        new Person("박종태", 55),
                        new Person("박종태랑", 33)
                ).stream();
            //50세 이상 이웃이 있는지 검사
        result = supplier.get().anyMatch((Person) -> Person.getAge()>50);   //true
        System.out.println(result);
            //이름 글자수가 3글자보다 많은 이웃이 있는지 검사
        result = supplier.get().anyMatch((Person)-> Person.getName().length()>3);   //true
        System.out.println(result);
            //모든 이웃이 성인인지 검사
        result = supplier.get().allMatch((Person) -> Person.getAge()>19);   //true
        System.out.println(result);
        result = supplier.get().noneMatch((Person) -> Person.getAge()<=19);
        System.out.println(result);




    }
}
