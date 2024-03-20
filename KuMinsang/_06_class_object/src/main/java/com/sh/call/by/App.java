package com.sh.call.by;

import java.util.Arrays;

/**
 * <pre>
 *     call by value
 *     - 매개인자가 기본형인 경우 해당
 *     - 실제 리터럴이 복사되어 처리
 *     call by reference
 *     - 매개인자가 참조형인 경우 해당
 *     - 주소 값이 복사되어 처리
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        int n =10;
        CallByValue callbyvalue = new CallByValue();
        callbyvalue.test(n);
        System.out.println(n);

        // call by reference
        Item item = new Item(1L, "간장떡", 8000);
        CallByReference callByReference = new CallByReference();
        callByReference.test(item);
        item.print();

        int[] arr = {1,2,3,4,5};
        callByReference.test2(arr);
        System.out.println(Arrays.toString(arr));

        //String은 참조형이지만, 마치 call by value처럼 작동한다
        // -String은 immutable type이다. 값을 변경할수 없는 타입
        // -더하기 연산시 "Hello world" + "ByeByeWorld"를 하면 새로운 HelloWorldByeByeWorld를 생성하는것
        String str = "Hello world";
//        callByReference.test3(str);
        str = callByReference.test3(str);   //이렇게 return 해주면 str이 가르키던 주소가 바뀜
        System.out.println(str);

        //n 기본형 call by value로 작동
        //item 참조형 call by reference로 작동

        //call by value에서 작업값을 확인하려면 return 해야한다
        n = callbyvalue.test2(n);

        //call by reference 방식에서 원복 객체를 수정하지 않으려면



    }
}
