package com.sh.call.by;

import java.util.Arrays;

/**
 * <pre>
 * call by value
 * - 매개인자가 기본형인 경우 해당
 * - 실제 리터럴이 복사되어 처리
 *
 * call by reference
 * - 매개인자가 참조형인 경우 해당
 * - 객체 주소값이 복사되어 처리
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        // call by value
        int n = 10;
        CallByValue callByValue = new CallByValue();
        callByValue.test(n); // 변수 n이 아닌 n에 담긴 값(10)이 대입됨
        System.out.println(n); // 10 / 변경X

        // call by value에서 작업결과물을 확인하려면 return 값을 활용하면 됨
        int m = callByValue.test2(n);
        System.out.println(m);

        // call by reference
        Item item = new Item(1L, "간장떡볶이", 7400);
        CallByReference callByReference = new CallByReference();
        callByReference.test(item); // 괄호에 item의 주소값이 들어감
        item.print(); // 1, 마라로제떡볶이, 12300

        int[] arr = {1, 2, 3, 4, 5};
        callByReference.test2(arr);
        System.out.println(Arrays.toString(arr)); // [10, 20, 30, 40, 50]

        // String은 참조형이지만 마치 call by value처럼 작동
        // - String은 immutable type (값을 변경할 수 없는 타입)
        // - 더하기 연산시 "Hello world" + "Byebye world"할 때, 기존 "Hello world" 변경X
        // - "Hello world Byebye world"를 새로 만들어 참조함
        String str = "Hello world";
        callByReference.test3(str);
        System.out.println(str); // Hello world / test3에서 추가한 내용이 추가되지 않음

        // n은 기본형 -> call by value로 작동
        // item은 참조형 ->  call by reference로 작동
        callByReference.test4(n, item);

        // call by reference 방식에서 원본 객체를 수정하지 않으려면
        callByReference.test5(item);
        item.print();
    }
}
