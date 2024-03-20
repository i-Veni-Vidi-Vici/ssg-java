package com.sh.array.copy;

import java.util.Arrays;

/**
 * <pre>
 *     깊은 복사 Deep Copy
 *     - heap 영역의 배열 객체와 동일한 크기, 동일한 값을 가진 배열을 복제한다.
 *     - 참조변수에서 배열 객체를 공유하지 않는다.
 *
 *     방식 4가지
 *     1. 직접 복제하기
 *     2. Object#clone()
 *     3. System.arraycopy()
 *     4. Arrays.copyOf()
 * </pre>
 */
public class DeepCopy {

    /**
     * 2. 인덱스별로 동일한 값 복사
     */
    public void test1() {
        int[] arr = {10, 20, 30};
        int[] arr2 = new int[arr.length]; // 동일한 크기

        // 복사
        for(int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }

        // 수정
        arr[1] *= 10;

        // hashCode값 비교
        System.out.println(arr.hashCode());     // 1554547125
        System.out.println(arr2.hashCode());    // 617901222
        // 출력
        print(arr);
        print(arr2);
    }

    /**
     * <pre>
     *     Object#clone() // #은 static 메소드
     * </pre>
     */
    public void test2() {
        int[] arr = {5, 6, 7};
        int[] arr2 = arr.clone();

        // hashCode값 비교
        System.out.println(arr.hashCode());     // 1554547125
        System.out.println(arr2.hashCode());    // 617901222

        // 출력
        print(arr);
        print(arr2);
    }

    /**
     * System.arraycopy(src, srcPosition, dest, destPosition, length): void
     * - src 배열의 srcPosition 인덱스부터, dest 배열의 destPosition 인덱스로 length개 복사
     * - dest 배열 객체 미리 생성되어 있어야 함
     * - 배열 전체가 아닌 일부 복사가 가능함
     */
    public void test3() {
        // 배열 생성
        int[] arr = {10, 20, 30, 40, 50};
        int[] arr2 = new int[arr.length];   // 동일한 크기의 배열 생성

        // 복사
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        // hashCode값 비교
        System.out.println(arr.hashCode());     // 1554547125
        System.out.println(arr2.hashCode());    // 617901222

        // 출력
        print(arr);
        print(arr2);

        // 일부 복제
        int[] arr3 = new int[3];

        System.arraycopy(arr, 2, arr3, 0, 3);

        print(arr3);
    }

    /**
     * Arrays.copyOf(src, length):dest
     * - 0번지부터 length개 복사
     * - 무조건 0번지부터만 가능
     */
    public void test4() {
        int[] arr = {3, 4, 5, 6, 7};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, 3);

        print(arr);
        print(arr2);
        print(arr3);
    }

    /**
     * <pre>
     *     향상된 for문 (for each문)
     *     - 인덱스 없이 모든 요소에 순차적으로 접근 가능
     *     - 일반적으로 변수를 단수, 반복할 객체를 복수형으로 쓴다.
     *     - 인덱스를 통한 값 쓰기는 지원하지 않는다.
     *
     *     for .. each 표현식
     *     for(요소를 대입할 변수 : 반복 접근 객체) {
     *         // 반복 실행할 문장
     *     }
     *
     * </pre>
     */
    public void test5() {
        int[] arr = {5, 6, 7, 8, 9};
        for(int n : arr) {
            System.out.println(n);
        }

        String[] names = {"홍길동", "신사임당", "유관순"};
        for(String name : names) {
            System.out.println(name);
//            names[i] = "장영실"; // 인덱스를 통한 값 쓰기는 지원하지 않는다.
        }
    }

    /** 중첩 for..each문
     *
     */

    public void test6() {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {11, 12, 13, 14, 15},
                {101, 102, 103, 104, 105}
        };

        for(int[] k : arr) {
            for(int n : k) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    /**
     * <pre>
     *     세 배열 a, b, c를 배열 d로 합쳐봅시다.
     * </pre>
     */
    public void test7() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5};
        int[] c = {6, 7, 8, 9, 10};
        int[] d = new int[10];

        int start = 0;              // destSrc 배열의 복사 받을 시작 인덱스 관리 변수
        System.arraycopy(a, 0, d, start, a.length);
        start += a.length;
        System.arraycopy(b, 0, d, start, b.length);
        start += b.length;
        System.arraycopy(c, 0, d, start, c.length);

        // 출력
        print(d);
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
