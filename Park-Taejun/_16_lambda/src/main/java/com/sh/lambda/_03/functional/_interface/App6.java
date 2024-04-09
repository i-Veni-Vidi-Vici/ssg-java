package com.sh.lambda._03.functional._interface;

import java.util.function.Predicate;

/**
 * Predicate 함수형 인터페이스 관련
 * - 매개인자를 받아서, boolean을 리턴
 */
public class App6 {
    public static void main(String[] args) {
        // Predicate<T>#test(T):boolean
        Predicate<Integer>predicate = (age) -> age >= 20;
        System.out.println(predicate.test(25));
        System.out.println(predicate.test(16));

        //BiPredicate<T, U>#test(T, U)
    }
}
