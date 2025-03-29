package com.sh.multi.dimension;

import java.util.Scanner;

/**
 * <pre>
 * 가변배열
 * - 2차원 배열은 자료형이 같은 1차원 배열의 묶음이다.
 * - 이때 배열의 크기가 꼭 같은 필요는 없다.
 * - 2차원 배열의 크기가 다른 경우 이를 가변배열, 같은 경우 정변배영이라 부른다.
 * </pre>
 */
public class JaggedArray {
    /**
     * 사용자로부터 행수를 입력받아서 다음과 같이 출력(적절한 크기의 가변배율 선택
     * - 행수 입력: 5
     * 1
     * 23
     * 456
     * 78910
     * 1112131415
     */
    public void test1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("입력:");
        int num = sc.nextInt();
        int[][] result = new int[num][];
        int count = 1;
        for (int i = 0; i < num; i++) {
            result[i] = new int[i+1];
            for (int j = 0; j < i+1 ; j++) {
                result[i][j] = count++;
                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }


//        int count = 1;
//        for (int i = 1; i <= num; i++) {
//            for (int j = 0; j < i; j++) {
//                System.out.print(count++ + " ");
//            }
//            System.out.println();
//        }
    }
}
