package com.ssg.test.array.sort;

import java.util.Arrays;

import static com.ssg.test.array.sort.Swap.print;
import static com.ssg.test.array.sort.Swap.swap;

/**
 * 버블정렬
 * - 인접한 두개의 요소를 검사해 정렬하는 방식
 * - 구현은 쉬우나, 정렬속도는 빠르지 않다
 * - 이미 정렬된 데이터를 다시 정렬하는 경우 유용하다.
 * - 바깐반복문은 인덱스가 아닌 반복회수를
 */
public class BubbleSort {
    public void test1() {

        int[] arr={5,4,1,3,2};
        int temp;

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    swap(arr,j,j+1);
                }
                print(arr,i);
            }

        }
        System.out.println(Arrays.toString(arr));

//        for(int i=arr.length-1;i>0;i--)
//        {
//            for(int j=0;j<i;j++)
//            {
//                if(arr[j]>arr[j+1])
//                {
//                    swap(arr,j,j+1);
//                }
//                print(arr,i);
//            }
//        }
//        System.out.println(Arrays.toString(arr));
    }
}
