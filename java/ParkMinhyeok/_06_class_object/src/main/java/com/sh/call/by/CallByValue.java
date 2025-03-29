package com.sh.call.by;

public class CallByValue {
    public void test(int n) {
        n *= 10;
        n -= 30;

    }

    public int test2(int n) {
        n *= 10;
        return n;
    }
}
