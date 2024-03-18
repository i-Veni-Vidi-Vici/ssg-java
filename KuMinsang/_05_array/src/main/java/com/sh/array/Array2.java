package com.sh.array;

import java.util.Arrays;
import java.util.Scanner;

public class Array2 {
    /**
     * 학생 3명의 자바 점수를 입력받고, 평균 점수를 출력
     */
    public void test2(){

        int[] input = new int[3];
        double sum =0;
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<3; i++){
            System.out.print(i+1+"번째 학생의 점수를 입력하세요 : ");
            input[i] = sc.nextInt();
        }

        for(int i : input)
            sum+=i;

        System.out.printf("학생들의 평균 점수는 %.1f점 입니다.", sum/input.length);
    }//end of test2()

    /**
     * char[]에 알파벳 소문자 순서대로 저장하고 출력하기
     */
    public void test3(){
        char[] alphabets = new char[26];
        for(int i =0; i < alphabets.length; i++){
            alphabets[i] = (char)('a'+i);
        }

        for(int i =0; i < alphabets.length; i++){
            System.out.print(alphabets[i]);
        }
    }
}


