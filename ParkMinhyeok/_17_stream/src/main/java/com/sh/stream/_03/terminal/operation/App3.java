package com.sh.stream._03.terminal.operation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <pre>
 * collect 단말연산
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> intList2 = intList.stream()
                .map((n) -> n * 10)
                .collect(Collectors.toList());
        System.out.println(intList2);

        Set<Integer> intSet = List.of(1, 2, 3, 2, 2, 3, 2, 1, 3, 4).stream()
                .collect(Collectors.toSet());
        System.out.println(intSet);

        Map<String, Integer> map = List.of("홍길동", "신사임당", "홍길동", "이순신", "홍길동").stream()
                .collect(Collectors.toMap(
                        (name) -> name,
                        (name) -> 1,
                        (v1, v2) -> v1 + v2
                ));// keyFunction, valueFunction, mergeFunction
        System.out.println(map);

        // 배열 변환
        Object[] arr = List.of(1, 2, 3, 2, 2, 3, 2, 1, 3, 4).stream().toArray();
        System.out.println(Arrays.toString(arr));

        // 문자열 조합
        String result = List.of("홍길동", "신사임당", "홍길동", "이순신", "홍길동").stream()
                .collect(Collectors.joining(" | ", "<", ">"));
        System.out.println(result);

        // 이웃들의 이름만 출력하세요 (동명은 한 번만 출력되고, 오름차순 정렬되어 있어야 합니다.)
//        List<Person> people = Arrays.asList(
//                new Person("홍길동", 33),
//                new Person("신사임당", 40),
//                new Person("이순신", 27),
//                new Person("장영실", 55),
//                new Person("홍길동", 33)
//        );
//        Set<String> names = people.stream()
//                .map(Person::getName)
//                .sorted()
//                .collect(Collectors.toCollection(LinkedHashSet::new));
//        System.out.println(names);
        String result2 = Arrays.asList(
                new Person("홍길동", 33),
                new Person("신사임당", 40),
                new Person("이순신", 27),
                new Person("장영실", 55),
                new Person("홍길동", 33)
        ).stream()
                .map(Person::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(result2);
    }
}
