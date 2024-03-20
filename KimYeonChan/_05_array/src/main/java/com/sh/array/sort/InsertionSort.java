package com.sh.array.sort;

import java.util.Arrays;

import static com.sh.array.sort.Swap.print;

/**
 * 삽입정렬
 * - 정렬된 배열(왼쪽)에 새로운 요소를 끼워 넣는 방식
 * - 두번째 요소부터 왼쪽으로 비교 연산을 시작한다.
 * - 버블 정렬의 비교 횟수가 많은 단점을 개선한 방식
 * - 정렬자리 숫자를 따로 temp 변수에 담아 두었다가 적절한 자리에 삽입
 */
public class InsertionSort {
    public void test1() {
        int[] arr = {5, 4, 1, 3, 2};
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j; // 안쪽 for 문이 끝난 후 변수에 접근하기 위해 미리 선언
            print(arr, i);
            for (j = i; j > 0; j--) {
                // j - 1 인덱스 값이 temp 보다 크다면 j-1인덱스의 값을 j 인덱스에 덮어쓴다.
                if (arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    print(arr, i);
                // j - 1 인덱스 값이 temp 보다 작다면, 반복문 중지
                } else {
                    print(arr, i);
                    break;
                }
            }
            arr[j] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
