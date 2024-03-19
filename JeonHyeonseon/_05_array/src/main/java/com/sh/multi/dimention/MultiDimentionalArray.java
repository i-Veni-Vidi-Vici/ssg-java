package com.sh.multi.dimention;

/**
 * 다차원배열
 * - 2차원 이상의 배열을 의미
 * - 처번째 배열 인덱스마다 서로 다른 두번째 배열의 주소를 가지고 있다.
 * - 1차원 배열을 묶어서 관리하는 것.
 * - 3차원이상도 가능은 하지만 자주 사용되지 않는다.
 *
 * 다차원배열 사용법
 * 1. 배열변수 선언
 * 2. 1차원 배열을 n개 관리하는 첫번째 배열에 객체를 할당(생성)한다.
 * 3. 첫번째 배열의 인덱스별로 두번째 배열을 할당(생성)한다.
 * 4. 두번째 배열의 인덱스별로 값을 대입해서 사용한다.
 */
public class MultiDimentionalArray {
    public void test1() {
        // 1. 2차원 배열변수 선언
        int[][] arr;  // arr의 변수는 int[][]이다.
//        int arr[][];

        // 2. 1차원 배열을 관리하는 첫번째 배열에 객체를 할당(생성)한다.
        arr = new int[3][];  // 크기가 3개인 배열이 만들어진다는 식, 행처럼 생각

        // 3. 첫번째 배열 각 인덱스에 두번째 1차원배열을 할당(생성)한다.
        arr[0] = new int[2]; // 열처럼 생각
        arr[1] = new int[2];
        arr[2] = new int[2];

        // 4. 두번째 배열의 각 인덱스별로 값 할당
        arr[0][0] = 10;
        arr[0][1] = 20;
        arr[1][0] = 30;
        arr[1][1] = 40;
        arr[2][0] = 50;
        arr[2][1] = 60;

        // 값확인
        System.out.println(arr[0][0]);
        System.out.println(arr[0][1]);
        System.out.println(arr[1][0]);
        System.out.println(arr[1][1]);
        System.out.println(arr[2][0]);
        System.out.println(arr[2][1]);
    }

    /**
     * 1, 2차원 배열을 한 번에 할당
     */
    public void test2() {
        // 배열변수 선언 + 1차원 배열(3) 할당(생성) + 2차원배열(2) 할당
        int[][] arr = new int[3][2]; // 위에서 1, 2, 3번을 한 번에 한 식

        // 값대입
        arr[0][0] = 100;
        arr[0][1] = 200;
        arr[1][0] = 300;
        arr[1][1] = 400;
        arr[2][0] = 500;
        arr[2][1] = 600;

        // 갑 출력
        // 1차원 배열의 크기만큼 반복(3번)
//        for(int i = 0; i < 3; i++) { // 3은 행의 수라고 생각하면 된다.
        for(int i = 0; i < arr.length; i++) { // arr.length은 배열의 크기

            // 2차원 배열의 크기만큼 반복(2번)
//            for(int j = 0; j < 2; j++) {
            for(int j = 0; j < arr[i].length; j++) {
//                System.out.println(arr[i][0]);
//                System.out.println(arr[i][1]);
                System.out.println(arr[i][j]); // 66과 67줄의 반복문 결과값
            }
            System.out.println();
        }
    }

    /**
     * 학생들의 점수 데이터가 다음과 같다.
     *       국  영  수  자바
     * A 학생 90 70 55 80
     * B 학생 100 95 100 50
     * C 학생 80 75 90 99
     */
    public void test3(){
        int[][] scores = new int[3][4];

//        int[][] scores = new int[3][];
//        scores[0] = new int[4];
//        scores[1] = new int[4];
//        scores[2] = new int[4];
//        scores[3] = new int[4]; // 88에서 92까지가 86을 나타낸것이다.

        // 값대입
        scores[0][0] = 90;
        scores[0][1] = 70;
        scores[0][2] = 55;
        scores[0][3] = 80;

        scores[1][0] = 100;
        scores[1][1] = 95;
        scores[1][2] = 100;
        scores[1][3] = 50;

        scores[2][0] = 80;
        scores[2][1] = 75;
        scores[2][2] = 90;
        scores[2][3] = 99;


        for(int i = 0; i < scores.length; i++) {  // 첫 번째 배열[]의 반복
            for(int j = 0; i< scores[i].length; j++) { // 두 번째 배열[]의 반복
                System.out.print(scores[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * 2차원 배열 초기화
     */
    public void test4() {
        // 배열변수 선언 + 1차원배열 할당 + 2차원배열 할당 + 2차원배열의 인덱스별 값대입
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6}
        };

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
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

        // 값대입
        int k = 1;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = k;
                k++;

                // 출력
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
