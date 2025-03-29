package com.sh.array;

import java.util.Scanner;

public class Array2 {

    /**
     * <pre>
     * 배열
     * - 관련있고 동일한 자료형의 데이터를 처리하는데 적합
     * - 점수 데이터, 이름 데이터 등
     * </pre>
     */
    public void test() {
        // 국어 90, 영어 85, 수학 55 -> 총점, 평균 구하기
        int[] scores = new int[] {90, 85, 55};

        // 총점 : 각 번지수의 점수를 sum 변수에 누적
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        System.out.println("총점 : " + sum);
        double avg = (double) sum / scores.length;
        System.out.printf("평균 : %.1f", avg);
    }

    /**
     * 학생 3명의 자바점수를 입력받고, 평균점수 출력
     * - int[] 사용
     */
    public void test2() {
        int[] scores = new int[3];
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i < scores.length; i++){
            System.out.print("> " + (i + 1) + "번 학생 점수 입력 : ");
            int score = sc.nextInt();
            scores[i] = score;
            sum += scores[i]; // sum += score 도 가능
        }
        double avg = (double) sum / scores.length;
        System.out.printf("평균 점수 : %.1f점\n", avg);
    }

    /**
     * char[]에 알파벳 소문자 순서대로 저장하고 출력
     */
    public void test3() {
        char[] alphabets = new char[26];
        for (int i = 0; i < alphabets.length; i++){
            alphabets[i] = (char) ('a' + i);
        }
        for (int i = 0 ; i < alphabets.length; i++){
            if (i == (alphabets.length) - 1){
                System.out.print(alphabets[i]);
                break;
            }
            System.out.print(alphabets[i] + ", ");

//            System.out.print(alphabets[i]);
//            if (i != alphabets.length - 1){
//                System.out.println(", ");
//            }

//        for (int i = 0 ; i < alphabets.length; i++) {
//            if(i != 0){
//                System.out.print(", ");
//            }
//            System.out.println(alphabets[i]);
        }


    }
}
