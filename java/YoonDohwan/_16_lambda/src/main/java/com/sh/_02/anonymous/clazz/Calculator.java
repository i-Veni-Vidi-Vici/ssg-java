package com.sh._02.anonymous.clazz;

public interface Calculator {
    int calc(int a, int b);

}
interface Printer{
    void print(String str);
}
class Func {
    interface IntFunc {
        int calc(int n);
    }

    interface DoubleFunc {
        double calc(double n);
    }
}