package com.sh.call.by;

public class CallByReference {
    public void test(Item item) {
     item.setName("마라로제떡볶이");
     item.setPrice(7800);
    }
    public void test2(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=arr[i]*10;
        }
    }

    public void test3(String str) {
        str+="i want go home";
    }
    public void test4(int a, Item item)
    {

    }

    public void test5(Item item) {
        item=new Item(item);
        item.setName("엽기떡볶이");;
        item.setPrice(25000);
    }
}
