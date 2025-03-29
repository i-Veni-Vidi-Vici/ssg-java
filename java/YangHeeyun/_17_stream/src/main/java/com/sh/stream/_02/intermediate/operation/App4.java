package com.sh.stream._02.intermediate.operation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * <pre>
 *  flatMap 중간연산
 *  - 다차원 데이터를 1차원 데이터로 변경한다.
 *
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
         List<List<String>> lists = Arrays.asList(
                 Arrays.asList("java","mysql","jdbc"),
                 Arrays.asList("html","css","js")
         );
         // 2차원 배열
//        System.out.println(list);

        lists.stream()
                //.flatMap 리스트를 연결시켜 1차원 데이터로 만듬
//                .flatMap((list) -> list.stream()) // Collections#stream
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }
}
