package com.sh.array;

import java.util.Scanner;

public class Array2 {

    public void test1(){
        //국어 90, 영어 85, 수학 55 -> 총점/평균
        int[] scores = {90,85,55};
        int sum =0;
        for(int i =0; i< scores.length;i++){
            sum+=scores[i];
        }
        System.out.println("총점 : "+ sum);
        double avg = (double)sum/ scores.length;
        System.out.printf("평균 : %.2f",avg); // printf 반올림 처리
    }

    /**
     * 학생 3명의 자바 점수를 입력받고, 평균 점수를 출력
     * -int[] 사용
     */
    public void test2(){
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[3];
        int sum = 0;
        for(int i =0; i<3; i++){
            System.out.print("점수 입력: ");
            int score = scanner.nextInt();
            scores[i] = score;
            sum+=score;
        }
        System.out.printf("\n평균점수는 %.2f 입니다.", (double)sum/scores.length);
    }

    public void test3(){
        char[] alphabets = new char[26];
        char a ='a';
        for(int i = 0; i< alphabets.length; i++){
            alphabets[i] = (char)(a+i);
        }
        for(int i =0; i< alphabets.length; i++){
            if (i== alphabets.length-1){
                System.out.printf("%c", alphabets[i]);
            }
            else{
                System.out.printf("%c, ", alphabets[i]);
            }
        }
    }
}
