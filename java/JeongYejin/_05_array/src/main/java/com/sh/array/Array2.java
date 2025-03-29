package com.sh.array;

import java.util.Scanner;

/**
 * 배열 - 관련있고 동일한 자료형의 데이터를 처리하는데 적합
 * - 관련있고 동일한 자료형의 데이터를 처리하는 데 적합
 * - 점수 데이터, 이름 데이터 등
 */

public class Array2 {
    public void test() {
        // 국어 90, 영어 85, 수학 55 -> 총점/평균
//        int[] scores = new int[3];
        int[] scores = new int[]{90, 85, 55};
//        scores[0] = 90;
//        scores[1] = 85;
//        scores[2] = 55;

        // 총점 - 각번지수의 점수를 sum 변수에 누적한다.
        int sum = 0;
//        sum += scores[0];
//        sum += scores[0];
//        sum += scores[0];

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        System.out.println("총점 : " + sum);
        double avg = (double) sum / scores.length;
        System.out.printf("평균 : %.2f", avg); // printf로 반올림처리

    }

    /**
     * 학생 3명의 자바 점수를 입력받고, 평균점수를 출력
     * - int[] 사용
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[3];
        int sumScore=0;
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("학생 %d 점수 입력 : ", i+1);
            scores[i] = sc.nextInt();
            sumScore += scores[i];
        }
        System.out.println("-----------------------");
        double avgScore = (double) sumScore/scores.length;
        System.out.printf("학생들의 평균 점수는 %.1f점입니다.", avgScore);
    }

    public void test3() {
        char[] alphabets = new char[26];
//        alphabets[0] = 'a';
//        alphabets[1] = 'b';
//        alphabets[2] = 'c';
//        alphabets[3] = 'd';
//        alphabets[4] = 'e';
//        // ...
//        alphabets[25] = 'z';

        // 값대입
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char) ('a' + i);
        }
        // 값조회
        for (int i = 0; i < alphabets.length; i++) {
            System.out.print(alphabets[i]);
            if (i < alphabets.length-1) {
                System.out.print(", ");
            }
        }
    }
}
