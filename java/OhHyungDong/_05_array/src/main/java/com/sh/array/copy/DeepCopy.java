package com.sh.array.copy;

import java.util.Arrays;

/**
 * 깊은 복사 Deep Copy
 * - heap 영역의 배열객체와 동일한 크기, 동일한 값을 가진 배열을 복제한다.
 * - 참조변수에서 배열객체를 공유하지 않는다
 *
 * 방식 4가지
 * 1. 직접 복제
 * 2. Object#clone()
 * 3. System.arraycopy()
 * 4. Arrays.copyOf()
 */
public class DeepCopy {
    /**
     * 직접 복제하기
     * 1. 동일한 크기의 배열 생성
     * 2. 인덱스별로 동일한 값 복사
     */

    public void test1()
    {
        int[] arr = {10, 20, 30};
        int[] arr2 = new int[arr.length]; //동일한 크기의 배열 생성

        //값 복사
        for(int i = 0; i< arr.length; i++)
        {
            arr2[i] = arr[i];
        }
        //값 수정
        arr[1] *= 10;

        //hash코드 값 비교
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());
        //값 출력
        print(arr);
        System.out.println();
        print(arr2);
    }

    /**
     * Object#clone()
     */
    public void test2()
    {
        int[] arr = {5,6,7};
        int[] arr2 = arr.clone();
        print(arr);
        print(arr2);
    }

    /**
     * System.arraycopy(src,srcPosition, dest, destPostion, length): void
     * - src 배열의 srcPosition인덱스부터 dest배열의 destPositon인덱스로 length개 복사해주세요
     */
    public void  test3()
    {
        int[] arr = {10,20,30,40,50};
        int[] arr2 = new int[arr.length]; //동일한 크기 배열생성

        System.arraycopy(arr,0,arr2,0,arr.length);

        print(arr);
        print(arr2);

        //일부 복제
        int[] arr3 = new int[3];

        System.arraycopy(arr,0,arr3,0,arr3.length);
        print(arr3);
    }

    /**
     * Arrays.copyOf(src,length) : dest
     */
    public void test4()
    {
        int[] arr = {3,4,5,6,7};
        int[] arr2 = Arrays.copyOf(arr,arr.length); // 0번지부터 length개 복사
        int[] arr3 = Arrays.copyOf(arr,3);

        print(arr);
        print(arr2);
        print(arr3);
    }

    /**
     * 향상된 for문(for each문)
     * - 인덱스 없이 모든 요소에 순차적으로 접근이 가능함.
     *
     *
     * for..each 표현식
     * for(요소를 대입할 변수  : 반복 접근할 객체){
     *     (반복처리구문)
     * }
     */
    public void test5()
    {
        int[] arr = {5, 6, 7, 8};
        for(int x : arr)
        {
            System.out.println(x);
        }
        String[] names = {"홍길동", "신사임당", "유관순 "};
        for(String s : names){
            System.out.println(names);
            //name[i] = "장열실"; 인덱스를 통한 값쓰기는 지원하지 않는다.
        }
    }

    /**
     *중첩for-each문
     *
     */
    public void test6(){
        int[][] arr = {
                {1,2,3,4,5},
                {11,12,13,14,15},
                {101,102,103,104,105},
        };

        for(int[] x : arr){
            for(int n : x)
            {
                System.out.println(n + " ");
            }
            System.out.println();
        }

    }

    /**
     * 세 배열 abc 를 배열 d로 합치기
     */
    public void test7()
    {
        int[] a = {1,2,3};
        int[] b = {4,5};
        int[] c = {6,7,8,9,10};
        int[] d = new int[10];

        int start = 0;
        System.arraycopy(a,0,d,0,a.length);
        start += a.length;
        System.arraycopy(b,3,d,3,b.length);
        start += a.length;
        System.arraycopy(c,5,d,5,c.length);

       print(d);

    }



    public int[] print(int[] arr)
    {
        for(int i = 0; i< arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }

        return arr;
    }
}
