package com.sh.lambda._05.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 람다를 인자로 하는 List메소드
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        // List#forEach(Consumer<T>)  List에 있는 forEach문은 Consumer을 받는다.
//        list.forEach((n) -> System.out.println(n)); // 모든 요소에 순차적으로 접근 가능
        list.forEach(System.out::println);

        // List#removeIf(Predicate<T>)
        list.removeIf((n) -> n == 20);  // n이 20이면 지워라 라는 의미.
        System.out.println(list);
    }
}
