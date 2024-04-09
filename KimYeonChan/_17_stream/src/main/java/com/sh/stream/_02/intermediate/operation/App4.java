package com.sh.stream._02.intermediate.operation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * flatMap 중간연산
 *  - 다차원 데이터를 1차원 데이터로 변경한다.
 */
public class App4 {
    public static void main(String[] args) {
        List<List<String>> lists = Arrays.asList(
                Arrays.asList("java", "mysql", "jdbc"),
                Arrays.asList("html", "css", "js")
        );
        lists.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }
}
