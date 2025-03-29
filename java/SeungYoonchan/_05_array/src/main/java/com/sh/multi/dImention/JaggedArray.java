package com.sh.multi.dImention;

import java.util.Scanner;

/**
 * <pre>
 *     가변 배열
 *     - 2차원 배열은 자료형이 같은 1차원 배열의 묶음
 *     - 이때, 배열의 크기가 꼭 같을 필요는 없다.
 *     - 2차원 배열의 크기가 다른 경우 이를 가변 배열, 같은 경우 정변 배열이라 부른다.
 *
 * </pre>
 */
public class JaggedArray {
    public void test1(){
        int[][] arr = new int[3][];

        arr[0] = new int[3];
        arr[1] = new int[2];
        arr[2] = new int[5];

        int value = 1;
        for (int i=0; i< arr.length; i++){
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = value++;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * <pre>
     *     사용자로부터 행수를 입력 받아 다음과 같이 출력
     *     행수 : 5
     *     1
     *     2 3
     *     4 5 6
     *     7 8 9 10
     *     11 12 13 14 15
     *
     * </pre>
     */
    public void test2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("행수를 입력하시오 : ");
        int num = sc.nextInt() + 1;

        int[][] arr = new int[num][];

        int i, j;
        for (i = 0; i < num; i++) {
            arr[i] = new int[i];
        }

        int value = 1;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[i].length; j++) {
                arr[i][j] = value++;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
