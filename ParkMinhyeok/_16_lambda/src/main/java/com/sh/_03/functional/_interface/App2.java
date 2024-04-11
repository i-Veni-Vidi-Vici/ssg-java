package com.sh._03.functional._interface;

import java.time.LocalDate;
import java.util.function.*;

public class App2 {
    public static void main(String[] args) {
        // 기본형을 지원하는 Consumer
        // IntConsumer#accetp(int):void

        IntConsumer intConsumer = (n) -> System.out.println(n);
        intConsumer.accept(123);

        // LongConsumer#accept(long):void
        // DoubleConsumer
        DoubleConsumer doubleConsumer = (d) -> System.out.println(d);
        doubleConsumer.accept(123.456);

        // BiConsumer<T, U>#accept(T, U):void
        BiConsumer<String, Integer> biConsumer =
                (name, age) -> System.out.println(name + "은 " + age + "살입니다.");
        biConsumer.accept("홍길동", 33);

        // ObjIntConsumer<T>#accept(T, int):void
        ObjIntConsumer<String> objIntConsumer = (name, age) ->
                System.out.println(name + "은 " + age + "살입니다");
        objIntConsumer.accept("신사입당", 22);
        // ObjLongConsumer<T>#acept(T, long):void
        ObjLongConsumer<LocalDate> objLongConsumer = (start, days) ->
                System.out.println("우리 " + days + "일은 " + start.plusDays(days) + "입니다.");
        objLongConsumer.accept(LocalDate.now(), 100);
        // ObjDoubleConsumer<T>#acept(T, long):void

    }
}
