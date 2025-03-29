package com.sh.multi.demention;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 다차원배열
 * - 2차원 이상의 배열을 의미
 * - 배열 인덱스 마다 다른 배열의 주소를 가지고 있다.
 * - 1차원 배열을 묶어서 관리하는 것.
 * - 3차원 이상도 가능은 하지만 자주 사용되지 않는다.
 *
 * 다차원 배열 사용법
 * 1. 배열 변수 선언
 * 2. 1차원 배열을 n개 관리하는 배열 객체를 할당
 * 3. 첫번째 배열의 인덱스별로 두번째 배열을 할당
 * 4. 두번째 배열의 인덱스별로 값을 대입해서 사용.
 */
public class MultiDimentionalArray {
    public void test1() {
        // 1. 2차원 배열 변수 선언
        int[][] arr;

        // 2. 1차원 배열을 관리하는 첫 번째 배열 객체 할당
        arr = new int[3][];

        // 3. 첫 번째 배열 각 인덱스에 두번째 1차원 배열을 할당
        arr[0] = new int[2];
    }
    public void test2() {
        /**
         * 학생들의 점수 데이터가 다음과 같다.
         * A 90 70 55 80
         * B 100 95 100 50
         * C 80 75 90 99
         */
        int[][] scoreArr = {{90, 70, 55, 80}, {100, 95, 100, 50}, {80, 75, 90, 99}};
        char[] charArr = {'A', 'B', 'C'};
        System.out.println("  국 영 수 자");

        for (int i = 0; i < scoreArr.length; i++) {
            System.out.print(charArr[i]);
            for (int j = 0; j < scoreArr[i].length; j++) {
                System.out.print(" " + scoreArr[i][j]);
            }
            System.out.println();
        }
    }
    public void test3() {
        int k = 1;
        int[][] arr = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = k;
                k++;
                System.out.print(" " + arr[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 사용자로부터 행수를 입력 받아서 다음과 같이 출력 ( 적절한 크기의 가변 배열을 생성)
     * - 행수 입력 : 5
     * 1
     * 2 3
     * 4 5 6
     * 7 8 9 10
     * 11 12 13 14 15
     *
     */
    public void test4() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("행수 입력 : ");
        int colCnt = scanner.nextInt();
        int value = 1;
        int[][] arr = new int[colCnt][];

        for (int i = 0; i < colCnt; i++) {
                arr[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = value++;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
