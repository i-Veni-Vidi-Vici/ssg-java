package com.sh.array;

import java.util.Scanner;

public class Array2 {
    public void test1() {
        // 국어 90, 영어 85, 수학 55 -> 총점/평균
        int[] scores = new int[] {90, 85, 55};
        int sum = 0;

//        int[] scores = new int[3];
//        scores[0] = 90;
//        scores[1] = 85;
//        scores[2] = 55;

        // 총점 - 각 번지수의 점수를 sum 변수에 누적한다.
//        sum += scores[0];
//        sum += scores[1];
//        sum += scores[2];

        for(int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        System.out.println("총점 : " + sum);
        double avg = (double) sum / scores.length;      // magic number 3
//        System.out.println("평균 : " + avg);
        System.out.printf("평균 : %.2f", avg);           // printf로 반올림처리, .2는 반올림해서 소수점 2번째자리까지 출력
    }

    /**
     * 학생 3명의 자바 점수를 입력 받고, 평균 점수를 출력
     * - int 배열 사용
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);

        int[] scores = new int[3];
        int stdNum = 3;
        int stdNo = 1;
        int sum = 0;
        double avg = 0.0;


        // 학생 점수 입력, 총 점수 연산
        for(int i = 0; i < scores.length; i++) {
            System.out.print(stdNo + "번째 학생 점수 입력: ");
            scores[i] = sc.nextInt();
            sum += scores[i];
            stdNo++;
        }

        // 학생 평균 점수 연산1
        avg = (double) sum / stdNum;

        // 학생 평균 점수 출력
        System.out.printf("학생들의 평균 점수는 %.2f입니다.", avg);

    }

    /**
     * char[]에 알파벳 소문자 순서대로 저장하고 출력하기
     */

    public void test3() {
        char[] alphabets = new char[26];

//        alphabets[0] = 'a';
//        alphabets[1] = 'b';
//        alphabets[2] = 'c';
//        alphabets[3] = 'd';
//        alphabets[4] = 'e';
//        ...
//        alphabets[25] = 'z';

        // 값 대입
        for(int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char) ('a' + i);
        }

        // 값 출력
        for(int i = 0; i < alphabets.length; i++) {
            System.out.print(alphabets[i]);

            if(i != (alphabets.length - 1))
                System.out.print(", ");
        }
    }
}
