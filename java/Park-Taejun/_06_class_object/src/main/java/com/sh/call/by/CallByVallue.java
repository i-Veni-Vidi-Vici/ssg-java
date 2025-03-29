package com.sh.call.by;

public class CallByVallue {

    public void test(int n){
        n *= 10;
        n -= 30;

    }

    public int test2(int n) {
        return n;
    }
}
