package com.sh.call.by;

import java.util.Arrays;

/**
 * <pre>
 * call by value
 *  - 매개인자가 기본형인 경우 해당
 *  - 실제 리터럴이 복사되어 처리
 * call by reference
 * - 매기인자가 참조형인 경우 해당
 * - 객체주소값이 복사되어 처리
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // call by value
        int n = 10;
        CallByValue callByValue = new CallByValue();
        callByValue.test(n); //70
        System.out.println(n); // 10

        // call by value에서 작업결과물을 확인하려면 return값을 활용하면 된다.
        int m = callByValue.test2(n);
        System.out.println(m); //70

        // call by reference
        CallByReference callByReference = new CallByReference();
        Item item = new Item(1L, "간장떡볶이", 7400);
        callByReference.test(item);
        item.print();

        int[] arr = {1, 2, 3, 4, 5};
        callByReference.test2(arr);
        System.out.println(Arrays.toString(arr));

        // String은 참조형이지만, 마치 Call by value처럼 작동한다.
        // - String은 immutable type이다. (값을 변경할 수 없는 타입)
        // - 더하기 연산시 "Hello world" + "Byebye world"할 때, 기존 "Hello world"는 변경하지 않는다.
        // - "Hello world Byebye world"을 새로 만들어 참조한다.

        String str = "Helloworld";
        callByReference.test3(str);
        System.out.println(str); // Hello world Byebye world
        // n 기본형 call by value로 작동
        // item 참조형 call by reference로 작동
        callByReference.test4(n, item);

        // call by reference 방식에서 원본객체를 수정하지 않으려면...
        callByReference.test5(item);
        item.setName("엽기떡볶이");
        item.setPrice(23000);
        item.print();
    }
}
