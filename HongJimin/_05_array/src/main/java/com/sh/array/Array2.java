package com.sh.array;

import java.util.Scanner;

public class Array2 {

    /**
     * 배열
     *  - 관련이 있고 동일한 자료형의 데이터를 처리하는데 적합!
     *  - 점수데이터, 이름 데이터 등
     */
    public void test1() {
        //국어 90, 영어 85, 수학 55 -> 총점/평균
        int[] scores = {90, 85, 55};

//        int[] scores = new int[];
//        scores[0] = 90;
//        scores[1] = 85;
//        scores[2] = 55;

        //총점 - 각 번지수의 점수를 sum 변수에 누적한다.
        int sum = 0;
//        sum += scores[0];
//        sum += scores[1];
//        sum += scores[2];

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        System.out.println("총점 : " + sum);
        double avg = (double) sum/ scores.length;
        System.out.printf("평균 : %.2f", avg); // printf로 반올림 처리 .2는 소수 2번째 자리까지 표현하는 식
    }

    /**
     * 학생 3명의 자바 점수를 입력 받고, 평균 점수를 출력하는 것
     * - int [] 사용!
     */

    public void test2 () {
        Scanner sc = new Scanner(System.in);

        int[] scores = new int[3];
        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            System.out.print("학생 " + (i + 1) +" 점수 입력 : ");
            scores[i] = sc.nextInt();
            sum += scores[i];
        }
        System.out.println("======================");
        System.out.println("학생들의 평균 점수는 " + sum/scores.length + "입니다!"); // 소수점은 버리고 표현
//        System.out.println("학생들의 평균 점수는 " + (double)sum/scores.length + "입니다!"); // 실수로 표현
//        System.out.printf("학생들의 평균 점수는 %.2f 입니다!",  + (double)sum/scores.length ); //소수 둘째자리까지 표현
//        System.out.printf("학생들의 평균 점수는 %f 입니다!",  + (double)sum/scores.length ); //소수로 표현
    }

    /**
     * char[] 에 알파벳 소문자 순서대로 저장하고 출력하기
     */

    public void test3() {
        char[] alphabets = new char[26];

        //값 대입
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char) ('a' + i);
        }

        //값 조회
        for (int i = 0; i < alphabets.length-1; i++) {
            System.out.print(alphabets[i] + ", ");
        }
        System.out.println(alphabets[alphabets.length-1]);

        //값 조회 2
        for (int i = 0; i < alphabets.length; i++) {
            System.out.print(alphabets[i]);
            if (i != alphabets.length -1) {
                System.out.print(", ");
            }
        }

        //값 조회 3
        for (int i = 0; i < alphabets.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(alphabets[i]);

        }
    }
}
