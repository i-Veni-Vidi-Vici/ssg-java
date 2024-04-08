package com.sh.lambda._02.anonymous.clazz;

public class Func {

    @FunctionalInterface
    public interface IntFunc{
        public int calc(int num);
    }

    @FunctionalInterface
    public interface DoubleFunc{
        public double calc(double num);
    }
}
