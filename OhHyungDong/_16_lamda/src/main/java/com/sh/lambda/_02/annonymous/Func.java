package com.sh.lambda._02.annonymous;

/**
 * 인터페이스 하위에는 static 내부 인터페이스만 가능 !
 */
public interface Func
{
    @FunctionalInterface
    static interface IntFunc
    {
        int calc(int n);
    }
    @FunctionalInterface
    static interface DoubleFunc
    {
        double calc(double n);
    }
}