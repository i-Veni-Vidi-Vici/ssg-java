package com.sh.array.copy;

import java.util.Arrays;

/**
 * 깊은 복사 Deep Copy
 * - heap 영역의 배열 객체와 동일한 크기, 동일한 값을 가진 배열을 복제한다.
 * - 참조 변수에서 배열 객체를 공유하지 않는다.
 * <p>
 * 방식 4가지
 * 1. 직접 복제하기
 * 2. Object#clone()
 * 3. System.arraycopy()
 * 4. Arrays.copyOf()
 */
public class DeepCopy {
    public void test1() {
        /**
         * 직접 복제하기
         * 1. 동일한 크기의 배열 생성
         * 2. 인덱스별로 동일한 값 복가
         */
        int[] arr = {10, 20, 30};
        int[] arr2 = new int[arr.length]; // 동일한 크기

        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        print(arr);
        print(arr2);
    }

    public void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void test2() {
        int[] arr = {5, 6, 7};
        int[] arr2 = arr.clone();
        print(arr);
        print(arr2);
    }

    /**
     * System.arraycopy(src, srcPosition, dest, destPosition, length): void
     * - src 배열의 srcPosition 인덱스부터 dest 배열의 destPosition 인덱스로 length 개 복사!
     */
    public void test3() {
        int[] arr = {10, 20, 30, 40, 50};
        int[] arr2 = new int[arr.length];

        System.arraycopy(arr, 0, arr2, 0, arr.length);
        print(arr);
        print(arr2);
        // 일부 복제
        int[] arr3 = new int[6];
        System.arraycopy(arr, 2, arr3, 3, 3);
        print(arr3);
    }

    /**
     * Arrays.copyOf(src, length):dest
     */
    public void test4() {
        int[] arr = {3, 4, 5, 6, 7};
        int[] arr2 = Arrays.copyOf(arr, arr.length); // 0 번지 부터 length 개 복사
        print(arr);
        print(arr2);
    }

    /**
     * 향상된 for문 (for each문)
     * - 인덱스 없이 모든 요소에 순차적으로 접근 가능
     * <p>
     * for..each 표현식
     * <p>
     * for(요소를 대입할 변수 : 반복접근객체) {
     * // 반복 처리 구문
     * }
     */
    public void test5() {
        int[] arr = {5, 6, 7, 8, 9};
        for (int n : arr) {
            System.out.println(n);
        }
        String[] names = {"홍길동", "산사임당", "유관순"};
        for (String name : names) {
            System.out.println(name);
        }
    }

    /**
     * 중첩 for..each 문
     */
    public void test6() {
        int[][] arrs = {{1, 2, 3, 4, 5}, {11, 12, 13, 14, 15}, {101, 102, 103, 104, 105}};
        for (int[] arr : arrs) {
            for (int i : arr) {
                System.out.println(i);
            }
        }
    }

    /**
     * 세 배열 a, b, c를 배열 d로 합쳐봅시다.
     */
    public void test7() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5};
        int[] c = {6, 7, 8, 9, 10};
        int[] d = new int[10];

        System.arraycopy(a,0, d, 0, a.length);
        System.arraycopy(b, 0, d, 3, b.length);
        System.arraycopy(c, 0, d, 5, c.length);
//        for (int i : d) {
//            System.out.print(i + " ");
//        }
        System.out.print(Arrays.toString(d) + " ");
    }
}

