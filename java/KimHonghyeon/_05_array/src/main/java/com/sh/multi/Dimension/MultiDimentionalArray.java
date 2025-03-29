package com.sh.multi.Dimension;

public class MultiDimentionalArray {

    public void test1(){
        //1. 2차원 배열변수 선언
        int[][] arr;
        //2. 1차원 배원을 관리하는 첫번째 배열 객체 할당
        arr = new int[3][];
        //3. 첫번째 배열 각 인덱스에 두번째 1차원 배열을 할당
        arr[0] = new int[2];
        arr[1] = new int[2];
        arr[2] = new int[2];

        //4. 두번째 배열의 각 인덱스별로 값 할당
        arr[0][0] = 10;
        arr[0][1] = 20;
        arr[1][0] = 30;
        arr[1][1] = 40;
        arr[2][0] = 50;
        arr[2][1] = 60;
    }

    public void test2(){
        // 배열변수 선언 + 할당
        int[][] arr = new int[3][2];
        arr[0][0] = 100;
        arr[0][1] = 200;
        arr[1][0] = 300;
        arr[1][1] = 400;
        arr[2][0] = 500;
        arr[2][1] = 600;

        //값 출력
        for(int i =0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }

    }


    /**
     * 학생들의 점수 데이터
     *   국   영   수   자
     * A 90  70  55  80
     * B 100 95 100  50
     * C 80  75  90  99
     *
     */
    public void test3(){
        int[][] scores = new int[3][4];
        scores[0] = new int[]{90, 70, 55, 80};
        scores[1] = new int[]{100, 95, 100, 50};
        scores[2] = new int[]{80, 75, 90, 99};

        for(int i =0; i< scores.length; i++){
            for(int j =0; j< scores[i].length; j++){
                System.out.printf(scores[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * 2차원 배열 초가화
     */
    public void test4(){
        int[][] nums ={
                {90, 70, 55, 80},
                {100, 95, 100, 50},
                {80, 75, 90, 99}
        };
        for(int i =0; i< nums.length; i++){
            for(int j =0; j< nums[i].length; j++){
                System.out.printf(nums[i][j] + " ");
            }
            System.out.println();
        }

    }
    /**
     * 2차원 배열의 인덱스별로 연속된 규칙이 있다면 반복문을 통해 값 대입
     */

    public void test5(){
        int[][] arr = new int[3][3];
        int k=1;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length;j++){
                arr[i][j] = k++;
            }
        }
        for(int i =0; i< arr.length; i++){
            for(int j =0; j< arr[i].length; j++){
                System.out.printf(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
