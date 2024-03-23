package com.sh.call.by;

public class CallByValue {
    public void test(int n) {
        n *= 10;
        n -= 30;
        System.out.println(n);
    }

    public int test2(int n) {
        n *= 10;
        n -= 30;
        return n;
    }
}
