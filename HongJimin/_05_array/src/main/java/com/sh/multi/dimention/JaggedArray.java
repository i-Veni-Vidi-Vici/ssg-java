package com.sh.multi.dimention;

import java.util.Scanner;

public class JaggedArray {
    public void test1() {
        int[][] arr = new int[3][];

        System.out.println(arr[0]); //null
        System.out.println(arr[1]); //null
        System.out.println(arr[2]); //null

        //각각 길이가 다른 2차원 배열 할당
        arr[0] = new int[3];
        arr[1] = new int[2];
        arr[2] = new int[5];

        int value = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = value++;
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    /**
     * 사용자로부터 행수를 입력받아 다음과 같이 출력(적절한 크기의 가변 배열을 생성)
     * - 행수 입력 : 5
     * 1
     * 2 3
     * 4 5 6
     * 7 8 9 10
     * 11 12 13 14 15
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("행수 입력 : ");
        int row = sc.nextInt();
        int[][] arr = new int[row][];

        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = num++;
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
