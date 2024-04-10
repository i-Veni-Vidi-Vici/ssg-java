package com.sh.stream._01.creation;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 스트림 연산
 * 1. 스트림 생성(1)
 * 2. 스ㅡ트림 중간 연산(n)- sorted
 * 3. 스트림 단말 연산(1) -forEach
 *
 * 사용한 스트림은 재사용할 수 없다.
 */
public class App2 {
    public static void main(String[] args) {
        // 배열을 스트림으로 생성
        String[] names = {"홍길동", "신사임당", "이순신"};
        Stream<String> stream = Arrays.stream(names);// 컨트롤 알트 v 스트림을 갖는 배열
//        stream.forEach(System.out::print); //for Each문 알아보기
            stream.forEach((s) -> System.out.print(s + ""));
        System.out.println();

            Stream<String> stream1 = Arrays.stream(names, 0, 2); // 0~2 0번지 이상 2 번지 이후
            stream1.forEach(System.out::println);

            //컬렉션을 스트림으로 생성
        Stream<String> stream2 = Arrays.asList("A", "B", "C").stream();
        Stream<Integer> stream3 = Set.of(1, 2, 3).stream();

        // 스트림 직접 생성
        Stream<Double> doubleStream = Stream.of(1.1, 2.2, 3.3);
        doubleStream.forEach(System.out::println);

        Stream<String> stream6 = Stream.<String>builder()
                .add("홍길동")
                .add("이순신")
                .build();

    }
}
