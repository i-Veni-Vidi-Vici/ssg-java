package com.sh.lambda._02.anonymous.clazz;

public interface Func {
    @FunctionalInterface
    interface IntFunc {
        int calc(int n);
    }

    @FunctionalInterface
    interface DoubleFunc {
        double calc(double n);
    }
}
