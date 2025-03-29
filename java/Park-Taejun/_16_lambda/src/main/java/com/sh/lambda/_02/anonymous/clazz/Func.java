package com.sh.lambda._02.anonymous.clazz;

/**
 * 인터페이스 하위에는 static 내부 인터페이스만 가능함
 */

public interface Func {

    @FunctionalInterface
    static interface IntFunc {
        int calc(int x);
    }

    @FunctionalInterface
    interface DoubleFunc{
        double calc (double d);
    }
}
