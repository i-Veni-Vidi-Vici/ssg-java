package com.sh.lambda._03.functional._interface;

import java.time.LocalDate;
import java.util.function.*;

/**
 * <pre>
 *     ### Consemer 함수형 인터페이스 관련
 *      - 매개 인자를 받고, 리턴값은 없음!
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // 기본형을 지원하는 Consumer
        // IntConsumer#accept(int) : void
        IntConsumer intConsumer = (n) -> System.out.println(n);
        intConsumer.accept(123); //이 자리에 무조건 int만 받음!

        // LongConsumer#accept(long) : void
        //DoubleConsumer
        DoubleConsumer doubleConsumer = (d) -> System.out.println(d);
        doubleConsumer.accept(123.456);

        // BiConsumer
        BiConsumer<String, Integer> biConsumer = (name, age) -> System.out.println(name + "은 " + age + "살 입니다.");
        biConsumer.accept("홍길동", 33);

        // ObjIntConsumer<T>#accept(T, int) : void
        ObjIntConsumer<String> objIntConsumer = (name, age) -> System.out.println(name + "은 " + age + "살 입니다.");
        objIntConsumer.accept("심사임당", 22);

        // ObjLongConsumer<T>#accept(T, long) : void
        ObjLongConsumer<LocalDate> objLongConsumer = (start, days) -> System.out.println("우리 " + days + "일은 " + start.plusDays(days) + "입니다.");
        objLongConsumer.accept(LocalDate.now(), 100);

        // ObjDoubleConsumer<T>#accept(T, double) : void
    }
}
