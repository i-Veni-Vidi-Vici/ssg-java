package com.sh.lambda._03.functional._interface;

import java.time.LocalDate;
import java.util.function.*;

/**
 * <pre>
 * Consumer 함수형인터페이스 관련
 * - 매개인자를 받고, 리턴값은 없다
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        //기본형을 지원하는 Consumer
        //IntConsumer
        IntConsumer intConsumer=(n)-> System.out.println(n);
        System.out.print("intConsumer : ");
        intConsumer.accept(+123);

        //DoubleConsumer
        DoubleConsumer doubleConsumer=(d)-> System.out.println(d);
        System.out.print("DoubleConsumer : ");
        doubleConsumer.accept(123.456);

        //BiConsumer
        BiConsumer<String, String > biConsumer=(str1,str2)-> System.out.println("str1 : "+str1+" str2 : "+str2);
        System.out.print("BiConsumer : ");
        biConsumer.accept("최창욱","33");

        //ObjIntConsumer// 이건 object+int 유사한건
        //=ObjectConsumer:void, ObjectDoubleConsumer:void
        ObjIntConsumer<String> objIntConsumer=(name, age)->System.out.println("name : "+name+" age : "+age);
        System.out.println("ObjIntConsumer : ");
        objIntConsumer.accept("최창욱",33);

        ObjLongConsumer<LocalDate> objLongConsumer=(start,days)->System.out.println("우리 : "+days+" 일은 : "+start.plusDays(days));
        objLongConsumer.accept(LocalDate.now(),100);

    }
}
