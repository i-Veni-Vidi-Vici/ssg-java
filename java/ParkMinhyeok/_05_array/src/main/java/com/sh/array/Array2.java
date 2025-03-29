package com.sh.array;

import java.util.Scanner;

public class Array2 {
    public void test() {

    }
    /**
     * 학생 3명의 자바 점수를 입력받고, 평균점수를 출력
     * - int[] 사용
     */
    public void test2() {
        Scanner scanner = new Scanner(System.in);
        int[] studentScores;
        int sum = 0;

        System.out.println("학생 수 입력: ");
        int num = scanner.nextInt();
        studentScores = new int[num];

        for (int i = 0; i < studentScores.length; i++) {
            System.out.println("학생" +  (i + 1) + " 점수 입력 : ");
            studentScores[i] = scanner.nextInt();
            sum += studentScores[i];
        }
        System.out.println("------------------");
        System.out.println("학생들의 평균 점수는 : " + ((double)(sum / studentScores.length)) + "점 입니다.");
    }
    /**
     * char[]에 아라벳 순서대로 저장하고 출력하기
     */
    public void test3() {
        char[] alphabets = new char[26];
        // 값대입
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char) (i + 'a');
        }
        // 값조회
        for (int i = 0; i < alphabets.length; i++) {
            System.out.print(alphabets[i] );
            if (i != alphabets.length-1) {
                System.out.print(", ");
            }
        }
    }
}
