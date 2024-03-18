package com.sh.multi.dimention;

import java.util.Scanner;

public class JaggedArray {

    /**
     * 가변배열
     * - 2차월배열은 자료형이 같은 1차원 배열의 묶음이다.
     * - 이때 배열의 크기가 꼭 같을 필요는 없다.
     * - 2차원 배열의 크기가 다른 경우 이를 가변배열, 같은 경우 정변배열이라 부른다.
     */
    public void test1()
    {
        //2차원 배열 할당
        int[][] arr=new int[3][];

        //각각 길이가 다른 2차원 배열 할당
        arr[0] = new int[]{1, 2, 3};
        arr[1] = new int[]{1, 2};
        arr[2] = new int[]{1, 2, 3, 4, 5};

        for(int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d ",arr[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public void test2() {
        /**
         * 사용자로부터 행수를 입력받아서 다음과 같이 출력 하세요(가변 배열을 생성)
         * - 행수 입력 : 5
         * 1
         * 2 3
         * 4 5 6
         * 7 8 9 10
         * 11 12 13 14
         */

        Scanner sc=new Scanner(System.in);

        System.out.printf("행을 입력 해주세요 : ");
        int n= sc.nextInt();

        int[][] arr=new int[n][];
        int k=1;

        for(int i=0;i< arr.length;i++)
        {
            // i번행에 열을 붙여준다
            //ex) Scanner sc=new Scanner(System.in); 이 형식과 같아
            // arr[0]=new int[1];
            arr[i]=new int[i+1];

            for(int j=0;j<=i;j++)
            {
                arr[i][j]=k++;
            }
        }

        for(int i=0;i< arr.length;i++)//출력 for문
        {
            for(int j=0;j<arr[i].length;j++)
            {
                System.out.printf("%2d ",arr[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
