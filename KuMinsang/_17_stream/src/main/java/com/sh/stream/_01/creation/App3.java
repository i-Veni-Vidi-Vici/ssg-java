package com.sh.stream._01.creation;

import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App3 {
    public static void main(String[] args) {

        //문자열 토큰 처리
        Pattern regExp = Pattern.compile(", ");
        Stream<String> stringStream = regExp.splitAsStream("html, css , js");
        stringStream.forEach(System.out::println);

        Stream<String> streamA = Stream.of("java", "mysql");
        Stream<String> streamB = Stream.of("html", "css", "js");
        Stream<String> streamC = Stream.concat(streamA, streamB);
        streamC.forEach(System.out::println);

        //Stream 구구단 출력
        //1 8단 출력: InputStream
        //2. 전체 출력 (2~9단)
//        Stream<Integer> gugu = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        gugu.forEach();
        int dan = 8;
        IntStream.rangeClosed(1,9).forEach( (n)-> System.out.println(dan + " * "+dan *n));

        IntStream.rangeClosed(2, 9)
                .forEach((d)-> System.out.println(d));

        IntStream.rangeClosed(2, 9)
                .forEach((d) -> {
                    IntStream.rangeClosed(1, 9)
                            .forEach((n)-> System.out.println(d + " * " + n + " = " + (d *n)));
                });

    }
}
