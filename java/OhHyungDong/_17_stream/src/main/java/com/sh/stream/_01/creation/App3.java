package com.sh.stream._01.creation;

import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App3 {

    public static void main(String[] args) {

        //문자열 토큰처리
        Pattern regExp = Pattern.compile(",");//자바의 정규표현식 객체
        Stream<String> stringStream = regExp.splitAsStream("hteml,css,js");
        stringStream.forEach(System.out::println);

        //Stream 연결 / 생성
        Stream<String> streamA = Stream.of("java", "mysql");
        Stream<String> streamB = Stream.of("html","css", "js");
        Stream<String> newStream = Stream.concat(streamA,streamB);
        newStream.forEach(System.out::println);

        //Stream 구구단 출력
        //1. 8단 출력 : IntStream
//        int dan = 8;
//        IntStream.rangeClosed(1,9)
//                .forEach(n -> System.out.println(dan + "*" + n + "=" + n *dan));
        //2. 전체 출력 (2~9단)
        IntStream.rangeClosed(2,9)
                .forEach((d)->{
                    System.out.println();
                    IntStream.rangeClosed(1,9).forEach(n -> System.out.println(d + "*" + n + "=" + d * n));
                });
    }
}
