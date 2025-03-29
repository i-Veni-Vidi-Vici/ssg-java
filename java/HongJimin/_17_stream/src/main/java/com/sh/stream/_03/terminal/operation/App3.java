package com.sh.stream._03.terminal.operation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <pre>
 *     ### 쓰레드를 생성하는 방법2
 *      - Runnable 인터페이스를 구현한 클래스를 작성 → Thrad를 작성
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> intList2 = intList.stream()
                .map((n) -> n * 10)
                .collect(Collectors.toList());
        System.out.println(intList2); //[10, 20, 30, 40, 50, 60, 70, 80, 90, 100]

        Set<Integer> intSet = List.of(1, 2, 3, 2, 3, 2, 1, 3, 4).stream()
                .collect(Collectors.toSet());
        System.out.println(intSet); //[1, 2, 3, 4]

        //Map<String, Integer>
        Map<String, Integer> map = List.of("홍길동", "신사임당", "홍길동", "이순신", "홍길동").stream()
                .collect(Collectors.toMap(
                        (name) -> name,
                        (name) -> 1,
                        (v1, v2) -> v1 + v2
                ));//keyFunction, ValueFuntion, mergeFunction
        System.out.println(map);

        //배열 반환
        Object[] arr = List.of(1, 2, 3, 2, 2, 3, 2, 1, 3, 4).stream().toArray();//Object[]
        System.out.println(Arrays.toString(arr)); //[1, 2, 3, 2, 2, 3, 2, 1, 3, 4]

        //문자열 조합
        String result = List.of("홍길동", "신사임당", "홍길동", "이순신", "홍길동").stream()
//                .collect(Collectors.joining()); //구분자, 접두사, 접미사를 받음
                .collect(Collectors.joining(" | ", "< ", " >")); //구분자, 접미사, 접두사
        System.out.println(result); //홍길동신사임당홍길동이순신홍길동, < 홍길동 | 신사임당 | 홍길동 | 이순신 | 홍길동 >

        //이웃들의 이름만 출력하세요(동명은 한번만 출력되고, 오름차순 정렬되어있어야 합니다.)
        String result2 = Arrays.asList(
                        new Person("홍길동", 33),
                        new Person("신사임당", 40),
                        new Person("이순신", 27),
                        new Person("장영실", 55),
                        new Person("홍길동", 33))
                .stream()
                .map(Person::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(result2); //신사임당, 이순신, 장영실, 홍길동
    }
}
