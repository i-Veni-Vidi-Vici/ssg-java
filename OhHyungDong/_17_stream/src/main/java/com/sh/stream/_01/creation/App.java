package com.sh.stream._01.creation;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * stream이란 ?
 * - jdk 8에 추가되어 배열(Array) / 컬렉션(Collection)을 일관되게 제어하는 기술
 * - 람다식을 인자로 해서 간결하게 반복처리
 * - 병렬처리도(동시처리(스레드처리)) 쉽게 가능
 */
public class App {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4,2, 3, 5);
        Stream<Integer> stream = list.stream(); //stream을 만들때는 원본 배열을 복사하기만 하고, 원본은 그상태로 보관
        stream.sorted().forEach((n) -> System.out.println(n));
        System.out.println(list);

        int[] arr = {3, 2, 4, 1, 5};
        IntStream stream1 = Arrays.stream(arr);
        stream1.sorted()
                .forEach((n) -> System.out.println(n));
        System.out.println(Arrays.toString(arr));

        Set<Integer> set = Set.of(3, 2, 4, 1, 5);
        set.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println(set);


        //병렬 처리
        List<String> subjects = Arrays.asList("java","mysql","jdbc","html","js");
//        subjects.stream().forEach(System.out::println); //싱글스레드
        subjects.parallelStream().forEach(System.out::println);//멀테쓰레드 ( 병렬처리)

        //filter -> Predicate의 함수형 인터페이스로 매개변수 값 받고 -> true나 false 반환
        List<String> names = Arrays.asList("Eric", "Elena", "Java");
        //위 코드에서 이름에 a가 포함되어 있으면 Stream에 값 저장
        Stream<String> stream2 = names.stream().filter(name -> name.contains("a"));
        //forEach문은 Consumer이기 때문에 람다식으로 표현 할 수 있다. Consumer은 매개변수 값은 있지만 리턴값은 없다.
        stream2.sorted().forEach((n) -> System.out.println(n));

        //map -> Function인터페이스 : 매개변수 + 리턴값 둘다 가지고 있음.
        Stream<String> stringStream = names.stream().map((name) -> (name.toUpperCase()));
        stringStream.sorted().forEach((n) -> System.out.println(n));

//        Stream<Integer> stream3 = names.stream().map

    }
}
