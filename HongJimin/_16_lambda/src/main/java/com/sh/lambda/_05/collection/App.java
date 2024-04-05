package com.sh.lambda._05.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     람다를 인자로 하는 List 메소드
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        //List#forEach(Consumer<T>)
//        list.forEach((n) -> {System.out.println(n);});
        list.forEach(System.out::println); //위랑 같은 출력값을 가짐!-!

        //List#removeIf(Predicate<T>)
        list.removeIf((n) -> n== 20); //이 메소드도 모든 리스트 의 인덱스를 살펴보면서 진행됨!
        System.out.println(list); //[10, 30]
    }
}
