package com.sh.stream._01.creation;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <pre>
 * Stream 이란?
 * - jdk8에 추가되어 배열\컬렉션을 일관되게 제어하는 기술
 * - 람다식을 인자로 해서 간결하게 반복처리 가능
 * - 병렬처리 (동시처리)도 쉽게 가능
 * 쓰는 이유 일관된 처리, 병렬처리, 람다처리 하고 싶어서
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 2, 3, 5);
        Stream<Integer> stream1=list.stream();
        list.stream().sorted().forEach((n)-> System.out.println(n));

        int[] arr={3,2,4,1,5};
        IntStream stream2= Arrays.stream(arr);
        stream2.sorted().forEach((n)-> System.out.printf("%d",n));

        Set<Integer> set=Set.of(1,4,3,2,5);//스트림을 쓰면 순서가 있는 데이터가 된다
        set.stream().sorted().forEach(System.out::println);
        System.out.println(set);

        List<String> subjects=Arrays.asList("jva","sql","jdbc","html","js");
        subjects.parallelStream().forEach(System.out::println);//멀티 쓰레드 (병행처리);
    }
}
