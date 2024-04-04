package com.sh.stream._01.creation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <pre>
 * Stream이란? (외부자원에 대한 연결을 제공하는 Stream과는 다르다)
 * - jdk8에 추가되어 배열/컬렉션을 일관되게 제어하는 기술
 * - 람다식을 인자로 해서 간결하게 반복처리 가능
 * - 병렬처리(동시처리)도 쉽게 가능
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 2, 3, 5);
        Stream<Integer> stream1 = list.stream();
        stream1.sorted().forEach((n) -> System.out.println(n));
        System.out.println(list);

        int[] arr = {3, 2, 4, 1, 5};
        IntStream stream2 = Arrays.stream(arr);
        stream2.sorted()
                .forEach((n) -> System.out.println(n));
        System.out.println(Arrays.toString(arr));

        Set<Integer> set = Set.of(3, 2, 4, 1, 3);
//        IntStream 3 = Arrays.stream(arr);
        set.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println(set);

        // 병렬처리
        List<String> subjects = Arrays.asList("java", "mysql", "jdvc", "him", "js");
//        subjects.stream().forEach(System.out::println); // 싱글 쓰레드
        subjects.stream().forEach(System.out::println);
        subjects.parallelStream().forEach(System.out::println);  // 멀티 쓰레드 (병렬처리)
    }
}
