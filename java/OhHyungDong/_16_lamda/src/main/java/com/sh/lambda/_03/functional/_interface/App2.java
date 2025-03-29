package com.sh.lambda._03.functional._interface;

import java.time.LocalDate;
import java.util.function.*;

/**
 * <pre>
 *   Consumer 함수형 인터페이스 관련
 *   - 매개인자를 받고ㅡ 리턴값은 없다
 * </pre>
 */
public class App2
{
    public static void main(String[] args) {
        //기본형을 지원하는 Consumer
        //IntConsumer#accept(int)void
        IntConsumer intConsumer = (n) -> System.out.println(n);
        intConsumer.accept(123);
        //DoubleConsumer#accept(double)void
        DoubleConsumer doubleConsumer = (d) -> System.out.println(d);
        doubleConsumer.accept(1234.56);

        //BiConsumer<T,U>#accept(T,U) void
        BiConsumer<String,Integer> biConsumer =
                (name, age) -> System.out.println(name + "은" + age + "살입니다.");
        biConsumer.accept("ghdrlfehd", 33);

        //ObjIntConsumer<T>#accept(T,int) void  -> int는 이미 지정됨
        ObjIntConsumer<String> objIntConsumer = (name,age) -> System.out.println(name + "은" + age + "삷입니다.");
        objIntConsumer.accept("tlstk", 22);
        //ObjLonConsumer<T>#accept(T,Long) void
        //ObjLongConsumer<String> objLongConsumer = (name,age) -> System.out.println(name + "은" + age + "살입니다.");
        //ObjDoubleConsumer<T>#accept(T,double) void
        ObjDoubleConsumer<String> objDoubleConsumer = (name, weight) -> System.out.println(name + "은" + weight + "살입니다.");

    }
}
