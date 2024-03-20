package com.sh.multi.dimension;

/**
 * 다차원배열
 * - 2차원 이상의 배열을 의미
 * - 배열 인덱스마다 다른 배열의 주소를 가지고 있다.
 * - 1차원 배열을 묶어서 관리하는 것.
 * - 3차원이상도 가능은 하지만 자주 사용되지 않는다.
 * <p>
 * 다차원배열 사용법
 * 1. 배열변수 선언
 * 2. 1차원 배열을 n개 관리하는 첫번째 재열 객체를 할당
 * 3. 첫번째 배열의 인덱스별로 두번째 배열을 할당
 * 4. 두번째 배열의 인덱스별로 값을 대입해서 사용.
 */
public class MultiDimensionalArray {
    public void test() {
        int[][] arr;
        // int arr[][];

        // 2. 1차원배열을 관리하는 첫번째 배열 객체 할당
        arr = new int[3][];

        // 3. 첫번째 배열 각인덱스에 두번째 1차원 배열 생성
        arr[0] = new int[2];
        arr[1] = new int[2];
        arr[2] = new int[2];

        // 4. 두번째 배열의 각 인덱스별로 값 할당
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
        // 배열변수 선언 + 1차원배열(3) 할당 + 2차원배열(2) 할당
        int[][] arr = new int[3][2];

        // 값 대입
        arr[0][0] = 100;
        arr[0][1] = 200;
        arr[1][0] = 300;
        arr[1][1] = 400;
        arr[2][0] = 500;
        arr[2][1] = 600;

        // 값 출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(arr[i][j]);
            }
            System.out.println();
        }
    }


    /**
     * 2차원 배열의 인덱스별로 연속된 값의 규칙이 있다면,
     * 반복문을 통해 값대입할수 있다.
     */

    public void test3() {
        int[][] arr = new int[3][3];

        // 값대입
        int k =1;
        for (int i = 0; i < arr.length; i++) {
            for (int j= 0; j<arr[i].length ;j++ ) {
                arr[i][j]= k;
                k++;

                // 출력
                System.out.println(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
