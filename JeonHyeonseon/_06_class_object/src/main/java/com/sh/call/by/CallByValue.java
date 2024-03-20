package com.sh.call.by;

public class CallByValue {
    public void test(int n) {  // 선언부 : n은 매개변수
        n *= 10;
        n -= 30;
    }

    public int test2(int n) {
        n *= 10;  // 100
        n -= 30;  // 100- 30 = 70
        return n;
    }
}
