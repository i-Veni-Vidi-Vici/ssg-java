package com.sh.array.sort;

import java.util.Arrays;

/**
 * 삽입 정렬
 * - 정렬된 배열(왼쪽)에 새로운 요소를 끼워넣는 방식
 * - 두번째 요소부터 왼쪽으로 비교연산을 시작한다.
 * - 버블 정렬의 비교 횟수가 많은 단점을 개선한 방식
 * - 정렬자리 수를 따로 temp에 담아두었다가 적절한 자리에 삽입
 */
public class InsertionSort {
    public void test(){
        int[] arr = {5,4,2,1,3};
        System.out.println(Arrays.toString(arr));
        // i = 1,2,3,4
        for(int i=0;i<arr.length;i++)
        {
            int temp = arr[i];
            // i=1, j=1
            // i=2, j=2,1
            // i=3, j=3,2,1
            // i=4, j=4,3,2,1
            int j;// 안쪽 for문이 끝난후 변수에 접근하기 위해 미리 선언. 반복문 탈출할때 증감변수의 범위 -1한 값
            for(j = i;j > 0;j--)
            {
                // j-1 인덱스 값이 temp보다 크다면 j-1 인덱스의(왼쪽) 값을 j 인덱스에(오른쪽) 덮어쓴다.
                if(arr[j-1]>temp){
                    arr[j] = arr[j-1];
                    Swap.print(arr, i);
                }
                // j-1 인덱스 값이 temp보다 작다면, 반복문 중지
                else{
                    Swap.print(arr, i);
                    break;
                }

            }
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
