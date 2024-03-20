package com.sh.call.by;

import java.util.Arrays;

/**
 * call by value
 * -매개인자가 기본형인 경우 해당
 * -실제 리터럴이 복사되어 처리
 * call by reference
 * -매개인자가 참조형인 경우 해당
 * -주소값이 복사되어 처리
 */
public class App {
    public static void main(String[] args) {
        //call by value
        int n= 10;
        CallByValue callByValue = new CallByValue();
        callByValue.test(n);
        System.out.println(n);
        //call by reference
        Item item = new Item(1L,"간장떡뽁이",7400);
        CallByReference callByReference = new CallByReference();
        callByReference.test(item);
        item.print();
        int[] arr={1,2,3,4,5};
        callByReference.test2(arr);
        System.out.println(Arrays.toString(arr));
        //String은 참조형이지만, 마치 call by value처럼 작동한다.
        //-string은 immutable type 이다. (값을 변경할 수 없는 타입)
        //-더하기 연산시 "hellow world" + "byebye world"
        String str = "Helloworld";
        callByReference.test3(str);
        System.out.println(str);
        //n 기본형 call by value로 작동
        //item 참조형 call by reference로 작동
        callByReference.test4(n,item);
        callByReference.test5(item);
        item.print();
    }
}
