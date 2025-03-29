package com.sh.method;

public class Bar {
    public int min(int m, int n) {  // non-static 메소드라 객체 생성 해야함
        // return m < n ? m : n;
        return Math.min(m, n);
    }
}
