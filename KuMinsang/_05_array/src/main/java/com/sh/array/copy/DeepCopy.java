package com.sh.array.copy;

import java.util.Arrays;

/**
 * 깊은 복사 deep copy
 * - 힙 영역의 배열 객체와 동일한 크기, 동일한 값을 가진 배열을 복제한다.
 * - 참조변수에 배열 객체를 공유하지 않는다
 *
 * 박시 4가지
 * 1. 직접 복제하기
 * 2. object#clone()
 * 3. System.arraycopy()
 * 4. Arrays.copyOf
 *
 */
public class DeepCopy {
    /**
     * 직접 복제하기
     * 1. 동일한 크기의 배열 생성
     * 2. 인덱스별로 동일한 값 복사
     */
    public void test1(){
        int[] arr = {10,20,30};
        int[] arr2 = new int[arr.length];   //동일한 크기

        // 값 복사
        for(int i = 0; i<arr.length; i++){
            arr2[i]=arr[i];
        }

        //값 수정
        arr[1] *= 10;

        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        // 값 출력
        print(arr);
        print(arr2);
    }

    /**
     * String#clone()
     */
    public void test2(){
        int[] arr = {10,20,30};
        int[] arr2 = arr.clone();   //동일한 크기 복사

        //값 수정
        arr[1] *= 10;

        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        // 값 출력
        print(arr);
        print(arr2);
    }

    /**
     * System.arraycopy(src, srcPosition, dest, destPosition, lenth): void
     * - src배열의 srcPosition인덱스부터 length개의 값을 복사하여 dest배열의 destPosition인덱스로 복사
     */
    public void test3(){
        int[] arr = {10,20,30,40,50};
        int[] arr2 = new int[arr.length];   //동일한 length크기 복사

        //복사
        //System.arraycopy(arr, 0, arr2, 0, arr.length);
        System.arraycopy(arr, 0, arr2, 1, arr.length-2);

        //값 수정
        //arr[1] *= 10;

        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        // 값 출력
        print(arr);
        print(arr2);
    }

    /**
     * Arrays.copyOf(src, length):dest
     */
    public void test4(){
        int[] arr = {10,20,30,40,50};
        int[] arr2 = Arrays.copyOf(arr, arr.length);   //length크기 복사

        //복사
        //값 수정
        arr[1] *= 10;

        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        // 값 출력
        print(arr);
        print(arr2);
    }

    /**
     * 향상된 for문(for each문)
     * - index 없이 모든 요수에 순차적으로 접근 가능
     * for.each 표현식
     * for(요소 : 반복접근객체){
     *  //반복 처리 구문
     * }
     *
     */
    public void test5(){
        int[] arr = {5,6,7,8,9,};
        for(int n: arr){
            System.out.println(n);
        }
        //String[] names = {"홍길동", "신사임당", "유관순"};
    }

    /**
     * 중첩 for each
     *
     */
    public void test6(){
        int[][] arr = {
                {1, 2, 3, 4, 5,},
                {11, 12, 13, 14, 15},
                {101, 102, 103, 104, 105}
        };

        for(int[] k: arr){
            for(int n : k){
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }

    /**
     * 세 배열 a,b,c를 배열d로 합쳐봅시다
     */
    public void test7(){
        int[] a = {1,2,3};
        int[] b = {4,5};
        int[] c = {6,7,8,9,10};
        int[] d =new int[10];
        System.arraycopy(a, 0, d, 0, a.length);
        System.arraycopy(b, 0, d, a.length, b.length);
        System.arraycopy(c, 0, d, a.length+b.length, c.length);

        print(d);


    }



    public void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
