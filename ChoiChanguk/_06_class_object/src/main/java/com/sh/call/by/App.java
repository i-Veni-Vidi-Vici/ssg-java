package com.sh.call.by;

import java.util.Arrays;

/**
 * call by value
 * - 매개인자가 기본형인 경우 해당
 * - 실제 리터럴이 복사되어 처리
 *
 * call by reference
 *  - 매개인자가 참조형인 경우 해당
 *  - 객체 주소값이 복사되어 처리
 */

public class App {
    public static void main(String[] args) {
        // call by value
        CallByValue callByValue=new CallByValue();
        int n=10;
        callByValue.test(n);
        //System.out.println(n);

        //call by value쓰고 싶으면 리턴값을 받으면 된다
        int m = callByValue.test2(n);


        // call by reference
        Item item = new Item(1L, "떡볶이", 5600);

        CallByReference callByReference=new CallByReference();
        callByReference.test(item);
        //item.print();

        int[] arr = {1, 2, 3, 4, 5};
        callByReference.test2(arr);
        //System.out.println(Arrays.toString(arr));

        // string은 참조형이지만, 마치 call by value처럼 작동한다.
        // - string은 immutable type이다. (값을 변견할 수 없는 타입)
        // - 더하기 연산시 "hello world" + "i want go home"
             //기존 hello world i want go home" 새로 만들어서 참조한다
        String str="helloworld";
        callByReference.test3(str);
        //System.out.println(str);

        //n=기본형 = value로
        //item = 객체 = 참조형 = reference
        callByReference.test4(n,item);

        //call by reference 방식에서a 원본객체를 수정하지 않으려면
        //temp 복제를 넣어놓는다
        callByReference.test5(item);

    }
}
