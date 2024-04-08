package com.sh.stream._02.intermediate.operation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * <pre>
 *     ### flatMap 중간 연산
 *     - 다차원 데이터를 1차원 데이터로 변경
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        List<List<String>> lists = Arrays.asList(
                Arrays.asList("java", "mysql", "jdbc"),
                Arrays.asList("html", "css", "js")
        );
//        System.out.println(list); //[[java, mysql, jdbc], [html, css, js]]

        lists.stream()
//                .flatMap((list) -> list.stream())//Collection#stream
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }
}
