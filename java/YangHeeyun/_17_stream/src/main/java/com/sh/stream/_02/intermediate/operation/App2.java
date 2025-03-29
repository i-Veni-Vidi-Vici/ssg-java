package com.sh.stream._02.intermediate.operation;

import java.util.List;
import java.util.stream.Stream;

/**
 * <pre>
 * map 중계연산
 * - 주어진 Function 람다식에 따라 요소를 변환
 * - 변환된 결과에 따라서 Stream 타입이 변경될 수 있다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        List.of(1,2,3,4,5).stream()
                .map((n) -> String.valueOf(n))
                .forEach(System.out::println);

        Stream.of("홍길동", "신사임당", "이순신", "강감찬")
                .map((name) -> name.charAt(0))
                .forEach(System.out::println);

        // 데이터의 공백을 제거 후 출력 String#replace 사용
        Stream.of("a b c d", "홍 길동", "Hello World", "너의 이름은 신사임당!!!     ")
                .map((str) -> str.replace(" ", ""))
                .forEach(System.out::println);

        // 숫자가 아닌 데이터 제거 String#replaceAll 사용(정규식 사용은 repaceAll)
        Stream.of("1,000,000","$500","4달러","500원만 주세요")
                // 숫자를 의미하는 정규식 [0-9] , 숫자가 아닌 문자 [^0-9]
                .map((str) -> str.replaceAll("[^0-9]",""))
//                .map((n) -> Integer.parseInt(n))
                .mapToInt((n) -> Integer.parseInt(n))
                .map((n) -> n + 123) //integer로 바꿔서 산술연산이 가능해짐
                .forEach(System.out::println);
    }
}
