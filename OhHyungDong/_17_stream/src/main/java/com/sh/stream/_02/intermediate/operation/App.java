package com.sh.stream._02.intermediate.operation;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * filter : 중계연산
 * - predicate 람다식의 반환값이 true인 요소만 남긴다
 */
public class App {
    public static void main(String[] args) {
        IntStream stream=IntStream.range(1, 10);
        stream.filter( n -> n%2==0).forEach(System.out::println);

        IntStream.of(1,3,5,6,3,5,4,2,5,1)
                .distinct().forEach(System.out::println);

        List<String> names = List.of("홍길동", "고길동", "신사임당","마동석");
        Stream<String> str = names.stream();
                str.sorted()
                .filter(name -> name.endsWith("동"))
                .filter(name -> name.startsWith("홍")).forEach(System.out::println);

    }
}
