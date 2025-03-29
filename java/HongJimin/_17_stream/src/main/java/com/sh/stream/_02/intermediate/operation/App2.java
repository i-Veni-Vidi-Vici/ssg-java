package com.sh.stream._02.intermediate.operation;

import java.util.List;
import java.util.stream.Stream;

/**
 * <pre>
 *     ### map 중계 연산
 *      - 주어진 Function 람다식에 따라 요소를 변환
 *      - 변환된 결과에 따라서 Stream의 타입이 변경될 수 있음
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        List.of(1, 2, 3, 4, 5).stream()
                .map((n)->n * 10)
                .map((n) -> String.valueOf(n)) //문자열이 됨
                .forEach(System.out::println);

        Stream.of("홍길동", "신사임당", "이순신", "강감찬")
                .map((name) -> name.charAt(0))
                .forEach(System.out::println);

        // 데이터의 공백을 제거후 출력
        Stream.of("a b c d e", "홍 길동", "Hello world", "너의 이름은 신사임당!!!    ")
                .map((m) -> m.replace(" ", ""))
                .forEach(System.out::println);

        // 숫자가 아닌 데이터 제거
        //[0-9] -> 숫자를 찾는 정규식, 숫자가 아닌 문자를 찾는 정규식 -> [^0-9]
        Stream.of("1,000,000", "$500", "4달러", "500원만 주세요")
                .map((str) -> str.replaceAll("[^0-9]", ""))
//                .map((n) -> Integer.parseInt(n)) //String을 int로 바꿔주는 연산
                .mapToInt((n) -> Integer.parseInt(n))
                .map(n -> n +123)
                .forEach(System.out::println);
    }
}
