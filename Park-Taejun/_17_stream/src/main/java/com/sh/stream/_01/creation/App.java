package com.sh.stream._01.creation;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <pre>
 * Stream 이란?
 * -jdk8에 추가되어 배열/컬렉션을 일관되게 제어하는 기술
 * -람다식을 인자로 해서 간결하게 반복처리
 * - 병렬처리(동시처리)도 쉽게 가능.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 2, 4, 5); //리스트를 스트림으로 만들기
        Stream<Integer> stream1 = list.stream();
        stream1.sorted().forEach((n) -> System.out.println(n)); //sorted로 바꾸고 for each로 출력
        System.out.println(list); // 복사본을 만드는 것임 list 자체를 출력하면 그대로 나옴 스트림이 복사함

        int[] arr = {3, 2, 4, 1, 5}; // 얘도 있는 배열을 스트림으로 만들기
        IntStream stream2 = Arrays.stream(arr);
        stream2.sorted()
                .forEach((n) -> System.out.println(n));
        System.out.println(Arrays.toString(arr));

        Set<Integer> set = Set.of(3, 2, 4, 1, 5);
        set.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println(set);

        // 병럴 처리
        List<String> subjects = Arrays.asList("java", "mysql", "jdbc", "html", "js");
//        subjects.stream().forEach(System.out::println); //싱글 쓰레도
        subjects.parallelStream().forEach(System.out ::println); // 멀티 쓰레드
    }
}
