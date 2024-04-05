package com.sh.stream._01.creation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream 이란?
 * -jdk에 추가되어 배열/컬렉션을 일관되게 제어하는 기술
 * -람다식을 인자로 해서 간결하게 반복처리 가능
 * -병렬처리도 쉽게 가
 */
public class App {
    public static void main(String[] args) {
            List<Integer> list = Arrays.asList(1,2,3,4,5);
            Stream<Integer> stream1 = list.stream();
            stream1.sorted().forEach((n)->System.out.println(n));

            int[] arr = {3,2,4,1,5};
            IntStream stream2 = Arrays.stream(arr);
            stream2.sorted().forEach((n)->System.out.println(n));

            Set<Integer> set = Set.of(3,2,4,1,5);
            set.stream().sorted().forEach(System.out::println);
        System.out.println(set);

        //병렬처리
        List<String> subjects = Arrays.asList("java","mysql","jdbc","html","js");
        subjects.stream().forEach(System.out::println);//싱글쓰레드
        subjects.parallelStream().forEach(System.out::println);//멀티쓰레드 (병렬처리)


    }
}
