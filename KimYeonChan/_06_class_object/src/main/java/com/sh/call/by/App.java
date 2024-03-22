package com.sh.call.by;

import java.util.Arrays;

/**
 * call by value
 * - 매개인자가 기본형인 경우
 * - 실제 리터널이 복사되어 처리
 * call by reference
 * - 매개인자가 참조형인 경우
 * - 객체 주소값이 복사되어 처리
 */
public class App {
    public static void main(String[] args) {
        // call by value
        CallByValue callByValue = new CallByValue();
        int n = 10;
        callByValue.test(n);
        System.out.println(n);

        // call by value 에서 작업 결과물을 확인하려면 return 값을 활용하면 된다.
        int m = callByValue.test2(n);
        System.out.println(m);

        // call by reference
        Item item = new Item(1L, "tok", 7_400);
        CallByReference callByReference = new CallByReference();
        callByReference.test1(item);
        item.print();

        int[] arr = {1, 2, 3, 4, 5};
        callByReference.test2(arr);
        System.out.println(Arrays.toString(arr));

        // String 은 참조형이지만 마치 Call by value 처럼 작동한다.
        // - String 은 immutable type 이다. (값을 변경할 수 없는 타입)
        // - 더하기 연산시 새로 만들어서 참초 시킨다.
        String str = "Hello world";
        callByReference.test3(str);
        System.out.println(str);

        // n 기본형 call by value 로 작동
        // item 참조형 call by reference 로 작동
        callByReference.test4(n, item);

        callByReference.test5(item);
    }
}
