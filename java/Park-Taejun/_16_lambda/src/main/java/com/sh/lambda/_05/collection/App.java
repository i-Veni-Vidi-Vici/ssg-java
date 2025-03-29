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
        //List#forEach는 콘슈머를 받음
//        list.forEach((n) -> {System.out.println(n); //모든 요소에 순차 접근
        list.forEach(System.out::println); //모든 요소에 순차 접근

        // List#removeIf(Predicate<T>)
        list.removeIf((n) -> n == 20); //20 이면 지워라
        System.out.println(list);

        // List#replaceAll(UnaryOperator<T>)
        list.replaceAll((n) -> n *10); //하나 받아서 곱하기 10 한걸로 바꿔달라오
        System.out.println(list);
    }
}
