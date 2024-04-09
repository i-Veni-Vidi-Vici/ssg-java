package com.sh.stream._02.intermediate.operation;

import java.util.*;

/**
 * <pre>
 * flatMap 중간연산
 * - 다차원 데이터를 1차원 데이터로 변경한다
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        List<List<String>> lists = Arrays.asList(
                Arrays.asList("java","mysql","jdbc"),
                Arrays.asList("html","css","js")
        );
        System.out.println(lists);

        lists.stream()
                //.flatMap((list)->list.stream())
                .flatMap(Collection::stream)
                .forEach((list)-> System.out.printf(list +" "));
    }
}
