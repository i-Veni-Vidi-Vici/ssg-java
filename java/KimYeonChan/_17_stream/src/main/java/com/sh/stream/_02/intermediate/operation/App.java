package com.sh.stream._02.intermediate.operation;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * filter 중간연산
 *  - predicate 람다식이 true 인 요소만 남긴다.
 */
public class App {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10)
            .filter(n -> n % 2 == 0)
            .forEach(System.out::println);

        IntStream.of(1, 3, 4, 5, 9, 6, 5, 5, 6, 1, 5)
            .distinct()
            .forEach(System.out::println);

        List<String> names = List.of("홍길동", "고길동", "신사임당", "마동석");
        names.stream()
            .filter(n -> String.valueOf(n.charAt(n.length() - 1)).equals("동"))
            .forEach(System.out::println);
    }
}
