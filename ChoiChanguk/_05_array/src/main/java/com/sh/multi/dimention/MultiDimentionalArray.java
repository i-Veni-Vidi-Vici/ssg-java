package com.sh.multi.dimention;

public class MultiDimentionalArray {
    public void test1() {
        //1. 2차원 배열변수 선언
        int[][] arr;

        //2. 1차원 배열을 관리하는 첫번째
        arr=new int[3][];

        //3. 첫번째 배열 각인덱스에 두번째 1차원 배열을 할당
        arr[0]=new int[2];
        arr[1]=new int[2];
        arr[2]=new int[2];

        //4. 두번째 배열의 각 인덱스별로 값 할당
        arr[0][0]=10;
        arr[0][1]=20;

        arr[1][0]=30;
        arr[1][1]=40;

        arr[2][0]=50;
        arr[2][1]=60;

        //값 확인
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                System.out.printf("%d ",arr[i][j]);
            }
            System.out.println("");
        }

    }

    public void test2() {
        //배열변수 선언 + 1차원배열(3) 할당 + 2차원배열(2) 할당
        int[][] arr=new int[3][2];

        //값 대임
        arr[0][0]=100;
        arr[0][1]=200;
        arr[1][0]=300;
        arr[1][1]=400;
        arr[2][0]=500;
        arr[2][1]=600;

        //값 출력
        //1차원 배열의 크기만큼 반복(3)
        for(int i=0;i<arr.length;i++)
        {
            //2차원 배열의 코기만큼 자름(2)
            for(int j=0;j<arr[0].length;j++)
            {
                System.out.printf("%d ",arr[i][j]);
            }
        }

    }

    public void test3() {
        /**
         * 학생들의 점수 데이터가 다음과 같다
         *    국 영 수 자
         * A  90 70 55 80
         * B 100 95 100 50
         * C 80 75 90 99
         */

        int[][] scores=new int[3][4];
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

        //int[] sum=new int[3];

        System.out.printf("  국 영 수 자\n");
        for(int i=0;i<scores.length;i++)
        {
            System.out.printf("%c",'A'+i);

            for(int j=0;j<scores[i].length;j++)
            {
                System.out.printf(" %d ", scores[i][j]);
            }

            System.out.printf("\n");
        }
    }

    public void test4() {
        // 배열변수 선언 + 1차원배열 할당 + 2차원배열 할당 + 2차원배열의 인덱스별 값대입
        int[][] nums=new int[][] {{1,2,3},{3,4,6}};
        for(int i =0;i<nums.length;i++)
        {
            for(int j=0;j<nums[i].length;j++)
            {
                System.out.printf("%d ",nums[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public void test5()
    {

        int cnt=1;
        /**
         * 2차원배열의 인덱스별로 연속된 값의 규칙이 있다면,
         */
        //입력문
        int[][] arr=new int[3][3];

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                arr[i][j]=cnt++;
            }
        }

        //출력문
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                System.out.printf("%d ",arr[i][j]);
            }
            System.out.printf("\n");
        }
    }

}
