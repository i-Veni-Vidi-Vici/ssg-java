package com.sh.array.multi.dimension;


import java.util.Scanner;

/**
 * 가변 배열
 * - 2차원 배열은 자료형이 같은 1차원 배열의 묶음이다.
 * - 이때 배열의 크기가 꼭 같은 필요는 없다.
 * - 2차원 배열의 크기가 다른 경우 이를 가변배열, 같은 경우 정변 배열이라고 부른다.
 * - 첫번째 배열의 수만 지정한다.
 */
public class JaggedArray {

    public void test1()
    {
        int[][] arr = new int[3][];

        //2차원 배열할당 -> 가변배열로
        arr[0] = new int[3];
        arr[1] = new int[2];
        arr[2] = new int[5];

        int value = 1;
        for(int i = 0; i<arr.length;i++)
        {
            for(int j = 0; j<arr[i].length;j++)
            {
                arr[i][j] = value++;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 사용자로부터 행수를 입력 받아서 다음과 같이 출력하세요 ( 적절한 크기의 가변배열을 생성합시다.)
     *
     * -행수 입력 : 5
     * 1
     * 2 3
     * 4 5 6
     * 7 8 9 10
     */
    public void test2()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("행을 입력하세요 : ");
        int n = scanner.nextInt();

        int[][] arr = new int[n][];

        for(int i = 0 ;i< n; i++)
        {
            arr[i] = new int[i+1];
        }
        int k = 1;
        for(int i = 0; i<arr.length; i++)
        {
            for(int j = 0; j<arr[i].length; j++)
            {
                arr[i][j] = k++;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
