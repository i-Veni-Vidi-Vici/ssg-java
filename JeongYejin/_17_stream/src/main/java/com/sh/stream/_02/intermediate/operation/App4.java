package com.sh.stream._02.intermediate.operation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App4 {
    public static void main(String[] args) {
        List<List<String>> lists = Arrays.asList(
                Arrays.asList("java", "mysql", "jdbc"),
                Arrays.asList("html", "css", "js")
        );
        System.out.println(lists);
        lists.stream()
                .forEach(System.out::println); // 최소한의 리스트 단위로 출력해주는 듯

        List<List<String>> lists2 = List.of(
                List.of("java", "mysql", "jdbc"),
                List.of("html", "css", "js")
        );

        lists2.stream()
//                .flatMap((list) -> list.stream()) // ? super Collection
                .flatMap(Collection::stream)
                .forEach(System.out::println);


    }
}
