package com.sh.stream._02.intermediate.operation;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <pre>
 *     ### filter 중계 연산
 *      - Predicate 람다식의 반환값이 true인 요소만 남긴다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10)
                .filter((n) -> n % 2 ==0) //✨짝수인 것만 출력되게 하는 조건문
                .forEach(System.out::println);

        IntStream.of(1, 3, 5, 6, 3, 5, 4, 2, 5, 1)
                .distinct()  //✨중복된 것을 제외하면서 출력해줌
                .forEach(System.out::println);

        // 이름이 동자로 끝나는 이름만 출력
        List<String> names = List.of("홍길동", "고길동", "신사임당", "마동석");

        //Stream - filter - forEach
         names.stream()
                 .filter((name) -> name.endsWith("동")) //✨동자로 끝나는 이름만 출력 하도록 함
                 .forEach(System.out::println);

         //이름이 동자로 끝나면서 "홍"씨인 이름만 출력
        names.stream()
                .filter((name) -> name.endsWith("동")) //✨동자로 끝나는 이름만 출력 하도록 함
                .filter((name) -> name.startsWith("홍")) //✨홍으로 시작하는 이름만 출력
                .forEach(System.out::println);
    }
}
