package com.sh.lambda._03.functional._interface;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.*;

/**
 * Supplier 함수형 인터페이스 관련
 *  - 매개인자가 없고, 리턴값만 반환
 */
public class App3 {
    public static void main(String[] args) {
        // Supplier<T>#get():T
        Supplier<LocalDate> supplier = () -> LocalDate.now();
        System.out.println(supplier.get());
        // BooleanSupplier#getAsBoolean():boolean
        BooleanSupplier booleanSupplier = () -> LocalDate.now().getDayOfMonth() % 2 == 0;
        System.out.println(booleanSupplier.getAsBoolean());
        // IntSupplier#get():int
        IntSupplier intSupplier = () -> (int)(Math.random() * 6) + 1;
        System.out.println(intSupplier.getAsInt());
        // LongSupplier#getAsLong():long
        LongSupplier longSupplier = () -> System.currentTimeMillis();
        // DoubleSupplier#getAsDouble():Double
        DoubleSupplier doubleSupplier = () -> 12.12;
    }
}
