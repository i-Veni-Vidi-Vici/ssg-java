package com.ssg.test.array.sort;

import java.util.Arrays;

import static com.ssg.test.array.sort.Swap.print;

/**
 * 삽입정렬
 * - 정렬된 배열(왼쪽)에 새로운 요소를 끼워넣는 방식
 * - 두번째 요소부터 비교연산을 시작한다.
 * - 버블정렬의 비교횟수가 많은 단점을 개선한 방식
 * - 정렬자리 수를 따로 temp변수에 담아두었다가 적절한 자리에 삽임.
 */
public class InsertionSort {
    public void test1() {
        int[] arr = {5, 4, 2, 1, 3};

        for (int i = 1; i < arr.length; i++) {

            int temp=i;
            int j;

            for(j=i;j>0;j--)
            {
                //j-1 인덱스값이 temp보다 크다면 j-1인덱스의 값을 j인덱스에 덮어쓴다.
                if(arr[j-1]>temp)
                {
                    arr[j]=arr[j-1];
                    print(arr,i);
                }
                //j-1인덱스 값이 temp보다 작다면, 반복문 중지
                else{
                    print(arr,i);
                    break;
                }
            }

            arr[j]=temp;// 값 삽입
        }
        System.out.println(Arrays.toString(arr));
    }
}
