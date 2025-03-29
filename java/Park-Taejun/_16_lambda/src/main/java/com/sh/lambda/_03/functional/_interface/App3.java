package com.sh.lambda._03.functional._interface;

import java.time.LocalDate;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/**
 * Supplier 함수형 인터페이스 관련
 * - 매개인자가 없고, 리턴값만 반환하는 연산.
 */
public class App3 {
    public static void main(String[] args) {
        //Supplier<T>#get() : T
        Supplier<LocalDate> supplier = () -> LocalDate.now();
        System.out.println(supplier.get());

        // BooleanSupplier#getAsBoolean() : boolean
        BooleanSupplier booleanSupplier = () -> LocalDate.now().getDayOfMonth() % 2 == 0;
        System.out.println(booleanSupplier.getAsBoolean());

        // IntSupplier() : int 주사위 값을 반환하는람다
        IntSupplier intSupplier = () -> (int) (Math.random() * 6 + 1);
        System.out.println(intSupplier.getAsInt());

        // LongSupplier() : long, Unix초를 반환(System,currentTimeMillis()) 하는 람다
        LongSupplier longSupplier = () -> System.currentTimeMillis();
        // DoubleSupplier() : double
    }
}
