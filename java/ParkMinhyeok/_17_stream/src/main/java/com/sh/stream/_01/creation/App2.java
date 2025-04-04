package com.sh.stream._01.creation;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

/**
 * <pre>
 * 1. 스트림 생성(1)
 * 2. 스트림 중간 연산(n)
 * 3. 스트림 단말 연산(1)
 * 사용한 스트림 재사용할 수 없다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // 배열 스트림으로 생성
        String[] names = {"홍길동", "신사임당", "이순신"};
        Stream<String> stream1 = Arrays.stream(names);
//        stream1.forEach(System.out::println);
        stream1.forEach((s) -> System.out.println(s + " "));

        Stream<String> stream2 = Arrays.stream(names, 0, 2);
        stream2.forEach(System.out::println);

        Stream<String> stream3 = Arrays.asList("A", "B", "C").stream();
        Stream<Integer> stream4 = Set.of(1, 2, 3).stream();

        // 스트림 직접 생성
        Stream<Double> doubleStream = Stream.of(1.1, 2.2, 3.3);
        doubleStream.forEach(System.out::println);

        Stream<String> stream6 = Stream.<String>builder()
                .add("홍길동")
                .add("이순신")
                .build();
    }
}
