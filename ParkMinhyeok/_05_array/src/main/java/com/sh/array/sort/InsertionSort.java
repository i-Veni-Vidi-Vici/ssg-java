package com.sh.array.sort;

import java.util.Arrays;

import static com.sh.array.sort.Swap.print;

/**
 * <pre>
 * - 정렬된 배열(왼쪽)에 새로운 요소를 끼워넣는 방식
 * - 두 번째 요소부터 왼쪽으로 비교 연산을 시작한다.
 * - 버블 정렬의 비교 횟수가 많은 단점을 개선한 방식
 * - 정렬 자리 수를 따로 temp 변수에 담아두었다가 적절한 자리에 삽입
 * </pre>
 */
public class InsertionSort {
    public void test() {
        int[] arr = {5, 4, 2, 1, 3};
        // i = 1, 2, 3, 4
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            // i = 1, j = 1
            // i = 2, j = 2, 1
            // i = 3, j = 3, 2, 1
            // i = 4, j = 4, 3, 2, 1

            int j; // 안쪽 for 문이 끝난 후 변수에 접근하기 위해 미리 선언. 반복문 탈출할 때 증감 변수의 범위 -1 한 값 사용.
            for (j = i; j > 0; j--) {
                // j - 1 인덱스(왼쪽) 값이 temp 보다 크다면 j - 1 인덱스의 값을 j 인덱스에 덮어쓴다.
                if (arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    print(arr, i);
                    System.out.println("j : " + j);
               // j - 1 인덱스 값이 temp 보다 작다면, 반복문 중지
                } else {
                    print(arr, i);
                    System.out.println("break j : " + j);
                    break;
                }
            }
            arr[j] = temp; // 값 삽입
        }
        System.out.println(Arrays.toString(arr));
    }
}
