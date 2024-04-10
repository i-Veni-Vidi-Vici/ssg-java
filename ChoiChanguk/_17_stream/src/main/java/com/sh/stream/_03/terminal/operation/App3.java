package com.sh.stream._03.terminal.operation;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <pre>
 * collect 단말연산
 * - 스트림의 연산결과를 리스트/셋/맵으로 변환
 * - 스트림연산은 원본 컬렉션, 배열 등을 수정하지 않으므로, collect를 통해 결과를 받아야 한다
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        List<Integer> intList1=List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> intLiset2= intList1.stream()
                .map((n)->n*10)
                .collect(Collectors.toList());// 이런 형태로 사용
        System.out.println(intLiset2);

        Set<Integer> intSet=List.of(1,2,3,4,5,66,66,34,23,21,2,3)
                .stream().collect(Collectors.toSet());
        System.out.println(intSet);

        //Map<String, Integer>
        Map<String, Integer> map=
                List.of("홍길동","신사임당","홍길동","이순신","홍길동")
                .stream()
                .collect(Collectors.toMap(
                        (name)->name,//List.of안에 있는 스트링을 name으로 받겟다
                        (name)->1,// value
                        (v1,v2)->v1+v2//키값이 동일할 때 value
                        ));// keyFunction, valueFunction, mergeFunction

        // 배열 변환
        Object[] array = List.of(1, 4, 6, 3, 1, 3, 4, 6, 4, 3).stream()
                .toArray();
        System.out.println(array);

        //문자열 조합
        String result=List.of("홍길동","신사임당","홍길동","이순신","홍길동").stream()
                .collect(Collectors.joining(" | ","<",">"));// 구분자, 접두사, 접미사
        //접두사 구분자 접미사 => <홍길동 | 신사임당 | 홍길동 | 이순신 | 홍길동>
        System.out.println(result);

        // 이웃들의 이름만 출력하세요 (동명은 한 번만 출력되고, 오름차순 정렬되어 있어야 합니다.
        String result2= Arrays.asList(
                new Person("홍길동",33),
                new Person("신사임당",40),
                new Person("이순신",27),
                new Person("장영실",55),
                new Person("홍길동",33)
        ).stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));
        System.out.println(result2);
        //map을 쓰고 key값
    }

}
