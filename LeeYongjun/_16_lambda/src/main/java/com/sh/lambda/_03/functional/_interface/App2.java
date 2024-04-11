package com.sh.lambda._03.functional._interface;

import java.time.LocalDate;
import java.util.function.*;

/**
 * <pre>
 * Consumer 함수형 인터페이스 관련
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // 기본형을 지원하는 Consumer
        // intConsumer
        IntConsumer intConsumer = (n) -> System.out.println(n);
        intConsumer.accept(123);
//        LongConsumer#accept(long):void
//        DoubleConsumer#accept(double):void

        // DoubleConsumer
        DoubleConsumer doubleConsumer = (d) -> System.out.println(d);
        doubleConsumer.accept(123.456);

        // BiConsumer<T, U>#accept(T,U):void
        BiConsumer<String,Integer> biConsumer =
                (name,age) -> System.out.println(name + "은 " + age + "살입니다.");
        biConsumer.accept("홍길동",33);

        //ObjIntConsumer
        ObjIntConsumer<String> objIntConsumer =
                (name,age) -> System.out.println(name + "은 " + age + "살입니다.");
        objIntConsumer.accept("신사임당",22);

        //ObjLongConsumer<T>#accept(T,long):void
        ObjLongConsumer<LocalDate> objLongConsumer =(start,days) -> System.out.println("우리 " + days + "일은 " + start.plusDays(days));
        objLongConsumer.accept(LocalDate.now(),100);

        //ObjDoubleConsumer<T>#accept(T,long):void

    }

}
