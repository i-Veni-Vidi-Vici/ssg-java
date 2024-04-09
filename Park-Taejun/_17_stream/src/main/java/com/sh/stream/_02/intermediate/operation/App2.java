package com.sh.stream._02.intermediate.operation;

import java.util.List;
import java.util.stream.Stream;

public class App2 {
    /**
     * <pre>
     *
     * map 중계연산
     * - 주어진 Function 람다식에 따라 요소를 변환
     * - 변환된 결과에 따라서 Stream의 타입이 변경될 수 있다.
     * </pre>
     */
        public static void main(String[] args) {
            List.of(1, 2, 3, 4 ,5).stream()   //stream으로 만든다
                    .map((n) -> n * 10)
                    .map((n) -> String.valueOf(n)) // -> 문자열로 바꾼 것
                    .forEach(System.out::println); //지금은 중개연산이 없는 상태

                Stream.of("홍길동", "신사임당", "이순신", "강감찬")  // name을 어떻게 아
                        .map((name) -> name.charAt(0))
                        .forEach(System.out::println);

                // 데이터의 공백을 제거 후 출력 String#replace

                Stream.of("a b c d", "홍 길동", "Hello World", "너의 이름은 심사임당!!!!")
                        .map((name2) -> name2.replace(" ", ""))
                        .forEach(System.out::println);

                // 숫자가 아닌 데이터 제거
                Stream.of("1,000,000", "$500", "4달러", "500원만 주세요") //여기서 replaceAll 숫자처럼 보이지만 문자열임 String 이어서 형변환 필요
                        .map((str) -> str.replaceAll("[^0-9]", "" )) //정규식으로 표현 0-9까지 지운당! // 숫자 [0-9], 숫자가 아닌 문자[^0-9]
    //                    .map((n) -> Integer.parseInt(n))
                        .mapToInt((n) -> Integer.parseInt(n)) //큰 차이는 없음 intStream으로 변환
                        .map((n) -> (n + 123))
                        .forEach(System.out::println);
        }


    }
