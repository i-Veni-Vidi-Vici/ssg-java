package com.sh.stream._02.intermediate.operation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <Pre>
 * flatMap 중간연산
 * - 다차원 데이터를 1차원 데이터로 변경한다.
 * </Pre>
 */

public class App4 {
    public static void main(String[] args) {
        List<List<String>> lists = Arrays.asList(
                Arrays.asList("java", "mysql", "jdbc"),
                Arrays.asList("html", "css", "js")
        );
        System.out.println(lists);
//        lists.stream()
//                .forEach(System.out::println); // 최소한의 리스트 단위로 출력해주는 듯

        lists.stream().flatMap((list) -> list.stream()).forEach(System.out::println);

        List<List<String>> lists2 = List.of(
                List.of("java", "mysql", "jdbc"),
                List.of("html", "css", "js")
        );

        lists2.stream()
//                .flatMap((list) -> list.stream()) // ? super Collection
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        List<List<List<String>>> list3 = List.of(
                List.of(
                        List.of("경제기사 궁금증 300문 300답"),
                        List.of("영단기 토익 기출 보카")
                ),
                List.of(
                        List.of("바리스타 2급 자격시험"),
                        List.of("태건한국사 개념완성편")
                ),
                List.of(
                        List.of("헤어질 결심"),
                        List.of("지구 끝의 온실")
                )
        );

        list3.stream().forEach(System.out::println);

        list3.stream()
                .flatMap((l1) -> l1.stream())
                .forEach(System.out::println);

        list3.stream()
                .flatMap((l1) -> l1.stream()
                        .flatMap((l2) -> l2.stream()))
                                .forEach(System.out::println);

    }
}
