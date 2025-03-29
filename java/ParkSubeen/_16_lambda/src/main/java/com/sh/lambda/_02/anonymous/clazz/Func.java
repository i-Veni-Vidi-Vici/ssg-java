package com.sh.lambda._02.anonymous.clazz;

public class Func {
    @FunctionalInterface
    static interface IntFunc {
        int calc(int n);
    }

    @FunctionalInterface
    static interface DoubleFunc{
        double calc(double n);
    }
}
