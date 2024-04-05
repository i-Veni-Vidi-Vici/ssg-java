package com.sh.lambda_03.functional._interface;

import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

public class App3 {
    public static void main(String[] args) {
        IntSupplier intSupplier = () -> (int)(Math.random()*6)+1;
        System.out.println(intSupplier.getAsInt());

        LongSupplier longSupplier = () -> System.currentTimeMillis();
        System.out.println(longSupplier.getAsLong());
    }
}
