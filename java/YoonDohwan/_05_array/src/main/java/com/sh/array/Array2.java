package com.sh.array;

import java.util.Scanner;

public class Array2 {
    /**
     * 배열-관련있고 동일한 자료형의 데이터를 처리하는데 적합
     * -점수데이터,이름데이터
     * -
     */
    public void test() {
        //국어 90,영어 85, 수학 55
        int[] score = new int[]{90,85,55};
        int sum=0;
        for(int i=0;i<score.length;i++){
            sum+=score[i];
        }
        System.out.println(sum);
        double avg = (double)sum/score.length;
        System.out.printf("평균 : &.1f",avg);//printf로 반올림처리
    }
    public void test2(){
        Scanner sc = new Scanner(System.in);
        int[] std = new int[3];
        int sum=0;
        int avg=0;
        for(int i=0;i<std.length;i++) {
            System.out.println("점수를 입력하시오 : ");
            std[i]=sc.nextInt();
            sum+=std[i];
        }
        avg=sum/std.length;
        System.out.println("평균은: "+avg);
    }
    public void test3(){
        Scanner sc = new Scanner(System.in);
        char[] alphabets = new char[26];
        for(int i=0;i< alphabets.length;i++){
            alphabets[i]=(char)(i+97);

        }
        for(int i=0;i<alphabets.length;i++){
        System.out.print(alphabets[i] + ",");
        }
    }
}
