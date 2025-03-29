package com.sh.array;

import java.util.Scanner;

public class Array2 {
    /**
     * 배열 - 관련있고 동일한 자료형의 데이터를 처리하는데 적합
     * - 정수데이터
     */
    public void test1() {

        //국어 90, 영어 85, 수학 55
        int sum=0;
        int[] scores=new int[]{90,85,55};

        for(int i=0;i<scores.length;i++)
        {
            sum+=scores[i];
        }

        System.out.printf("총점 = %d \n",sum);
        double avg=sum/3.0;
        System.out.printf("평균 = %.2f\n",avg);
    }


    public void test2() {
        /**
         * 학생 3명의 자바 점수를 입력 받고, 평균 점수를 출력
         */
        Scanner sc = new Scanner(System.in);
        int[] scores=new int[3];
        int sum=0;
        double avg=0;

        for(int i=0;i<scores.length;i++) {
            System.out.printf("점수 입력 하세요 : ");
            scores[i]=sc.nextInt();
            sum+=scores[i];
        }

        avg=sum/(double)scores.length;
        System.out.printf("합 = %d  \n평균 = %1.1f",sum,avg);
    }

    public void test3(){
    /**
     * 알파벳 순서대로 저장하고 출력하기
     */
    Scanner sc = new Scanner(System.in);
    char[] alpa=new char[26];

    for(int i=0;i<alpa.length;i++)
    {
        alpa[i]=(char) ('a'+i);
    }
    for (int i=0;i<alpa.length;i++)
    {
        if(i==alpa.length-1)
        {
            System.out.printf("%c ",alpa[i]);
        }
        else System.out.printf("%c, ",alpa[i]);

    }




    }
}
