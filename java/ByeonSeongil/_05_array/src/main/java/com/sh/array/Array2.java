package com.sh.array;

import java.util.Scanner;

public class Array2 {

    public void test1() {
        // 국어 90, 영어 85, 수학 55 -> 총점/평균
        int[] scores = new int[]{90,85, 55};

        // 총점 - 각 번지수의 점수를 sum 변수에 누적한다.
        int sum =0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        System.out.println("총점 : " + sum);
        double avg = (double) sum / scores.length;
        System.out.printf("평균 : %.1f" + avg);
    }

    /**
     * 학생 3명의 자바 점수를 입력받고, 평균점수를 출력
     * - int[] 사용
     *
     *
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        int[] students = new int[3];
        double sum =0;
        for (int i = 0; i < students.length ; i++) {
            System.out.print("학생"+i +"점수 입력: ");
            students[i] = sc.nextInt();
            sum += students[i];
        }

        System.out.println("평균 점수: "+ sum/3);

    }

    /**
     * char[]에 알파벳 소문자 순서대로 저장하고 출력하기
     */
    public void test3() {
        char[] alphabets = new char[26];

        // 값대입
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char) ('a' + i); // char , byte , short는 int로 바뀌어서 연산 됨
        }

        // 값 조회
//        for (int i = 0; i < alphabets.length; i++) {
//            System.out.println(alphabets[i]);
//            if (i != alphabets.length - 1) {
//                System.out.println(", ");
//            }
//        }
        for (int i = 0; i < alphabets.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.println(alphabets[i]);
        }
    }
}
