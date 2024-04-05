package com.sh.stream._03.terminal.operation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <pre>
 * collect 단말연산
 * - 스트림의 연산결과를 리스트/셋/맵/String으로 변환
 * - 스트림연산은 원본컬렉션, 배열 등을 수정하지 않으므로, collect를 통해 결과를 받아야 한다.
 *
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> intList2 = intList.stream()
                .map((n) -> n * 10)
                .collect(Collectors.toList());
        System.out.println(intList2);

        Set<Integer> integerSet = List.of(1, 2, 3, 2, 2, 3, 2, 1, 3, 4).stream()
                .collect(Collectors.toSet());
        System.out.println(integerSet);

        Set<String> stringSet = List.of("홍길동", "신사임당", "홍길동", "이순신", "홍길동")
                .stream().collect(Collectors.toSet());
        System.out.println();

        Map<String, Integer> map = List.of("홍길동", "신사임당", "홍길동", "이순신", "홍길동").stream()
                .collect(Collectors.toMap(
                        (name) -> name,
                        (name) -> 1,
                        (v1, v2) -> v1 + v2
                )); // keyFunction, valueFunction, mergeFunction
        System.out.println(map);

        // 배열 반환
        Object[] arr = List.of(1, 2, 3, 2, 2, 3, 2, 1, 3, 4).stream().toArray();
        System.out.println(Arrays.toString(arr));

        // 문자열 조합
        String result = List.of("홍길동", "신사임당", "홍길동", "이순신", "홍길동").stream()
                .collect(Collectors.joining(", ", "👼", "🎈")); // 구분자, 접두사, 접미사
        System.out.println(result);

        // 이웃들의 이름만 출력하세요 (동명은 한번만 출력되고, 오름차순 정렬되어 있어야 합니다.)
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


//        String result3 = Arrays.asList(
//                new Person("홍길동", 33),
//                new Person("신사임당", 40),
//                new Person("이순신", 27),
//                new Person("장영실", 55),
//                new Person("홍길동", 33)
//        ).stream()
//                .map(Person::getAge)
    }
}