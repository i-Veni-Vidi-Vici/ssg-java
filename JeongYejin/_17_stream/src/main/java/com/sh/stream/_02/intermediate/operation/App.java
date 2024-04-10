package com.sh.stream._02.intermediate.operation;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <pre>
 * filter 중계연산
 * - Predicate 람다식의 반환값이 true인 요소만 남긴다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        DoubleStream.of(7.2, 7.9, 0.0, 5.5).sorted().forEach(System.out::println);
        IntStream.rangeClosed(1, 10)
                .filter((n) -> n % 2 == 0); // 조건식에 따라 true인 값만 가지고 있는 함수
//                .forEach(System.out::println);

        IntStream.of(1, 3, 5, 6, 3, 5, 4, 2, 5, 1)
                .distinct() // 중복된 요소를 제거해주는 함수
                .limit(5) // 앞에서부터 개수제한
                .forEach(System.out::println);

        // 이름이 동자로 끝나는 이름만 출력
        List<String> names = List.of("홍길동", "고길동", "신사임당", "마동석", "홍광호");
        names.stream()
//                .sorted()
                .filter((n) -> n.endsWith("동"))
                .forEach(System.out::println);

        // 이름이 "동자로 끝나면서 "홍"씨인 이름만 출력
        names.stream()
                .filter((n) -> n.startsWith("홍"))
                .filter((n) -> n.endsWith("동"))
                .forEach(System.out::println);


    }
}
