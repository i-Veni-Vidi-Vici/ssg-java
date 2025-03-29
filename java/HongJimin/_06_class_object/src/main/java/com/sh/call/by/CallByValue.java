package com.sh.call.by;

public class CallByValue {
    public void test(int n) { //매개 변수
        n *= 10;
        n -= 30;
    }

    public int test2(int n) {
        n *= 10;
        n -= 30;
        return n;
    }
}
