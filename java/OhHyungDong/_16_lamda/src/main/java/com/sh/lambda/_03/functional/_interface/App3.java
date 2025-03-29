package com.sh.lambda._03.functional._interface;

import java.time.LocalDate;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/**
 * <pre>
 *  Supplier 함수형 인터페이스 관련
 *  - 매개인자가 없고, 리턴값만 반환
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        //Supplier<T>#get():T
        Random rnd = new Random();
        Supplier<LocalDate> supplier = () -> LocalDate.now();
        System.out.println(supplier.get());

        //BooleanSupplier#getAsBoolean() : boolean -> 제네릭이 없고, 값이 이미 지정되어있어서 반환값에 대한 자료형이 다름
        BooleanSupplier booleanSupplier = () -> LocalDate.now().getDayOfMonth() % 2 == 0;
        System.out.println(booleanSupplier.getAsBoolean());
        //IntSupplier#get() : int
        IntSupplier intSupplier = () -> rnd.nextInt(6)+ 1;
        System.out.println("주사위 값은 " + intSupplier.getAsInt() + "입니다.");
        //LongSupplier#get() : Long
        LongSupplier longSupplier = () -> System.currentTimeMillis();
        System.out.println("UNIX 초 : " + longSupplier.getAsLong());
        //DoubleSupplier#get() : double
    }
}
