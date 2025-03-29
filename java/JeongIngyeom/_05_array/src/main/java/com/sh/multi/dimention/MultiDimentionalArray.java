package com.sh.multi.dimention;

public class MultiDimentionalArray {

    public void test1() {
        // 1. 2차원 배열 변수 선언
        int[][] arr;
//        int arr[][];      가능

        // 2. 1차원배열을 관리하는 첫번째 배열 객체 할당
        arr = new int[3][];

        // 3. 첫번째 배열 각 인덱스에 두번째 1차원 배열을 할당
        arr[0] = new int[2];
        arr[1] = new int[2];
        arr[2] = new int[2];

        // 4. 두번째 벼열의 각 인덱스 별로 값 할당
        arr[0][0] = 10;
        arr[0][1] = 20;
        arr[1][0] = 30;
        arr[1][1] = 40;
        arr[2][0] = 50;
        arr[2][1] = 60;
    }

    /**
     * 1, 2차원 배열을 한번에 할당
     */
    public void test2() {
        // 배열 변수 선언 + 1차원배열(3) 할당 + 2차원배열(2) 할당
        int[][] arr = new int[3][2];

        // 값대입
        arr[0][0] = 100;
        arr[0][1] = 200;
        arr[1][0] = 300;
        arr[1][1] = 400;
        arr[2][0] = 500;
        arr[2][1] = 600;

        // 값 출력
        // 1차원 배열의 크기만큼 반복
        for (int i = 0; i < arr.length; i++) {
            // 2차원 배열의 크기만큼 반복
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    /**
     * 학생들의 점수 데이터가 다음과 같다.
     *
     *      국   영   수   자바
     * A    90  70   55   80
     * B    100 95   100  50
     * C    80  75   90   99
     */
    public void test3() {
        System.out.println("\t국\t영\t수\t자바");
        int[][] score = {{90, 70, 55, 80}, {100, 95, 100, 50}, {80, 75, 90, 99}};

        for (int i = 0; i < score.length; i++) {
            System.out.print((char) ('A' + i) + "\t");
            for (int j = 0; j < score[i].length; j++) {
                System.out.print(score[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 2차원 배열 초기화
     */
    public void test4() {
        // 배열 변수 선언 + 1차원배열 할당 + 2차원배열 할당 + 2차원배열의 인덱스별 값대입
        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6}
        };

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.println(nums[i][j] + " ");
            }
        }

//        for (int[] arr : nums) {
//            for (int n : arr) {
//                System.out.print(n + " ");
//            }
//            System.out.println();
//        }
    }

    /**
     * 2차원배열의 인덱스별로 연속된 값의 규칙이 있다면,
     * 반복문을 통해 값대입 할 수 있다.
     */
    public void test5() {
        int[][] arr = new int[3][3];

        // 값대입
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 3 * i + j + 1;
            }
        }

        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
