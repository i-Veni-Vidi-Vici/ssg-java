package com.sh.stream._02.intermediate.operation;

import java.util.List;
import java.util.stream.Stream;

/**
 * <pre>
 * map 중계 연산
 * - 주어진 Function 람다식에 따라 요소를 변환
 * - 변환된 결과에 따라서 Stream 타입이 변경될 수 있다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        List.of(1, 2, 3, 4, 5).stream()
                .map((n) -> n * 10)
                .map(String::valueOf)
                .forEach(System.out::println);

        Stream.of("홍길동", "신사임당", "강감찬", "이순신")
                .map((name)-> name.charAt(0))
                .forEach(System.out::println);

        // 데이터의 공백을 제거후 출력 String#replace
        Stream.of("a b c d", "홍 길동", "Hello World", "너의 이름은 신사임당")
                .map((n)-> n.replace(" ", ""))
                .forEach(System.out::println);

        // 숫자가 아닌 데이터 제거
        Stream.of("1,000,000", "$500", "4달러", "500원만 주세요")
                .map((str) -> str.replaceAll("[^0-9]", "")) // 숫자 [0-9], 숫자가 아닌 문자 [^0-9]
//                .map(Integer::parseInt)
                .mapToInt(Integer::parseInt)
                .map((n) -> n+123)
                .forEach(System.out::println);

    }
}
