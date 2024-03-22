package com.sh.call.by;

public class CallByReference {
    public void test(Item item){
        item.setName("감자튀김");
        item.setId(2L);
        item.setPrice(897897);
    }
    public void test2(int[] arr){
        for(int i =0; i<arr.length; i++){
            arr[i] = i*10;
        }
    }

    public String test3(String str) {
        str += "byebye world";
        return str;
    }


    public void test4(int n, Item item) {

    }

    public void test5(){

    }
}
