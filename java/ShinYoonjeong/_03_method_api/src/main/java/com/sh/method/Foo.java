package com.sh.method;

public class Foo {
    public static int max(int a, int b) {
        if(a<b)
            return b;
        else
            return a;
        // return a > b ? a : b;
    }
}
