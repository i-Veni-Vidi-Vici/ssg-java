package com.sh.array.copy;

import java.util.Arrays;

/**
 * 깊은 복사 Deep Copy
 * - heap 영역의 배열객체와 동일한 크기, 동일한 값을 가진 배열을 복제한다.
 * - 참조변수에서 배열객체를 공유하지 않는다.
 * 방식 4가지
 * 직접 복제하기
 * 1. Object#clone()
 * 2. System.arraycopy()
 * 3. Arrays.copyOf()
 */
public class DeepCopy {
    // 1. 직접 복제하기
    //    a. 동일한 크기의 배열생성
    //    b. 인덱스별로 동일한 값 복사
    public void test1() {
        int[] arr1 = {10, 20, 30};
        int[] arr2 = new int[arr1.length];

        // 값 복사
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr1[i];
        }

        // hashCode
        System.out.println(arr1.hashCode());
        System.out.println(arr2.hashCode());

        // 값 출력
        print(arr1);
        print(arr2);

        // 값 수정
        arr1[0] *= 10;
        print(arr1);
        print(arr2);
    }

    /**
     * Object#clone() // #은 non-static 메소드이다.
     */
    public void test2() {
        int[] arr1 = {5, 6, 7};
        int[] arr2 = arr1.clone();

        System.out.println(arr1.hashCode());
        System.out.println(arr2.hashCode());

        print(arr1);
        print(arr2);
    }

    /**
     * System.arraycopy(src, srcPosition, dest, destPosition, length): void
     * - src 배열의 srcPosition 인덱스부터 dest 배열의 destPosition 인덱스로 length 개 복사!
     */
    public void test3() {
        int[] arr1 = {10, 20, 30, 40, 50};
        int[] arr2 = new int[arr1.length]; // 동일한 크기의 배열 생성

        System.arraycopy(arr1, 0, arr2, 0, arr1.length);

        System.out.println(arr1.hashCode());
        System.out.println(arr2.hashCode());

        print(arr1);
        print(arr2);

        // 일부 복제가 가능하다.
        int[] arr3 = new int[3];
        System.arraycopy(arr1, 2, arr3, 0, 3);
        print(arr3);
    }

    /**
     * Arrays.copyOf(src, length): dest
     */
    public void test4() {
        int[] arr1 = {3, 4, 5, 6, 7};
        int[] arr2 = Arrays.copyOf(arr1, arr1.length); // 0번지부터 length 개 복사
        int[] arr3 = Arrays.copyOf(arr1, 3);
        print(arr1);
        print(arr2);
        print(arr3);
    }

    /**
     * 향상된 for 문 (for each 문)
     * - 인덱스없이 모든 요소에 순차적으로 접근 가능
     * for .. each 표현식
     * for (요소를 대입할 변수: 반복접근 객체) {
     *     // 반복 처리 구문
     * }
     * - 인덱스를 통한 값쓰기는 지원하지 않는다.
     */
    public void test5() {
        int[] arr = {5, 6, 7, 8, 9};
        for (int n : arr) {
            System.out.println(n);
        }
        String[] names = {"홍길동", "신사임당", "유관순"};
        for (String name : names) {
            System.out.println(name);
        }
    }

    /**
     * 중첩 foreach 문
     */
    public void test6() {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {11, 12, 13, 14, 15},
                {101, 102, 103, 104, 105},
        };

        for (int[] eachArr : arr) {
            for (int num : eachArr) {
                System.out.print(num + " ");
            }
            System.out.println();
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

        int curIndex = 0;
        System.arraycopy(a, 0, d, curIndex, a.length);
        curIndex += a.length;
        System.arraycopy(b, 0, d, curIndex, b.length);
        curIndex += b.length;
        System.arraycopy(c, 0, d, curIndex, c.length);

        print(d);
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
