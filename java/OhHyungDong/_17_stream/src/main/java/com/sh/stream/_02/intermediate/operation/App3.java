package com.sh.stream._02.intermediate.operation;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * peek 중간연산
 * - Consumer람다를 통해서 요소를 변형하지 않고, 특정처리가 가능하다.
 *
 * 스트림 3단계
 * - 스트림은 생성 - 중간 - 단말 -연산의 흐름이 만들어진 이후 요소를 하나씩 처리한다.
 * - 단말연산까지의 흐름이 만들어지지 않으면 스트림은 실행되지 않는다.
 * 1. 스트림 생성
 * 2. 스트림 중간연산(0~n)
 * 3. 스트림 단말연산 1
 *
 */
public class App3 {
    public static void main(String[] args) {
        //stream -> 데이터의 흐름 , 데이터가 먼저 다 흐르고 난 뒤에 연산이 실행됨.
        IntStream.rangeClosed(1, 20)
                .peek(n -> System.out.println("[peek] " + n))
                .filter(n -> n%2==0)
                .forEach(System.out::println); //forEach문이 만들어지지 않으면 , Stream은 실행되지 않는다.

        Stream.of("one", "two", "three")
                .peek(str -> System.out.println(1 + " " + str))
                .filter(str -> str.length() > 3)
                .peek(str -> System.out.println(2 + " " + str))
                .map(String::toUpperCase)
                .forEach(System.out::println);
        /*
         1 one , 1 two , 1 three , 2 three THREE
         */
    }
}
