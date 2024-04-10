package com.sh.lambda_05.collection;

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

        // List#forEach(Consumer<T>)
//        list.forEach((n) -> System.out.println(n));
        list.forEach(System.out::println);

        // List#removeIf(Predicate<T>)
        list.removeIf((n) -> n == 20);
        System.out.println(list); // [10, 30]

        // List#replaceAll(UnaryOperator<T>)
        list.replaceAll((n) -> n * 10);
        System.out.println(list); // [100, 300]
    }
}
