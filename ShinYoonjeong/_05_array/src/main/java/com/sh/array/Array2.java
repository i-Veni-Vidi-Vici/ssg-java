package com.sh.array;

import java.util.Scanner;

public class Array2 {
    /**
     * 배열
     * - 관련있고 동린한 자료형의 데이터를 처리하는데 적합
     * - 점수 데이터, 이름 데이터
     */
    public void test(){
        // 국어 90, 영어 85, 수학 55 => 총점/평균
        int[] score = new int[]{90,85,55};
        double avg=0;
        for(int i=0; i<score.length;i++)
        {
            avg+=score[i];
        }
        System.out.printf("평균 : %.1f", avg/3.0);
    }

    /**
     * 학생 3명의 자바 점수를 입력받고, 평균 점수를 출력
     * - int[] 사용
     */
    public void test2(){
        Scanner sc = new Scanner(System.in);
        int[] score = new int[3];
        double sum=0;
        for(int i=0;i<score.length;i++)
        {
            System.out.println("점수 입력 : ");
            score[i] = sc.nextInt();
            sum += score[i];
        }
        System.out.printf("평균 점수 : %.1f", sum/score.length);

    }
    //char[]에 알파벳 소문자 순서대로 저장하고 출력하기
    public void test3(){
        char[] alphabets = new char[26];
        for(int i=0; i<alphabets.length;i++)
        {
            alphabets[i]= (char)(i+'a');
        }
        for(int i=0; i<alphabets.length;i++)
        {
            if (i== alphabets.length-1){
                System.out.printf("%c", alphabets[i]);
            }
            else{
                System.out.printf("%c, ", alphabets[i]);
            }
        }
    }
}
