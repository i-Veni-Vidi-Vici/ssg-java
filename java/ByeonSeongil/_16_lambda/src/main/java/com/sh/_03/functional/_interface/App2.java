package com.sh._03.functional._interface;

import java.util.function.BiConsumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;

/**
 * <pre>
 * Consumer 함수형인터페이스 관련
 * - 매개인자를 받고, 리턴값은 없다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // 기본형을 지원하는 Consumer
        // IntConsumer#accept(int):void
        IntConsumer intConsumer = (n) -> System.out.println(n);
        intConsumer.accept(123);
        // LongConsumer#accept(long):void
        // DoubleConsumer#accept(double):void
        DoubleConsumer doubleConsumer = (d) -> System.out.println(d);
        doubleConsumer.accept(123.456);

        // BiConsumer<T, U>#accept(T, U):void
        BiConsumer<String, Integer> biConsumer = (name, age) -> System.out.println(name + "은" + age + "살 입니다.");
        biConsumer.accept("홍길동", 33);

        // ObjIntConsumer<T>#accept(T, int):void
        ObjIntConsumer<String> objIntConsumer = (name, age) -> System.out.println(name + "은" + age + "살 입니다.");
        objIntConsumer.accept("신사임당", 55);
        // ObjLongConsumer
        ObjLongConsumer<String> objLongConsumer = (name, age) -> System.out.println(name + "은" + age + "살 입니다.");
        objLongConsumer.accept("가좌", 33L);
        // ObjDoubleConsumer
    }
}
