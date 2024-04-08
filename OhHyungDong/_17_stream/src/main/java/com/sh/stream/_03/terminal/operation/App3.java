package com.sh.stream._03.terminal.operation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * collect 단말연산
 * - 스트림의 연산 결과를 리스트 / 셋 / 맵 / String으로 변환
 * - 스트림 연산은 원본 컬렉션, 배열 등을 수정하지 않으므로, collect를 통해 결과를 받아야한다.
 */
public class App3 {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> intList2 = intList.stream()
                .map(n -> n * 10) //스트림 연산
                //.mapToInt(n -> n * 10) -> IntStream으로 변경 되고
                //.boxed() -> IntStream을 Integer형으로 변경한 다음
                //.collect(Collectors.toList());이렇게 해야 .collect(Collectors.toList()) 사용 가능 !
                //IntStream형태에서는 Collectors.toList()는 사용불가
                .collect(Collectors.toList());
        System.out.println(intList2);

        Set<Integer> collect = List.of(1, 2, 2, 3, 2, 2, 3, 2, 1, 3, 5).stream().collect(Collectors.toSet());

        //Map<String, Integer>
        List.of("홍길동", "신사임당", "홍길동", "이순신", "홍길동")
                //key Function, valueFunction, mergeFunction
                .stream().collect(Collectors.toMap(
                        (name) -> name, // key 값
                        (name) -> 1, // vaule값
                        (v1,v2) -> v1 + v2
                ));

        //배열 변환
        Object[] array = List.of(1, 2, 2, 3, 2, 2, 3, 2, 1, 3, 5).stream().toArray();// Object[] 배열이 반환됨.

        //문자열 조합
        String result = List.of("홍길동", "신사임당", "홍길동", "이순신", "홍길동").stream()
                .collect(Collectors.joining("|","<",">")); //(구분자, 접두사, 접미사)
        System.out.println(result);

        //이웃들의 이름만 출력하세요 (동명은 한번만 출력되고, 오름차순 정렬 )
        Stream<String> names = Arrays.asList(
                        new Person("홍길동", 33),
                        new Person("신사임당", 40),
                        new Person("이순신", 27),
                        new Person("장영실", 55),
                        new Person("홍길동", 55)) .stream()
               .map(Person::getName)
                .distinct()
                .sorted();



    }
}
