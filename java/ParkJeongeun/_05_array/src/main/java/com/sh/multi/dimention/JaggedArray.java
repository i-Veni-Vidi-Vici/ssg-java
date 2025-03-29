package com.sh.multi.dimention;

import java.util.Scanner;

/**
 * 가변배열
 * - 2차원 배열은 자료형이 같은 1차원 배열의 묶음
 * - 이때 배열의 크기가 꼭 같을 필요는 없음
 * - 2차원 배열의 크기가 다른 경우 이를 가변배열, 같은 경우 정변배열이라고 부름
 *
 */

public class JaggedArray {
    public void test() {
        int[][] arr = new int[3][];

        System.out.println(arr[0]); //null
        System.out.println(arr[1]); //null
        System.out.println(arr[2]); //null

        // 각각 길이가 다른 2차원 배열 할당
        arr[0] = new int[3];
        arr[1] = new int[2];
        arr[2] = new int[5];

        int value = 1;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                arr[i][j] = value++; // 현재 value값 넣고 1 증가
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 사용자로부터 행수를 입력 받고 다음과 같이 출력(적절한 크기의 가변배열 생성)
     * - 행수 입력 : 5
     * 1
     * 2 3
     * 4 5 6
     * 7 8 9 10
     * 11 12 13 14 15
     */
    public void test2() {
        // 내 답안
//        Scanner sc = new Scanner(System.in);
//        System.out.print("> 행수 입력 : ");
//        int row = sc.nextInt();
//
//        int[][] arr = new int[row][row];
//        int k = 1;
//        for (int i = 0; i < arr.length; i++){
//            for (int j = 0; j < i + 1; j++){
//                arr[i][j] = k++;
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        // 모범 답안
        Scanner sc = new Scanner(System.in);
        System.out.print("> 행수 입력 : ");
        int row = sc.nextInt();
        int[][] arr = new int[row][];

        // 크기가 다른 2차원 배열 할당

        for (int i = 0; i < row; i++) {
            arr[i] = new int[i + 1];
        }

        int value = 1;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                arr[i][j] = value++;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }



}
