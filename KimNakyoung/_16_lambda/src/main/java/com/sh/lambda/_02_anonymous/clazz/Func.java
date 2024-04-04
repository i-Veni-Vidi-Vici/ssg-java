package com.sh.lambda._02_anonymous.clazz;

/**
 *
 * 인터페이스 하위에는 static 내부인터페이스만 가능 !
 *
 */


public interface Func {

    @FunctionalInterface
    static interface IntFunc{
        int calc(int x);

    }

    @FunctionalInterface
    interface DoubleFunc{
        double calc(double n);

    }
}
