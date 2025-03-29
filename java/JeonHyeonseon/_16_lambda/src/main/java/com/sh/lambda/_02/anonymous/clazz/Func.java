package com.sh.lambda._02.anonymous.clazz;

public interface Func {

    /**
     * 인터페이스 하위에는 static 내부 인터페이스만 가능!!
     */
    @FunctionalInterface
    static interface IntFunc { // static은 생략 가능
        int calc(int x);
    }
    @FunctionalInterface
    static interface DoubleFunc { // static은 생략 가능
        double calc(double y);
    }
}
