package com.sh.lambda._03.functional._interface;

import java.util.function.BiConsumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;

/**
 * <pre>
 *     Consumer 함수형 인터페이스 관련
 *      - 매개인자를 받고, 리턴값은 없다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // 기본형을 지원하는 Consumer
        // IntConsumer
        IntConsumer intConsumer = (n) -> System.out.println(n);
        intConsumer.accept(123);
        // DoubleConsumer
        DoubleConsumer doubleConsumer = d -> System.out.println(d);
        doubleConsumer.accept(1234.5678);
        // BiConsumer
        BiConsumer<String, Integer> biConsumer = (name, age) -> System.out.println(name + "은" + age + "살입니다.");
        biConsumer.accept("김연찬", 27);
        // ObjIntConsumer
        ObjIntConsumer<String> objIntConsumer = (name, age) -> System.out.println(name + "은" + age + "살입니다.");
        objIntConsumer.accept("홍길동", 33);
        // ObjLongConsumer

        // ObjDoubleConsumer

    }

}
