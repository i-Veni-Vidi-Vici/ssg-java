package com.sh.call.by;

public class CallByReference {
    public void test(Item item) {
          item.setName("마라로제떡볶이");
          item.setPrice(12300);
    }


    public void test2(int[] arr) {
    }

    public void test3(String str) {
        str += "";
    }

    public void test4(int n, Item item) {
    }

    public void test5(Item item) {
        item = new Item(item);          // 복사 생성자 호출하여 객체를 복사한다.
        item.setName("엽기떡볶이");
        item.setPrice(25000);
    }
}
