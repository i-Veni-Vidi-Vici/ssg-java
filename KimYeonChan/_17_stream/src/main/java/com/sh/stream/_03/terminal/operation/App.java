package com.sh.stream._03.terminal.operation;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * 집계연산 지원
 * - 합, 평균, 최대값, 최소값을 구할 수 있다.
 */
public class App {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println(sum);
        // Optional: null 일 수 있는 값을 감싼 객체. null 처리 지원메소드 제공. 개수가 1개인 stream 이다.
        OptionalDouble average = IntStream.rangeClosed(1, 10).average();
        System.out.println(average.getAsDouble());

        OptionalInt max = IntStream.rangeClosed(1, 10).max();
        System.out.println(max.getAsInt());

        OptionalInt min = IntStream.rangeClosed(1, 10).min();
        System.out.println(min.getAsInt());
    }
}
