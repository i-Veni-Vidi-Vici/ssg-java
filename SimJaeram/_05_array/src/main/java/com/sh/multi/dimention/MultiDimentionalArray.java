package com.sh.multi.dimention;

import java.util.Scanner;

/**
 * 다차원 배열 사용법 (차원의 개념이 아닌 참조의 개념으로 이론적으로는 256차원도 가능)
 * 1. 배열 변수 선언
 * 2. 1차원 배열을 n개 관리하는 첫번째 배열 객체를 할당
 * 3. 첫번째 배열의 인데스별로 1차원 배열 객체 대입해서 사용
 * 4. 두번째 배열의 인덱스별로 값을 대입해서 사용
 */

public class MultiDimentionalArray {
    public void test1() {
        // 1. 2차원 배열 변수 선언
        int[][] arr;
//        int arr[][];

        // 2. 1차원 배열을 관리하는 첫번째 배열 객체 할당
        arr = new int[3][];

        // 3. 첫번째 배열 각 인데스에 두번째 1차원 배열을 할당
        arr[0] = new int[2];
        arr[1] = new int[2];
        arr[2] = new int[2];

        // 4. 두번째 배열의 각 인덱스 별로 값 할당
        arr[0][0] = 10;
        arr[0][1] = 20;
        arr[1][0] = 30;
        arr[1][1] = 40;
        arr[2][0] = 50;
        arr[2][1] = 60;

        // 배열 요소 출력
        System.out.println(arr[0][0]);
        System.out.println(arr[0][1]);
        System.out.println(arr[1][0]);
        System.out.println(arr[0][1]);
        System.out.println(arr[2][0]);
        System.out.println(arr[2][1]);
    }

    /**
     * 1, 2차원 배열을 한번에 할당
     */
    public void test2() {
        // 배열 변수 선언 + 1차원 배열(3) 할당 + 2차원 배열(2) 할당
        int[][] arr = new int[3][2];

        // 값 대입
        arr[0][0] = 100;
        arr[0][1] = 200;
        arr[1][0] = 300;
        arr[1][1] = 400;
        arr[2][0] = 500;
        arr[2][1] = 600;

        // 값 출력
        // 1차원 배열의 크기만큼 반복(3)
        for(int i = 0; i < arr.length; i++) {
            // 2차원 배열의 크기만큼 반복(2)
            for(int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 학생들의 점수 데이터가 다음과 같다.
     *   국 영 수 자
     * A 90 70 55 80
     * B 100 95 100 50
     * C 80 75 90 99
     */
    public void test3() {
        Scanner sc =  new Scanner(System.in);
        int[][] scores = new int[3][4];

//        int[][] scores = {{90, 70, 55, 80},
//                          {100, 95, 100, 50},
//                          {80, 75, 90, 99}};

//        int[][] scores
        for(int i = 0; i < scores.length; i++) {
            System.out.println((i+1) + "번째 학생의 점수를 국어, 영어, 수학, 자바 순서대로 띄어쓰기 하여 입력해주세요.");
            for(int j = 0; j < scores[i].length; j++) {
                scores[i][j] = sc.nextInt();
            }
            System.out.println();
        }

        for(int i = 0; i < scores.length; i++) {
            System.out.println((i+1) + "번째 학생의 국어, 영어, 수학, 자바 점수입니다.");

            for(int j = 0; j < scores[i].length; j++) {
                System.out.print(scores[i][j]);
            }
            System.out.println();
        }
    }

    public void test4() {
        // 배열변수 선언 + 1차원 배열 할당 + 2차원 배열 할당 + 2차원 배열의 인덱스별 값대입
//        int[][] num = new int[][] {{1, 2, 3},
//                                    {4, 5, 6},
//                                    {7, 8, 9}};

        int[][] num = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for(int i = 0; i < num.length; i++) {
            for(int j = 0; j < num[i].length; j++) {
                System.out.println(num[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 2차원 배열의 인덱스별로 연속된 값의 규칙이 있다면,
     * 반복문을 통해 값대입 할 수 있다.
     */

    public void test5() {
        int[][] arr = new int[3][3];

        // 값 대입
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = (3 * i) + (j + 1);
//            }
//        }

        int k = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = k;
                System.out.print(arr[i][j] + "\t");
                k++;
            }
            System.out.println();
        }
    }
}
