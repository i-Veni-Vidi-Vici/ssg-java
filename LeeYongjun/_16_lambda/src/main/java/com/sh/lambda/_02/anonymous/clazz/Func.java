package com.sh.lambda._02.anonymous.clazz;

/**
 * <pre>
 * 인터페이스 하위에는 static 내부 인터페이스만 가능!
 * </pre>
 */
public interface Func {
    @FunctionalInterface
    static interface IntFunc{
         int calc(int x);
    }
    static interface DoubleIntFunc{
        double calc(double x);
    }
}
