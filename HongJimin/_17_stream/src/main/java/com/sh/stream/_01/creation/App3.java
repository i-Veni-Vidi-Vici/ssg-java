package com.sh.stream._01.creation;

import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 기본 스트림
 */
public class App3 {
    public static void main(String[] args) {
        //IntStream
        IntStream stream1 = IntStream.range(1, 11);
        stream1.forEach(System.out::println);//1 ~ 10이 세로로 출력됨

        IntStream stream2 = IntStream.rangeClosed(1, 10);
        stream2.forEach(System.out::println); //12345678910

        //난수 생성
        IntStream stream3 = new Random().ints(10, 1, 10);
        stream3.forEach(System.out::println); //0 ~ 1사이의 랜덤 정수 10개가 출력됨
        System.out.println();

        //수열 생성
        Stream<Integer> stream4 = Stream.iterate(10, v -> v * 2).limit(10);
        stream4.forEach(System.out::println); //10 20 40 80 160 320 640 1280 2560 5120 세로로 출력

        //DoubleStream
        DoubleStream doubleStream = new Random().doubles(10);
        doubleStream.forEach(System.out::println);

        //문자열 토큰 처리
        Pattern refExp = Pattern.compile(", ");//자바의 정규표현식 객체
        Stream<String> stringStream = refExp.splitAsStream("html, css, js");
        stringStream.forEach(System.out::println); //html css js가 세로로 출력!

        //Stream 연결 생성
        Stream<String> streamA = Stream.of("java", "mysql");
        Stream<String> streamB = Stream.of("html", "css", "js");
        Stream<String> newStream = Stream.concat(streamA, streamB);
        newStream.forEach(System.out::println);

        //Stream 구구단 출력
        //1. 8단 출력 : IntStream
//        IntStream.rangeClosed(1, 9).forEach(System.out::println); //1 ~ 9 출력
        int dan = 8;
        IntStream.rangeClosed(1, 9).forEach((n) -> System.out.println(dan + " * " + n + " = " + dan * n)); //1 ~ 9 출력

        //2. 전체 출력(2 ~9단)
        IntStream.rangeClosed(2, 9)
                .forEach((daan) -> {
                    System.out.println();
                    IntStream.rangeClosed(1, 9)
                            .forEach((n) -> System.out.println(daan + " * " + n + " = " + (daan * n)));
                });
    }
}
