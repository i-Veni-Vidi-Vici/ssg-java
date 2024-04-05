package com.sh.lambda._03.functional._interface;

import java.time.LocalDate;
import java.util.function.*;

/**
 * <pre>
 * Consumer 함수형 인터페이스 관련
 *  : 특징 - 매개인자를 받고, 리턴값은 없다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // 기본형을 지원하는 Consumer
        // IntConsumer#accept(int):void
        IntConsumer intConsumer = (n) -> System.out.println(n);
        intConsumer.accept(123); // int타입의 정수만 받는다.

        // LongConsumer#accept(long):void

        // DoubleConsumer#accept(double):void
        DoubleConsumer doubleConsumer = (d) -> System.out.println(d);
        doubleConsumer.accept(123.456);

        // BiConsumer<T, U>#accept(T, U):void  // T는 타입
        BiConsumer<String, Integer> biConsumer =
                (name, age) -> System.out.println(name + "은 " + age + "살입니다.");
        biConsumer.accept("전현선", 24);

        // ObjIntConsumer<T>#accept(T, int):void
        ObjIntConsumer<String> objIntConsumer =
                (name, age) -> System.out.println(name + "은 " + age + "살입니다.");
        objIntConsumer.accept("작년 전현선", 23);

        // ObjLongConsumer<T>#accept(T, long):void
        ObjLongConsumer<LocalDate> objLongConsumer =
                (start, days) -> System.out.println("우리 " + days + "일은 " + start.plusDays(days) + "입니다.");
        objLongConsumer.accept(LocalDate.now(), 100);

        // objDoubleConsumer<T>#accept(T, double):void
    }
}
