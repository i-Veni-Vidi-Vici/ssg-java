package com.sh.call.by;

import java.util.Arrays;

public class App {
    public static void main(String [] args) {
        // call by value
        CallByValue callByValue = new CallByValue();
        int n = 10;

        callByValue.test(n);
        System.out.println(n);

        int m = callByValue.test2(n);
        System.out.println(m);

        // call by reference
        Item item = new Item(1L, "간장떡뽁이", 7400);
        CallByReference callByReference = new CallByReference();
        callByReference.test(item);

        int[] arr = {1,2,3,4,5};
        callByReference.test2(arr);
        System.out.println(Arrays.toString(arr));

        callByReference.test4(n, item);

    }
}
