package com.sh.multi.dimention;

/**
 * 다차원 배열
 * - 2차원 이상의 배열을 의미
 * - 첫번째 배열 인덱스 마다 다른 두번째 배열의 주소를 가지고 있다.
 * - 1차원 배열을 묶어서 관리하는 것
 * - 3차원 이상도 가능하지만 자주 사용되지 않는다.
 * 다차원 배열 사용법
 * 1. 배열변수 선언
 * 2. 1차원 배열을 n개 관리하는 첫번째 배열 객체를 할당 배열 객체를 할당
 * 3. 첫번째 배열의 인덱스별로 두번째 배열을 할당
 * 4. 두번째 배열의 인덱스별로 값을 대입해서 사용
 */
public class MultiDimentionalArray {
    public void test1() {
        // 1. 2차원 배열 변수를 선언
        int[][] arr;
        // int arr[][]; // 씨가족
        // 2. 1차원 배열을 관리하는 첫번째 배열 객체 할당
        arr = new int[3][];

        // 3. 첫번째 배열 각인덱스에 두번째 1차원 배열을 할당
        arr[0] = new int[2];
        arr[1] = new int[2];
        arr[2] = new int[2];

        // 4. 두번째 배열 각 인덱스별로 값 할당
        arr[0][0] = 10;
        arr[0][1] = 20;
        arr[1][0] = 30;
        arr[1][1] = 40;
        arr[2][0] = 50;
        arr[2][1] = 60;
    }

    /**
     * 1, 2차원의 배열을 한번에 할당
     */
    public void test2() {
        // 배열변수 선언 + 1차원 배열 (3)할당 + 2차원 배열(2) 할당
        int[][] arr = new int[3][2];

        arr[0][0] = 100;
        arr[0][1] = 200;
        arr[1][0] = 300;
        arr[1][1] = 400;
        arr[2][0] = 500;
        arr[2][1] = 600;

        // 값 출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    /**
     * 학생들의 점수 데이터가 다음과 같다.
     *      국   영   수   사
     *  A   90  70  55  80
     *  B   100 95 100  50
     *  C   80  75  90  99
     */
    public void test3() {
        String[][] arr;
        arr = new String[][]{
                {"    ", "   국", "   영", "   수", "   자"},
                {"A   ", "  90", "  70", "  55", "  80"},
                {"B   ", " 100", "  95", " 100", "  50"},
                {"C   ", "  80", "  75", "  90", "  99"}
        };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 2차원 배열 초기화
     */
    public void test4() {
        // 배열변수 선언 + 1차원배열 할당 + 2차원 배열할당 + 2차원 배열의 인덱스별 값대입
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6}
        };

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 2차원배열의 인덱스별로 연속된 값의 규칙이 있다면,
     * 반복문을 통해 값대입할 수 있다.
     */
    public void test5() {
        int[][] arr = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = j;
            }
        }
    }
}
