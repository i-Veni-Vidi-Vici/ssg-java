package com.sh.array.copy;

import java.util.Arrays;

public class DeepCopy {


    public void test1() {
        int[] arr = {10, 20, 30};
        int[] arr2 = new int[arr.length]; // 동일한 크기

        // 값 복사
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }

        // 값 수정
        arr[1] *= 10;

        // hashCode 값 비교
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());
        // 값 출력
        print(arr);
        print(arr2);
    }

    /**
     * Object#clone()
     */

    public void test2() {
        int[] arr = {5, 6, 7};
        int[] arr2 = arr.clone();

        print(arr);
        print(arr2);
    }

    /**
     * System.arraycopy(src, srcPosition, dest, destPositon, length): void
     * <p>
     * 제일 기능이 많은 메서드
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

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * Arrays.copyOf(src, length): dest
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
     * 향상된 for문 (for each문)
     * - 인덱스 없이 모든 요소에 순차적으로 접근 가능
     * for..each 표현식
     * <p>
     * for(요소 : 반복접근객체){
     * // 반복처리구문
     * }
     */

    public void test5() {
        int[] arr = {5, 6, 7, 8, 9};
        for (int n : arr) {
            System.out.println(n);
        }

        // 보통 단수 : 복수 형태로 사용
        String[] names = {"홍길동", "신사임당", "유관순"};
        for (String name : names) {
            System.out.println(name);
//            name[i] = "장영실"; // 인덱스를 통한 값쓰기는 지원하지 않음
        }
    }

    /**
     * 중첩 for, each문
     */
    public void test6() {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {11, 12, 13, 14, 15},
                {101, 102, 103, 104, 105}
        };

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    /**
     * 세 배열 a,b,c 를 배열d로 합치기
     */
    public void test7() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5};
        int[] c = {6, 7, 8, 9, 10};
        int[] d = new int[10];

        System.arraycopy(a,0, d, 0, a.length);
        System.arraycopy(b,0, d, a.length, b.length);
        System.arraycopy(c,0, d, a.length+ b.length, c.length);

        print(d);
    }
}
