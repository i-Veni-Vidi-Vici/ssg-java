package com.sh.lambda._04.method.reference;

import java.util.function.Consumer;

/**
 * <pre>
 * 메소드 참조
 * - 람다식을 더 간결하게 표현하는 문법.
 * - namespce::method -> 클래스 또는 객체::메소드명
 *
 * - static method
 * - non-static method
 * - 특정객체 기준 메소드
 * - 생성자
 * 
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 매개인자가 하나 있고, 리턴값은 없는 람다.
//        Consumer<String> consumer = str -> System.out.println(str);
        Consumer<String> consumer = System.out::println;
        consumer.accept("홍길동");

    }

}
