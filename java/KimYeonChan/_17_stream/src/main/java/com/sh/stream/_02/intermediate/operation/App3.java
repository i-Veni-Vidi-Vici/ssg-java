package com.sh.stream._02.intermediate.operation;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * peek 중간연산
 *  - consumer 람다를 통해 요소를 변형하지 않고, 특정처리가 가능
 * 스트림 3단계 처리
 *  - 스트림은 생성-중간-단말 연산의 흐름이 만들어진 이후 요소를 하나씨가 처리한다.
 *  - 단말연산까지의 흐름이 만들어지지 않으면, 스트림은 실행되지 않는다.
 *  1. 스트림 생성
 *  2. 스트림 중간연산 (0~n)
 *  3. 스트림 단말연산 (1)
 */
public class App3 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 20)
                .peek(n -> System.out.println("[peek] " + n))
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        Stream.of("one", "two", "three")
                .peek(str -> System.out.println(1 + " " + str))
                .filter(str -> str.length() > 3)
                .peek(str -> System.out.println(2 + " " + str))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
