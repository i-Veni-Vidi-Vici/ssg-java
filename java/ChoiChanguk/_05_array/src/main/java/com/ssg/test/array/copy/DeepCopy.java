package com.ssg.test.array.copy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 깊은 복사 Deep Copy
 * - heap영역의 배열객체와 동일한 크기, 동일한 값을 가진 배열을 복제한다.
 * - 참조변수에서 배열객체를 공유하지 않는다.
 *
 * 방식 4가지
 * 1. 직접 복제하기
 * 2. Object#clone()
 * 3. System.arraycopy()
 * 4. Arrays.copyOf()
 *
 */
public class DeepCopy {
    /**
     * 직접 복제하기
     * 1. 동일한 크기의 배열 생성
     * 2. 인덱스별로 동일한 값 복사
     */
    public void test1() {
        int[] arr={10,20,30};
        int[] arr2=new int[arr.length];

        for(int i=0;i<arr.length;i++)
        {
            arr2[i]=arr[i];
        }

        // 값 출력
        print(arr);
        System.out.printf("\n");
        print(arr2);
    }



    /**
     * Object#clone()
     * #쓰는건 non=static메소드
     */
    public void test2(){

        int[] arr={5,6,7};
        int[] arr2=arr.clone();

        print(arr);
        print(arr2);
    }

    /**
     * System.arraycopy(src, srcPosition, dest, destPosition, length) void
     * - scr배열의 srcPosition인덱스부터 dest배열의 destPosition 인덱스로 length개 복사해주세요
     */
    public void test3(){

        int[] arr={10,20,30,40,50};
        int[] arr2=new int[arr.length];// 동일한 크기의 배열 생성

        System.arraycopy(arr,0,arr2,0,arr.length);

        //일부 복제
        int[] arr3=new int[arr.length];
        System.arraycopy(arr,0,arr3,0,2);

        print(arr);
        print(arr2);
        print(arr3);


    }


    /** ':dest'<-반환값이란 뜻이다
     * Arrays.copyOf(src, length):dest
     */
    public void test4() {
        int[] arr={5,4,6,8,7};
        int[] arr2= Arrays.copyOf(arr,arr.length);//0번지부터 복사
        int[] arr3= Arrays.copyOf(arr,3);//0번지부터 복사

        print(arr2);
        print(arr3);
    }


    /**
     * 향상된 for문(for each문)
     * - 인덱스 없이 모든 요소에 순차적으로 접근가능
     * <p>
     * for..each 표현식
     * <p>
     * for(요소를 대입할 변수 : 반복접근객체{
     * //반복처리구문
     * }
     *
     * @param
     */
    public void test5() {
        int[] arr={5,6,7,8,9};
        for(int n:arr)
        {
            System.out.printf(" %d",n);
        }

        String[] names = {"홍길동", "신사임당", "유관순"};
        for(String s:names)
        {
            System.out.printf(" %s ",s);
            //names[i] :"장영실", 인덱스를 통한 값쓰기는 지원하지 않는다.
        }
    }

    /**
     * 중첩 for..each문
     *
     */
    public void test6()
    {
       int[][] arr={{1,2,3,4,5},{135,321354,335354},{654,456,987}} ;
       for(int[] n:arr)
       {
           for(int s:n)
           {
               System.out.printf(" %d",s);
           }
       }
    }

    /**
     * 세 배열 a,b,c배열 d로합치기
     *
     * @param
     */
    public void text7() {

        int[] arr = {1, 2, 3};
        int[] arr1 = {4, 5};
        int[] arr2 = {6, 7, 8, 9, 10};
        int[] arr4 = new int[arr.length + arr1.length + arr2.length];

        int start = 0;
        System.arraycopy(arr, 0, arr4, start, arr.length);

        start = arr1.length;
        System.arraycopy(arr1, 0, arr4, start, arr1.length);

        start = arr2.length;
        System.arraycopy(arr2, 0, arr4, start, arr2.length);
        print(arr4);

    }

    public void print(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.printf(" %d",arr[i]);
        }
        System.out.printf("\n");
    }
}
