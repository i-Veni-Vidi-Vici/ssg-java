package com.sh.lambda._03.functional._interface;


import com.sun.jdi.Value;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.function.*;

/**
 * <pre>
 * Supplier 함수형 인터페이스 관련
 * - 매개인자가 없고, 리턴값만 반환
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        //Supplier <T>#get():T
        Supplier<LocalDate> supplier=()->LocalDate.now();
        System.out.println(supplier.get());

        //BooleanSupplier#get():boolean
        BooleanSupplier booleanSupplier=()->LocalDate.now().getDayOfMonth()%2==0;
        System.out.println(booleanSupplier.getAsBoolean());

        //IntSupplier#get():int
        IntSupplier intSupplier=()-> (int)(Math.random()*6)+1;
        System.out.println("주사위 : "+intSupplier.getAsInt());

        //LongSupplier#get():long
        LongSupplier longSupplier=()-> System.currentTimeMillis();
        System.out.println(longSupplier.getAsLong());

        //DoubleConsumer#getAsLong():long
        //DoubleConsumer doubleConsumer=()->;

    }

}
