package com.sh.stream._01.creation;

import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 */
public class App3 {
    public static void main(String[] args) {
        //IntStream
        IntStream stream1 = IntStream.range(1, 11);
                stream1.forEach(System.out::println);
        IntStream stream2 = IntStream.rangeClosed(1, 11);
        stream2.forEach(System.out::println);
        IntStream stream3 = new Random().ints(10,1,10);
        stream3.forEach(System.out::println);
        //수열생성
        Stream<Integer> stream4 = Stream.iterate(10, v -> v * 2).limit(10);
        stream4.forEach(System.out::println);
        //DoubleStream
        DoubleStream doubleStream = new Random().doubles(10);
        doubleStream.forEach(System.out::println);

        //문자열 토큰처리
        Pattern regExp = Pattern.compile(", "); //자바의 정규표현식 객체
        regExp.splitAsStream("html, css ,js");
        //stringStream.forEach

        //Stream 연결 생성
        Stream<String> streamA=Stream.of("java","mysql");
        Stream<String> streamB=Stream.of("html","css","js");
        Stream<String> newStream = Stream.concat(streamA,streamB);
        newStream.forEach(System.out::println);

        //stream 구구단 출력
        //1. 8단출력:intstream
        //2. 전체출력 (2~9단)
        IntStream gugu = IntStream.range(1,10);
        gugu.forEach(i->System.out.printf("8*%d=%d\n",i,8*i));

        IntStream.rangeClosed(2,9).forEach((d)->IntStream.rangeClosed(1,9).forEach((n)-> System.out.printf("%d*%d=%d\n",d,n,d*n)));








    }
}
