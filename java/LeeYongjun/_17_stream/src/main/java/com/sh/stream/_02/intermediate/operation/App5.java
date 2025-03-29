package com.sh.stream._02.intermediate.operation;

import java.util.stream.IntStream;

/**
 * <pre>
 * boxed 중간연산
 * - 기본스트림을 wrapper스트림으로 변환
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        IntStream.of(1,2,3,4,5)
                .boxed()
                .mapToInt(n -> n) // unboxing
                .forEach(System.out::println);
    }
}
