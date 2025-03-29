package com.sh.stream._03.terminal.operation;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;

/**
 * <pre>
 * 집계연산 지원
 * - 합, 평균, 최대값, 최소값을 구할 수 있다
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        int sum=IntStream.of(1,2,3,4,5,6,7,8,9,10)
                .sum();
        System.out.println(sum);


        // Optional : null일 수 있는 값을 감싼 객체, null처리 지원메소드 제공, 개수가 1개인 Stream처럼 생각
        OptionalDouble average=IntStream.of(1,6,87,9,6,51,1,4,6,5,1,98,9).average();
        System.out.println("average : "+average.getAsDouble());//=평균을 감싼 Optional이다

        OptionalInt max=IntStream.of(1,4,10,6,3,4,5,6,15).max();
        System.out.println("max : "+max.getAsInt());// = 최댁값을 감싼 Optional이다

        OptionalInt min=IntStream.of(1,4,10,6,3,4,5,6,15).min();
        System.out.println("min : "+min.getAsInt());

        long count=IntStream.of(1,4,10,6,3,4,5,6,15).count();
        System.out.println("count : "+count);
    }
}
