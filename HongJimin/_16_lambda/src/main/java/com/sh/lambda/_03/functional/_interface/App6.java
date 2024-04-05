package com.sh.lambda._03.functional._interface;

import java.util.function.Predicate;

/**
 * <pre>
 *     ### Predicate 함수형 인터페이스 관련
 *      - 매개인자를 받아, boolean을 리턴하는 경우
 * </pre>
 */
public class App6 {
    public static void main(String[] args) {
        //Predicate<T>#test(T) : boolean
        Predicate<Integer> predicate = (age) -> age >= 20; //성인 검사
        System.out.println(predicate.test(25)); //true
        System.out.println(predicate.test(16)); //false

        //✨이런게 있다 정도로 알고가기!!!
        //BiPredicate<T, U>#test(T, U):boolean
        //IntPredicate#test(int):boolean
        //LongPredicate#test(long):boolean
        //DoublePredicate#test(double):boolean

    }
}
