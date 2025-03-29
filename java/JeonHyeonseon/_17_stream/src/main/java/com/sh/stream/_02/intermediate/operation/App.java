package com.sh.stream._02.intermediate.operation;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <pre>
 * filter 중계연산(중간연산)
 *  - Predicate 람다식의 반환값이 true인 요소만 남긴다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10)
                .filter((n) -> n % 2 == 0) // 조건식이 참인 요소들만 남겨줘 라는 의미의 식
                .forEach(System.out::println);

        IntStream.of(1, 2, 3, 4, 5, 5, 4, 1, 8)
                .distinct()  // 중복된 요소 제거해준다.
                .forEach(System.out::println);

        // 이름이 동자로 끝나는 이름만 출력
        // Stream -> filter -> forEach
        List<String> names1 = List.of("홍길동", "고길동", "신사임당", "마동석");
        names1.stream() // list를 stream으로 바꾸는 식   배열인 경우 Arrays.Stream
                .filter((name) -> name.endsWith("동"))
                .forEach(System.out::println);
        System.out.println();

        // 이름만 "동"자로 끝나면서 "홍"씨인 이름만 출력
        List<String> names2 = List.of("홍길동", "고길동", "신사임당", "마동석");
        names2.stream() // list를 stream으로 바꾸는 식   배열인 경우 Arrays.Stream
                .filter((name) -> name.endsWith("동"))
                .filter((name) -> name.startsWith("홍"))
                .forEach(System.out::println);
    }
}