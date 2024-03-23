package com.sh.call.by;

public class CallByReference {

    public void test1(Item item) {
        item.setName("tokTok");
        item.setPrice(12_300);
    }


    public void test2(int[] arr) {
        arr[0] *= 10;
    }

    public void test3(String str) {
        str += "Bye world";
    }

    public void test4(int n, Item item) {
        n *= 10;
        item.setName("tokTok");
        item.setPrice(12_300);
    }

    public void test5(Item item) {
        item = new Item(item); // 복사 생성자
        item.setName("tokTokTok");
        item.setPrice(12_300_000);
    }
}
