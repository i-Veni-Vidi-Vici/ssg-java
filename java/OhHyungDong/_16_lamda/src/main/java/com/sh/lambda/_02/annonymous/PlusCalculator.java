package com.sh.lambda._02.annonymous;

public class PlusCalculator implements Calculator{
    @Override
    public int calc(int a, int b) {
        return a + b;
    }
}
