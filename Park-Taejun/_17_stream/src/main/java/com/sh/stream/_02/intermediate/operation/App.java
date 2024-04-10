package com.sh.stream._02.intermediate.operation;

import java.util.List;
import java.util.stream.IntStream;

/**
 * <pre>
 * filter 중계연산
 * - Predicate 람다식의 반환값이 true인 요소만 남긴다.
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        IntStream stream = IntStream.rangeClosed(1, 10);
//        stream
          IntStream.rangeClosed(1, 10)  // 위에 말고 이렇게 쓰는 것이 일반적임
                // 요소가 하나면 인트고, 어떤 요소로 넘겨줄 지 조건 정하는것
                .filter((n) -> n % 2 == 0) //이렇게 만들면 짝수만
                .forEach(System.out::println);  //중간에 짝수만 남기고 싶다면???? 어차피 스트림은 일회용이므로 변수에 담을필요 없음

        IntStream.of(1,3,5,6,3,5,4,2,5,1)
                .distinct() // 중복된요소 제거해주는
                .forEach(System.out::println);
        // 이름이 동자로 끝나면서 "홍"씨인 이름만 출력 이름만 출력
        List<String>names = List.of("홍길동", "고길동", "신사임당", "마동석");
                // Stream - filter - forEach List는 스트림이 아니기 때문에 먼저 스트림으로 만들어 준 뒤 필터
                names.stream()
                        .filter((name) -> name.endsWith("동"))
                        .filter((name) -> name.startsWith("홍")) //몇개든 .filter 사용가능하다.
                        .forEach(System.out::println);     // 홍길동,고길동                                            //만약 Arrays면 Arrays.stream



    }
}
