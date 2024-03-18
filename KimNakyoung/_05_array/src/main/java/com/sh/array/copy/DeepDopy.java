package com.sh.array.copy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 1. 직접 복제하기
 * 2. Object#clone()
 * 3. System.arraycopy()
 * 4. Arrays.copyOf()
 *
 */

public class DeepDopy {

    /**
     * 직접 복제하기 (원본 유지)
     * 1. 동일한 크기의 배열 생성
     * 2. 인덱스별로 동일한 값 복사
     *
     */


    public void test1(){
        int[] arr = {10,20,30};
        int[] arr2 = new int[arr.length]; // 동일한 크기

        //값복사
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i]; //공간이 먼저
        }
        arr[1] *= 10;
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        //값출력
        print(arr);
        print(arr2);

    }


    /**
     *
     * Object#colone() #은 non-static 메서드
     */
    public void test2(){
        int[] arr = {5,6,7};
        int[] arr2 = arr.clone(); // 객체.~() 이렇게 호출
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        print(arr);
        print(arr2);

    }

    /**
     *
     * System.arraycopy(src, srcPosition, dest, destPosition, length): void
     * - src 배열의 srcPosition인덱스부터 dest 배열의 destPosition인덱스로 length개 복사!
     *
     */

    public void test3(){
        int[] arr = {10,20,30,40,50};
        int[] arr2 = new int[arr.length]; // 동일한 크기의 배열 생성 !!

        System.arraycopy(arr,0,arr2,0,arr.length); // 깊은 복사
        // 왜 이걸 쓰냐? 일부 복제 하기 위해서

        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        print(arr);
        print(arr2);

        int[] arr3 = new int[3];
        System.arraycopy(arr,2,arr3,0,3);
        // arr를 복사할껀데 인덱스 2부터 가져올껀데, 복사배열은 arr3이고 복사배열에다가 0번지부터 넣을꺼야 /가져올 복사할 배열에서 3개를 가져올꺼야

    }

    public void test4(){

        int[] arr = {3,4,5,6,7};
        int[] arr2 = Arrays.copyOf(arr,arr.length); // 0번지부터 length개 복사
        int[] arr3 = Arrays.copyOf(arr, 3); // 0번지부터 3개! 복사 0,1,2
        print(arr);
        print(arr2);
        print(arr3);
    }

    /**
     *
     * 향상된 for문 ( for each문)
     * - 인덱스 없이 모든 요소에 순차적으로 접근 가능
     *
     * for..each 표현식
     *
     * for(요소를 대입할 변수 : 반복접근객체) {
     *     // 반복처리구문
     * }
     */


    public void test5(){
        int[] arr = {5,6,7,8,9};
        for( int n : arr) {
            System.out.println(n);

        }
        String[] names = {"홍길동", "신사임당","유관순"};
        for(String name :names) {
            System.out.println(name);
        }
        // 보통 꺼낼 배열은 복수고 그걸 담을 변수는 단수로 씀
        // 이건 인덱스가 없어서 name[i] 이런게 안되기때문에 인덱스를 통한 값 쓰기 지원x 그래서 읽기 전용 느낌

    }

    public void test6() {
        int[][] arr = {
                {1,2,3,4,5},
                {11,12,13,14,15},
                {101,102,103,104,105}
        };

        for(int[] ar :arr) {
            for( int j: ar) {
                System.out.println(j + " ");
            }
            System.out.println();
        }
    }

    public void test7(){
        int[] a = {1,2,3};
        int[] b = {4,5};
        int[] c = {6,7,8,9,10};
        int[] d = new int[10];

        int start = 0;
        System.arraycopy(a,0,d,start,a.length);
        start += a.length;
        System.arraycopy(b,0,d,start,b.length);
        start += b.length;
        System.arraycopy(c,0,d,start,c.length);

        print(d);

    }


    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

