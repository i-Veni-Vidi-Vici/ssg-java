package com.sh.multi.dImention;

public class MultiDeimentionalArray {
    public void test1() {

        // 1. 다차원 배열 선언
        int[][] arr;

        // 2. 1차원 배열을 관리하는 첫번째 배열 객체 할당
        arr = new int[3][];

        // 3. 첫번째 배열 각 인덱스에 두번째 1차원 배열을 할당
        arr[0] = new int[2];
        arr[1] = new int[2];
        arr[2] = new int[2];

        // 4. 두번째 배별의 각 인덱스별로 값 할당
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
    public void test2(){
        // 배열 변수 선언 + 1차원 배열(3) 할당 + 2차원 배열(2)
        int[][] arr = new int[3][2];

        int i, j, k = 100;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 2; j++) {
                arr[i][j] = k;
                k = k + 100;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * <pre>
     *     학생들의 점수 데이터가 다음과 같다.
     *          국    영   수     자
     *      A   90   70   55    80
     *      B   100  95   100   50
     *      C   80   75   90    99
     *
     * </pre>
     */
    public void test3(){
        int[][] arr = {{90,70,55,80},{100,95,100,50},{80,75,90,99}};

        int i, j;

        System.out.println("국어\t영어\t수학\t자바");
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public void test4(){

    }
}
