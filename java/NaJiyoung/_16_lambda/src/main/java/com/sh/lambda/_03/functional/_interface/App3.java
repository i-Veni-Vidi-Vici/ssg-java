package com.sh.lambda._03.functional._interface;

import java.time.LocalDate;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/**
 * <pre>
 * Supplier 함수형 인터페이스 관련
 * - 매개인자가 없고, 리턴값만 반환
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        // Supplier<T>#get():T
        Supplier<LocalDate> supplier = () -> LocalDate.now();
        System.out.println(supplier.get());

        // BooleanSupplier#getAsBoolean():boolean
        BooleanSupplier booleanSupplier = () -> LocalDate.now().getDayOfMonth() % 2 ==0;
        System.out.println(booleanSupplier.getAsBoolean());

        // IntSupplier#getAsInt():int
        // 주사위값을 반환하는 람다
        IntSupplier intSupplier = () -> (int) (Math.random() * 6 + 1);
        System.out.println(intSupplier.getAsInt());

        // LongSupplier#getAsLong():long
        // Unix초를 반환(System.currentTimeMills())하는 람다
        LongSupplier longSupplier = () -> System.currentTimeMillis();
        System.out.println(longSupplier.getAsLong());

        // DoubleSupplier#getAsDouble():double
    }
}
