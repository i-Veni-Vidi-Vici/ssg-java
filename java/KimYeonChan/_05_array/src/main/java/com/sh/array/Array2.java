package com.sh.array;

import java.util.Scanner;

public class Array2 {
    /**
     * 배열
     * - 관련있고 동일한 자료형의 데이터를 처리하는데 적합함
     * - 점수데이터, 이름데이터 등
     */
    public void test1() {
        // 국어 80, 영어 85, 수학 55 -> 총점 / 평군
        int[] scores = {80, 85, 55};

        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        System.out.println(sum);
        double avg = (double)sum / scores.length;
        System.out.printf("평군: %.2f", avg); // printf 반올림처리
    }

    /**
     * 학생 3명의 자바 점수를 입력 받고, 평균 점수를 출력
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);

        int[] scores = new int[3];
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            System.out.print("학생" + (i + 1) + " 점수 입력: ");
            scores[i] = sc.nextInt();
            sum += scores[i];
        }

        double avg = (double)sum / scores.length;
        System.out.printf("평군: %.2f", avg);
    }

    /**
     * char[] 에 알파벳 소문자 순서대로 저장하고 출력하기
     */
    public void test3() {
       char[] alphabets = new char[26];

       for (int i = 0; i < alphabets.length; i++) {
           alphabets[i] = (char)('a' + i);
           System.out.print(alphabets[i]);
           if (i == alphabets.length - 1) {
               continue;
           }
           System.out.print(", ");
       }
    }
}
