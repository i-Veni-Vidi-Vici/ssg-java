package com.sh.lambda_02.anonymous._class;

public interface Func {
    /**
     * 인터페이스 하위에는 static 내부인터페이스만 가능!
     */
    @FunctionalInterface
    static interface IntFunc {
        int calc(int x);
    }

    @FunctionalInterface
    interface DoubleFunc {
        double calc (double d);
    }
}
