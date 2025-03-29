package com.sh.array;

import java.util.Scanner;

public class Array2 {

    /**
     * 배열
     * - 관련 있고 동일한 자료형의 데이터를 처리하는데 적합
     * - 점수데이터, 이름데이터 등
     *
     */
    public void test1() {
        // 국어 90, 영어 85, 수학 55 -> 총점 / 평균
        int[] scores = {90, 85, 55};
    }

    /**
     * 학생 3명의 자바 점수를 입력 받고, 평균 점수를 출력
     * - int[] 사용
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);

        int[] scores = new int[3];
        double sum = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("학생" + (i + 1) + " 점수 입력 : ");
            scores[i] = sc.nextInt();
            sum += scores[i];
        }

        System.out.println("학생들의 평균 점수는 " + sum / 3 + "점 입니다.");
    }

    /**
     * char[]에 알파벳 소문자 순서대로 저장하고 출력하기
     */
    public void test3() {
        char[] alphabets = new char[26];

        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char) ('a' + i);
        }

        for (int i = 0; i < alphabets.length; i++) {
            System.out.print(alphabets[i] + ", ");
        }

        for (int i = 0; i < alphabets.length; i++) {
            if (i != 0) {
                System.out.println(", ");
            }
            System.out.print(alphabets[i]);
        }


    }
}
