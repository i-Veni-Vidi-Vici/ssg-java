package com.sh.array.copy;

import java.util.Arrays;

/**
 * 깊은 복사 Deep Copy
 * - heap영역의 배열객체와 동일한 크기, 동일한 값을 가진 배열을 복제한다.
 * - 참조변수에서 배열객체를 공유하지 않는다.
 *
 * 방식 4가지
 * 1. 직접 복제하기
 * 2. Objext#clone()
 * 3. System.arraycopy()
 * 4. Arrays.copyOf()
 */

public class DeepCopy {
    /**
     * 직접 복제하기
     * 1. 동일한 크기의 배열 생성
     * 2. 인덱스별로 동일한 값 복사
     */
    public void test1() {
        int[] arr = {10, 20, 30};
        int[] arr2 = new int[arr.length]; // 동일한 크기

        // 값복사
        for(int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }

        // 값수정
        arr[1] *= 10;

        // hashCode값 비교
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        // 값출력
        print(arr);
        print(arr2);
    }

    /**
     * Objext#clone()
     */
    public void test2() {
        int[] arr = {5, 6, 7};
        int[] arr2 = arr.clone();

        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        print(arr);
        print(arr2);
    }

    /**
     * System.arraycopy(src, scrPosition, dest, destPosition, lenghth) : void(리턴값이 없다)
     * - src배열의 srcPosition인덱스부터 dest배열의 destPosition인덱스로 length개 복사해주세요.라는 의미
     */
    public void test3() {
        int[] arr = {10, 20, 30, 40, 50};
        int[] arr2 = new int[arr.length]; // 동일한 크기의 배열 생성

        System.arraycopy(arr, 0, arr2, 0, arr.length);

        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        print(arr);
        print(arr2);

        // 일부 복제
        int[] arr3 = new int[3];
        System.arraycopy(arr, 2, arr3, 0, 3);
        print(arr3);
    }

    /**
     * Arrays.copyOf(src, legnth) : dest(복제된 값을 반환하는 것)
     */
    public void test4() {
        int[] arr = {3, 4, 5, 6, 7};
        int[] arr2 = Arrays.copyOf(arr, arr.length); // 0번지부터 length개 복사
        int[] arr3 = Arrays.copyOf(arr, 3);

        print(arr);
        print(arr2);
        print(arr3);
    }

    /**
     * 향상된 for문(for each문)
     * - 인덱스 없이 모든 요소에 순차적으로 접근 가능
     *
     * for..each 표현식
     *
     * for(요소를 대입할 변수 : 반복접근객체) {
     *     // 반복처리구문
     * }
     */

    public void test5() {
        int[] arr = {5, 6, 7, 8, 9};
        for(int n : arr) {
            System.out.println(n);
        }
        String[] names = {"홍길동", "신사임당", "유관순"};
        for(String each : names) {
            System.out.print(each);
//            names[i] = "장영실"; 인덱스를 통한 값쓰기는 지원하지 않는다.
        }
    }

    /**
     * 중첩 for..each문
     */
    public void test6(){
        int[][] arr = {
             {1, 2, 3, 4, 5},
             {11, 12, 13, 14, 15},
             {101, 102, 103, 104, 105}
        };
        // 첫번째 배열 접근
        for(int[] ar : arr) {
            // 두번째 배열 접근
            for(int n : ar) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }


    public void print(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 세 배열 a, b, c를 배열 d로 합쳐봅시다.
     */
    public void test7() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5};
        int[] c = {6, 7, 8, 9, 10};
        int[] d = new int[10];

        int start = 0;
        System.arraycopy(a, 0, d, start, a.length);
        start += a.length; // 3
        System.arraycopy(b, 0, d, start, a.length);
        start += b.length; // 5
        System.arraycopy(c, 0, d, start, a.length);

        print(d);
    }
}
