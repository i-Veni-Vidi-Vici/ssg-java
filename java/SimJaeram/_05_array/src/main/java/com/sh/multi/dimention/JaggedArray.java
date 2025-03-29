package com.sh.multi.dimention;

import java.util.Scanner;

/**
 * <pre>
 *     가변배열
 *     - 2차원 배열은 자료형이 같은 1차원 배열의 묶음이다.
 *     - 이때 배열의 크기가 꼭 같은 필요는 없다.
 *     - 각 2차원 배열의 크기가 다른 경우 이를 가변배열, 같은 경우 정변배열이라 부른다.
 *
 * </pre>
 */

public class JaggedArray {
    public void test1() {
        int[][] arr = new int[3][];

        System.out.println(arr[0]);     // null
        System.out.println(arr[1]);     // null
        System.out.println(arr[2]);     // null

        // 각각 길이가 다른 2차원 배열 할당
        arr[0] = new int[3];
        arr[1] = new int[2];
        arr[2] = new int[5];

        int value = 1;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = value++;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 사용자로부터 행수를 입력 받아서 다음과 같이 출력 (적절한 크기의 가변배열을 생성)
     * - 행수 입력 : 5
     * 1
     * 2 3
     * 4 5 6
     * 7 8 9 10
     * 11 12 13 14 15
     */

    public void test2() {
        Scanner sc = new Scanner(System.in);
        int row = 0;

        // 사용자로부터 행수 입력
        System.out.print("행수 입력 : ");
        row = sc.nextInt();

        // 배열 생성
        int[][] arr = new int[row][];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = new int[i+1];
        }

        // 배열 요소에 값 대입
        int value = 1;
        for(int i = 0; i < arr.length; i++) {
//            arr[i] = new int[i+1];                각 행의 배열 객체 위와 같이 말고, 이렇게 함축적으로 작성도 가능
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = value++;
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
