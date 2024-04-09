package com.sh.stream._03.terminal.operation;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * 집계연산 지원
 * - 합 , 평균, 최대값, 최소값을 구할 수 있다.
 */
public class App {
    public static void main(String[] args) {
        int sum = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .sum();
        //Optional : null일 수도 있는 값을 감싼 객체. null처리를 지원하는 메소드 제공하고, 개수가 1개인 stream으로 생각
        OptionalDouble average = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).average();
        System.out.println(average.getAsDouble());

        OptionalInt max = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).max();
        System.out.println(max.getAsInt());

    }
}
