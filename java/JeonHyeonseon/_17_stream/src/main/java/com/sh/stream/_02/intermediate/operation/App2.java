package com.sh.stream._02.intermediate.operation;

import java.util.List;
import java.util.stream.Stream;

/**
 * <pre>
 * map 중계연산
 *  - 주어진 Function람다식에 따라 요소를 변환한다.
 *  - 변환된 결과에 따라서 Stream타입이 변경될 수 있다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        List.of(1, 2, 3, 4, 5).stream()
                .map((n) -> n * 10) // n의 요소를 n * 10으로 바꿔주세요 라는 의미
                .map((n) -> String.valueOf(n)) // 문자열 바꿈, 변환된 결과에 따라서 Stream타입이 변경될 수 있다.
                .forEach(System.out::println);

        Stream.of("홍길동", "신사임당", "이순신", "강감찬")
                .map((name) -> name.charAt(0)) // 성만 출력하기를 원함 -> 변환필요 -> map사용 -> charAt(0)을 사용
                .forEach(System.out::println);

        // 데이터의 공백을 제거후 출력 => String#replace
        Stream.of("a b c d", "홍 길동", "Hello World", "너의 이름은 신사임당!!! ")
                .map((str) -> str.replace(" ", ""))
                .forEach(System.out::println);

        // 숫자가 아닌 데이터 제거
        Stream.of("1,000,000", "$500", "4달러", "500원만 주세요")
                // 숫자[0-9], 숫자가 아닌 문자[^0-9] => 문자열인 상태
                // 숫자는 다 제거해달라는 정규식 표현 .replaceAll("[0-9]", "" )
                .map((str) -> str.replaceAll("[^0-9]", ""))
//                .map((n) -> Integer.parseInt(n)) // 문자열을 숫자로 변환
                .mapToInt((n) -> Integer.parseInt(n))
                .map((n) -> n + 123)
                .forEach(System.out::println);
    }
}
