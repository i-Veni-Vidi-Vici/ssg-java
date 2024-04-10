package com.sh.stream._01.creation;

import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <pre>
 * 기본스트림
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        //IntStream
        IntStream stream1=IntStream.range(1,11); //1~10;
        stream1.forEach(System.out::println);

        IntStream stream2=IntStream.rangeClosed(1,10);
        stream2.forEach(System.out::println);

        IntStream stream3=new Random().ints(10,1,10);
        stream3.forEach(System.out::println);

        // Stream 연결
        Stream<String >streamA=Stream.of("java","mysql");
        Stream<String >streamB=Stream.of("html","css","js");
        Stream<String> newStream=Stream.concat(streamA,streamB);

        // 수열 생성
        Stream <Integer> stream4=Stream.iterate(10,v->v*2).limit(10);

        //DoubleStream
        DoubleStream stream5=new Random().doubles(10);//더블범위로 10개 줘
        stream5.forEach(System.out::println);

        // 문자열 토큰처리
        Pattern regExp=Pattern.compile(", ");// 자바의 정규표현식 객체
        //Stream<String> stringStream=regExp.splitAsStream();

        //Stream 구구단 출력
        IntStream intStream=IntStream.range(1,10);
        intStream.forEach(
                (k)-> System.out.printf("%d * %d = %d\n",8,k,k*8)
        );

        //2~9단 구구단
        IntStream.rangeClosed(2,9)
                .forEach((k)-> {
                    IntStream.rangeClosed(2,9)
                                    .forEach((v)-> System.out.println(k+" * "+v+" = "+k*v));
                });
    }
}
