package com.ssg.test.array.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * - 변수의 값교환
 * - 배열쇼로의 값교환
 */
public class Swap {

    public static void print(int[] arr,int i)
    {
            System.out.printf("i=%d arr=%s\n",i, Arrays.toString(arr));
    }
    public static void swap(int[] arr,int i, int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void test1() {
        int a=10;
        int b=20;
        int temp=b;

        temp=a;
        a=b;
        b=temp;

        System.out.printf("%d %d",a,b);
    }

    public void test2() {
        int[] arr={1,2,4,3,5};
        int temp;
        temp=arr[2];
        arr[2]=arr[3];
        arr[3]=temp;

        for(int i=0;i<arr.length;i++)
        {
            System.out.printf("%d ",arr[i]);
        }
    }
}
