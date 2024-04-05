package com.sh.lambda._02.anonymous.clazz;

public class Func {
    /**
     * 인터페이스 하위에는 static 내부 인터페이스만 가능!
     */
    @FunctionalInterface
    interface IntFunc {
        int calc(int n);
    }

    interface DoubleFunc {
        double calc(double n);
    }
}
