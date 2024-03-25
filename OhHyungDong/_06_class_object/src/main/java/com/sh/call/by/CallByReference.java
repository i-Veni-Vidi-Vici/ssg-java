package com.sh.call.by;

public class CallByReference {
    public void test(Item item) {

        item.setName("마라 로제 떡볶이");
        item.setPrice(12300);
    }

    public void test2(int[] arr) {
        for(int i = 0; i<arr.length; i++){
            arr[i] *= 10;
        }
    }

    public void test3(String str) {
        str += "bye";
    }

    public void test4(int n, Item item)
    {

    }

    public void test5(Item item) {
        item = new Item(item);//복사 생성자
        item.setName("엽기 떡볶이");
        item.setPrice(25000);
    }
}
