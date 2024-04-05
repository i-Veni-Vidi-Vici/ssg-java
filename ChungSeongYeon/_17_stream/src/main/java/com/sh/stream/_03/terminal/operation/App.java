package com.sh.stream._03.terminal.operation;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * <pre>
 * 집계연산 지원
 * - 합, 평균, 최대/최소값 구할 수 있다.
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        int sum = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).sum();
        System.out.println(sum);
        // Optional : null일 수 있는 값을 감싼 객체. null 처리 지원메소드 제공. 개수가 1개인 Stream이라고 생각하면 좋다.
        OptionalDouble average = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).average(); // 평균값을 감싼 Optional 객체
        System.out.println(average.getAsDouble()); // 5.5

        OptionalInt max = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).max();
        System.out.println(max.getAsInt());

        OptionalInt min = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).min();
        System.out.println(min.getAsInt());


    }
}
