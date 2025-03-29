package com.sh.array.copy;


import com.sh.array.Array2;

import java.util.Arrays;

/**
 * 깊은복사(Deep copy)
 * - heap 영역의 배열객체와 동일한 크기, 동일한 값을 가진 배열을 복제한다.
 * - 참조변수에서 배열객체를 공유하지 않는다.
 *
 * 방식
 * 1. 직접복제
 * 2. Object#clone()
 * 3. System.arraycopy()
 * 4. Arrays.copyOf()
 */
public class DeepCopy {
    /**
     * 직접복제
     * 1. 동일한 크기의 배열 생성
     * 2. 인덱스별로 동일한 값 복사
     */

    public void test1(){
        int[] arr = {10, 20, 30};
        int[] arr2 = new int[arr.length];

        //값 출력
        printArr(arr);
        printArr(arr2);

        //값 복사
        for(int i =0; i< arr.length; i++){
            arr2[i] = arr[i];
        }

        printArr(arr);
        printArr(arr2);

        //값 수정
        arr[1] *=10;

        printArr(arr);
        printArr(arr2);

        //hashcode 비교
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());
    }

    public void printArr(int[] arr){
        for(int i=0; i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    /**
     * Object#clone()
     */
    public void test2(){
        int[] arr = {5,6,7};
        int[] arr2 = arr.clone();

        printArr(arr);
        printArr(arr2);

        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

    }
    /**
     * System.arraycopy(src, srcPosition, dest, destPosition, length): void
     * - src배열의 srcPosition 인덱스부터 dest배열의 destPosition 인덱스로 length 만큼 복사
     */

    public void test3(){
        int[] arr = {10,20,30,40,50};
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        printArr(arr);
        printArr(arr2);

        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());
    }

    /**
     * Arrays.copyOf(src, length): dest
     */
    public void test4(){
        int[] arr ={3,4,5,6,7};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr,3);//index 0부터 3개 복사
        printArr(arr);
        printArr(arr2);
        printArr(arr3);
    }

    /**
     * 향상된 for문
     * - 인덱스 없이 모든 요소에 순차적으로 접근
     * for(요소를 대입할 변수 : 반복접근객체(배열)){
     *     //반복 수행문
     * }
     */
    public void test5(){
        int[] arr = {5,6,7,8,9};
        for(int val : arr){
            System.out.println("val = " + val);
        }
        String[] names = {"김홍현", "이홍현", "박홍현"};
        for(String name: names){
            System.out.println(name);
            //배열의 값 변경은 불가
        }

    }

    /**
     * 중첩 for each문
     */
    public void test6(){
        int[][] arr = {
                {1,2,3,4,5},
                {11,12,13,14,15},
                {101,102,103,104,105}
        };
        for(int[] inner_arr: arr){
            for(int val : inner_arr){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }

    public void test7(){
        int[] a = {1,2,3};
        int[] b = {4,5};
        int[] c = {6,7,8,9,10};
        int[] d = new int[10];
        System.arraycopy(a, 0, d, 0, a.length);
        System.arraycopy(b, 0, d, a.length, b.length);
        System.arraycopy(c, 0, d, a.length+b.length, c.length);
        printArr(d);
    }
}
