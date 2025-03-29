package com.sh.call.by;

/**
 * call by value
 *  - 매개인자가 기본형
 *  - 실제 리터럴이 복사되어 처리
 *
 * call by reference
 *  - 매개인자가 참조형
 *  - 객체 주소값 복사되어 처리
 */
public class App {
    public static void main(String[] args) {
        int i = 1;
        CallByValue.test(1);
        System.out.println("i = " + i);
        int[] arr = {1,2,3};
        CallByReference.test(arr);
        System.out.println("arr[0] = " + arr[0]);
        


    }
}
