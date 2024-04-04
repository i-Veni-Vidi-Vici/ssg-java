package com.sh.anonymous.clazz;

/**
 * 인터페이스 하위에는 static 내부 인터페이스만 가능!
 */
public interface Func {
    static interface IntFunc{
        int calc(int x);

    }
    interface DoubleFunc{
        double calc (double d);
    }
}
