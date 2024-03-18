package com.sh.array.copy;

import java.util.Arrays;

/**
 * 깊은 복사 Deep Copy
 * - heap영역의 배열객체와 동일한 크기, 동일한 값을 가진 배열을 복제한다.
 * - 참조변수에서 배열객체를 공유하지 않는다.
 *
 * 방식 4가지
 * 1. 직접 복제하기
 * 2. object#clone()
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
        int[] arr = {10,20,30};
        int[] arr2 = new int[arr.length]; // 동일한 크기

        // 값 복사
        for(int i=0;i<arr.length;i++){
            arr2[i] = arr[i];
        }

        // 값 수정
        arr[1] *= 10; //arr2는 변하지 않는다.

        // hashCode값 비교
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());


        // 값 출력
        print(arr);
        print(arr2);
    }

    /**
     * Object#clone()
     */
    public void test2(){
        int[] arr = {5,6,7};
        int[] arr2 = arr.clone();
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        print(arr);
        print(arr2);

    }

    /**
     * System.arraycopy(src,srcPosition,dest,destPosition,length): void
     * - src배열의 srcPosition인덱스부터 dest배열의 destPosition인덱스로 length개 복사
     */
    public void test3(){
        int[] arr = {10,20,30,40,50};
        int[] arr2 = new int[arr.length]; // 동일한 크기의 배열 생성

        System.arraycopy(arr, 0,arr2,0,arr.length);

        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        print(arr);
        print(arr2);

        // 일부 복제
        int[] arr3=new int[3];
        System.arraycopy(arr,2,arr3,0,3);
        print(arr3);
    }

    /**
     * Arrays.copyOf(src, length):dest   dest는 반환값
     */
    public void test4(){
        int[] arr ={3,4,5,6,7};
        int[] arr2 = Arrays.copyOf(arr,arr.length); // 0번지부터 length개 복사
        int[] arr3 = Arrays.copyOf(arr,3);
        print(arr);
        print(arr2);
    }

    /**
     * 향상된 for문(for each문)
     * - 인덱스 엇이 모든 요소에 순차적으로 접근 가능
     *
     * for..each 표현식
     *
     * for(요소를 대입할 변수 : 반복접근객체){
     *      // 반복처리구문
     * }
     */
    public void test5(){
        int[] arr = {5,6,7,8,9};
        for(int n:arr){
            System.out.println(n);
        }
        String[] names = {"홍길동","신사임당","유관순"};
        for(String name:names){
            System.out.println(name);
            //names[i] = "장영실",인덱스를 통한 값쓰기는 지원하지 않는다,
        }
    }

    /**
     * 중첩 for..each문
     */

    public void test6(){
        int[][] arr = {
                {1,2,3,4,5},
                {11,12,13,14,15},
                {11,12,13,14,15}
        };

        // 첫번째 배열 접근(배열 arr에 ar요소로)
        for(int[] ar:arr){
            System.out.println();
            // 두번째 배열 접근 (배열 ar에 n요소로)
            for(int n:ar){
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }

    /**
     * 세 배열 a,b,c를 배열 d로 합쳐봅시다.
     */
    public void test7(){
        int[] a = {1,2,3};
        int[] b = {4,5};
        int[] c = {6,7,8,9,10};
        int[] d = new int[10];

        int start =0;
        System.arraycopy(a,0,d,start, a.length);
        start += a.length; //3
        System.arraycopy(b,0,d,start,b.length);
        start += b.length; //5
        System.arraycopy(b,0,d,start,c.length);

        print(d);
    }
    public void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
