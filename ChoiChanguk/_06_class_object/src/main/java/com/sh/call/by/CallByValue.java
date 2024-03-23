package com.sh.call.by;

import java.text.BreakIterator;

public class CallByValue {
    public void test(int n) {
        n*=10;
        n-=10;
        //return n;

    }

    public int test2(int n) {
        n*=10;
        n-=30;
        return n;
    }
}
