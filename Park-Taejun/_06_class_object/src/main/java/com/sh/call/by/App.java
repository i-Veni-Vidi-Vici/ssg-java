package com.sh.call.by;

import java.util.Arrays;

/**
 * <pre>
 * call bt value
 * -매개인자가 기본형인 경우 해당
 * - 실제 리터럴이 복사되어 처리
 * call by reference
 * - 매개인자가 참조형인 경우 해당
 * - 객체 주소값이 복사되어 처리
 * </pre>
 */
public class App {
    public static void main (String[] args){
        // call by value
        int n = 10;
        CallByVallue callByVallue = new CallByVallue();
        callByVallue.test(n);
        System.out.println(n); //10

        // call by value 리턴값 확인
        int m = callByVallue.test2(n);
        System.out.println(m);

        // call bt reference
        Item item = new Item(1l,"간장떡볶이", 7000);
        CallByReference callByReference = new CallByReference();
        callByReference.test(item);
        item.print();

        int[] arr = {1, 2, 3, 4, 5};
        callByReference.test2(arr);
        System.out.println(Arrays.toString(arr)); // [10, 20, 30 ,40, 50]

        // String은 참조형이지만, 마치 Call by value 처럼 작동한다.
        // - String은 immutable type이다. (값을 변경할 수 없는 타입)
        // - 더하기 연산시 "Hello world " + "Byebye world " 할때, 기존 Hello world를 변경하지 않는다.
        // - "Hello world Byebye world"를 새로 만들어 참조한다.
        String str = "Helloworld";
        callByReference.test3(str);
        System.out.println(str); //Hello wold Byebye world로 안찍힘

        // n 기본형 call by value로 작동함
        // item 참조형 call by reference로 작동
        callByReference.test4(n, item);

        // call by reference 방식에서 원복객체를 수정하지 않으려면
        callByReference.test5(item);
        item.print();
    }
}
