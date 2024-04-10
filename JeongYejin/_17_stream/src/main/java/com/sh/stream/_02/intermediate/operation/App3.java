package com.sh.stream._02.intermediate.operation;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <pre>
 * peek 중간연산
 * - Consumer 람다를 통해 요소를 변형하지 않고, 특정처리가 가능
 *
 * 스트림 3단계처리
 * - 스트림은 생성-중간-단말 연산의 흐름이 만들어진 이후 요소를 하나씩 처리한다.
 * - 단말연산까지의 흐름이 만들어지지 않으면 스트림은 실행되지 않는다.
 * 1. 스트림 생성
 * 2. 스트림 중간 연산 (0~n)
 * 3. 스트림 단말연산 (1)
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 20)
                .peek((n) -> System.out.println("[peek] " + n))
                .filter((n) -> n % 2 == 0)
                .forEach(System.out::println);
        // 스트림을 만든 순간부터 단말연산까지 하나의 흐름으로 만들어놓고
        // 메소드를 관통하는 흐름이 만들어지고, 실제 요소가 하나씩 !
        /*
        [peek] 1     // 이 사이에 1은 filter에 걸리지 않았기때문에 그냥 넘어감
        [peek] 2
        2
         */
        Stream.of("one", "two", "three")
                .peek((str) -> System.out.println(1 + " " + str))
                .filter((str) -> str.length() > 3)
                .peek((str) -> System.out.println(2 + " " + str))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        /*
        1 one
        2 two
        3 three
        2 three
        THREE
         */



    }
}