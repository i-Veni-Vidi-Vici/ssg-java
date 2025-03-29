package com.sh.stream._01.creation;

import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <pre>
 * 기본 스트임
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        // IntStream
        IntStream stream1 = IntStream.range(1, 11);
        stream1.forEach(System.out::println);
        IntStream stream2 = IntStream.rangeClosed(1,10); // 1 ~ 10
        stream2.forEach(System.out::println);
        System.out.println();

        // 난수 생성
        IntStream stream3 = new Random().ints(10, 1, 10);
        stream3.forEach(System.out::println);
        System.out.println();

        // 수열 생성
        Stream<Integer> stream4 = Stream.iterate(10, v -> v * 2).limit(10);
        stream4.forEach(System.out::println);
        System.out.println();

        // DoubleStream
        DoubleStream stream5 = new Random().doubles(10);
        stream5.forEach(System.out::println);

        // 문자열 토큰처리
        Pattern regExp = Pattern.compile(", "); // 자바의 정규표현식 객체
        Stream<String> stringStream = regExp.splitAsStream("html,css,javascript");
        stringStream.forEach(System.out::println);

        // Stream 연결 생성
        Stream<String> streamA = Stream.of("java","mysql");
        Stream<String> streamB = Stream.of("html","css","js");
        Stream<String> newStream = Stream.concat(streamA, streamB);
        newStream.forEach(System.out::println);

        //Stream 구구단 출력
        // 1. 8단 출력 : IntStream
        IntStream gugudan = IntStream.iterate(8, v -> v + v).limit(9);
        gugudan.forEach(System.out::println);
        // ex-01
//        IntStream dan8 = IntStream.rangeClosed(1, 9);
//        dan8.forEach(v -> System.out.println(8 + " * " + v + " = " + (8 * v)));

        // 2. 전체 출력 : (2 ~ 9단)
        IntStream gugudan2 = IntStream.rangeClosed(2,9);
        gugudan2.forEach(v ->{
            System.out.println( v + "단");
            IntStream dan = IntStream.rangeClosed(1,9);
            dan.forEach(d -> System.out.println(v + " * " + d + " = " + (v * d)));
        });
    }
}
