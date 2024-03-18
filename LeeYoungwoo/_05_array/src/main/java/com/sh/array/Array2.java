package com.sh.array;

import java.sql.Array;
import java.util.Scanner;

public class Array2 {
    /**
     * 배열
     * - 관련있고 동일한 자료형의 데이처를 처리하는데 적합
     * - 점수데이터, 이름데이터
     */
    public void test1() {
        // 국어 : 90, 영어 : 85, 수학 : 55 -> 총점/평균 구하기
        int[] scores = new int[]{90, 85, 55};

        // 총점 - 각 번지수의 점수를 sum 변수에 누적한다.
        int sum = 0;
        for(int i = 0; i < scores.length; i++){
            sum += scores[i];
        }
        System.out.println("총점 : " + sum);

        // 평균
        double avg = (double) sum / scores.length;
        System.out.printf("평균 : %.2f", avg); // printf로 반올림 처리

    }

    /**
     * 학생 3명의 자바 점수를 입력받고, 평균점수를 출력해보기
     * - int[] 사용
     */
    public void test2(){
        Scanner sc = new Scanner(System.in);
//        System.out.println("> 학생1 점수입력 : ");
//        int score1 = sc.nextInt();
//        System.out.println("> 학생2 점수입력 : ");
//        int score2 = sc.nextInt();
//        System.out.println("> 학생3 점수입력 : ");
//        int score3 = sc.nextInt();

//        int[] score = {score1, score2, score3};
//
//        int sum = 0;
//        for(int i = 0; i < score.length; i++) {
//            sum += score[i];
//        }
//        double avg = (double) sum / score.length;
//        System.out.println("학생들의 평균 점수는 " + avg + "점 입니다.");

    // case 2.
        int[] scores = new int[3]; // 크기는 무조건 배열 할당시에 지정해야 하고, 변경할 수 없다.
        int sum = 0;

        for(int i = 0; i< scores.length; i++) {
            System.out.println("학생"+ (i+1) + "점수 입력 : ");
            scores[i] = sc.nextInt();
            sum += scores[i];
        }

        double avg = (double) sum / scores.length;
        System.out.println("학생들의 평균 점수는 " + avg + "점 입니다.");

    }

    /**
     * char[]에 알파벳 소문자 순서대로 저장하고 출력하기
     */
    public void test3(){
        char[] alphabets = new char[26];

        for(int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char) (i + 'a');

            // 값 조회
            if (alphabets[i] != 'z') {
                System.out.print(alphabets[i]+ ", ");
            }
            else {
                System.out.print(alphabets[i]);
            }

        }
    }
}
