package com.sh.lambda._02.anonymous.clazz;

public interface Func {
    /**
     * 인터페이스 하위에 인터페이스는 static만 가능하다
     * 생략해도 무방하다
     */
    @FunctionalInterface
    static interface IntFunc
    {
        int calc(int n);
    }

    @FunctionalInterface
    interface DoubleFunc{
        double calc(double n);
    }
}
