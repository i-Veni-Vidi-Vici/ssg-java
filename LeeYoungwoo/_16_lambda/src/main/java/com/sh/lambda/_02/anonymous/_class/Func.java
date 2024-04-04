package com.sh.lambda._02.anonymous._class;

/**
 * 인터페이스 하위에는 static 내부 인터페이스만 가능(내부 인터페이스에는 static 생략 가능)
 */
public interface Func {
    static interface IntFunc {
        int calc(int x);
    }

    interface DoubleFunc {
        double calc(double x);
    }
}
