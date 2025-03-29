package com.sh.stream._03.terminal.operation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <pre>
 * collect 단말연산
 * - 스트림의 연산결과를 리스트/셋/맵/String 변환
 * - 스트림 연산은 원본 컬렉션, 배열등을 수정하지 않으므로, collect를 통해 결과를 받아야 한다.
 *
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> intList2 =intList.stream()
                .map((n) -> n * 10)
                .collect(Collectors.toList());
        System.out.println(intList2);

        Set<Integer> intSet = List.of(1, 2, 3, 2, 2, 3, 2, 1, 3, 4).stream()
                .collect(Collectors.toSet());
        System.out.println(intSet);

        //이웃들의 이름만 출력하세요(동명은 한번만 출력되고, 오름차순 정렬되어 있어야 합니다.)

    }
}
