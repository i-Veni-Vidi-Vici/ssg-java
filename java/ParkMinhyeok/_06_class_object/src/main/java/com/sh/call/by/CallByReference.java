package com.sh.call.by;

public class CallByReference {
    public void test(Item item) {
        item.setName("마라로제");
        item.setPrice(10000);
    }
    public void test2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 10;
        }
    }

    public void test4(int n, Item item) {

    }
}
