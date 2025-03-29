package com.sh.array;

import java.util.Scanner;

public class Array2 {
    /**
     * 배열
     * - 관련있고 동일한 자료형의 데이터를 처리하는데 적합
     * - 점수 데이터, 이름 데이터 등
     */
    public void test1()
    {
        //국어 90, 영어 85, 수학 55 -> 총점 / 평균 구하기

        int[] score = new int[] {90,85,55};

        int total = 0;
        double avg =0 ;

        for(int i = 0; i<score.length; i++)
        {
            total += score[i];
            avg = total/3.0;

        }
        System.out.println("총점 : " + total);
        System.out.println("평균 : " + avg);
        /**
         * System.out.printf("평균 : %.1f", avg )
         * %.1f: 소수점 첫째자리까지 보여줘
         * %.2f : 소수점 둘째자리까지 보여줘
         */
    }

    /**
     * 학생 3명의 자바 점수를 입력받고, 평균점수를 출력
     * -int 사용
     */
    public void test2()
    {
        Scanner scanner = new Scanner(System.in);
        int num;
        int[] arr = new int[3];

        int sum = 0;
        double avg ;
        for(int i = 0; i<arr.length; i++)
        {
            arr[i]= scanner.nextInt();
            sum += arr[i];
        }
        avg = sum / 3.0;
        System.out.printf("평균점수 : %.1f " + avg);
    }

    /**
     * char[]에 알파벳 순서대로 저장하고 출력하기
     */
    public void test3()
    {
        char[] ch = new char[26];

       for(int i = 0; i<ch.length; i++)
       {
           ch[i] = (char)(97 + i);
           System.out.print(ch[i] + ", ");
           if(i == ch.length -1)
               System.out.println(ch[25]);
       }
    }
}
