package com.sh.stream._01.creation;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * <pre>
 *     스트림 연산
 *     1. 스트림 생성
 *     2. 스트림 중간 연산 (n)
 *     3. 스트림 단말 연산
 *
 * </pre>
 *
 */
public class App2 {
    public static void main(String[] args) {
        //배열을 스트림으로 생성
        String[] names = {"홍길동", "신사임당", "이순신"};
        Stream<String> stream1 = Arrays.stream(names);
        stream1.forEach(s -> System.out.print(s + " "));
        System.out.println();

        Stream<String> stream2 = Arrays.stream(names, 0, 2);
//        stream2.forEach(System.out::println);
        stream2.forEach(s -> System.out.print(s));

        //컬렉션을 스트림으로 생성

    }
}
