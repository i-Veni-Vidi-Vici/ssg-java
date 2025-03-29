package com.sh.stream._02.intermediate.operation;

import java.util.List;
import java.util.stream.IntStream;

/**
 * <pre>
 * filter 중계연산(중간연산)
 * - Predicate 람다식의 반환값이 true인 요소만 남긴다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        IntStream stream = IntStream.rangeClosed(1,10);
        stream
                .filter((n) -> n%2 == 0) // n의 조건이 true인경우만 출력
                .forEach(System.out::println);

        IntStream.of(1,3,5,6,3,5,4,2,5,1)
                .distinct() // 중복된 요소 제거
                .forEach(System.out::println);

        // 이름이 "동"자로 끝나면서 "홍"씨인 이름만 출력
        List<String> names= List.of("홍길동","고길동","신사임당","마동석");
        names.stream()
                .filter((name) -> name.endsWith("동"))
                .filter((name)-> name.startsWith("홍"))
                .forEach(System.out::println);
    }

}
