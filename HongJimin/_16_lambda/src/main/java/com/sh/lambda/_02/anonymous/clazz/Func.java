package com.sh.lambda._02.anonymous.clazz;

public interface Func {
    /**
     * 인터페이스 하위에는 static 내부 인터페이스만 가능!
     */
    @FunctionalInterface
    static interface IntFunc{
        int calc(int x);
    }

    @FunctionalInterface

    static interface DoubleFunc{
        double calc(double d);
    }
}
