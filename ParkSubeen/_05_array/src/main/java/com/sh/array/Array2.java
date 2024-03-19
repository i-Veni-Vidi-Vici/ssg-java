package com.sh.array;


import java.util.Scanner;

public class Array2 {
    /**
     * 배열
     * - 관련있고 동일한 자료형의 데이터를 처리하는데 적합
     * - 점수데이터, 이름데이터 등
     */
    public void test1() {
        // 국어 90, 영어 85, 수학 55 -> 총점/평균
        int[] scores = new int[]{90, 85, 55};

//        int[] scores = new int[3];
//        scores[0] = 90;
//        scores[1] = 85;
//        scores[2] = 55;

        // 총점 - 각 번지수의 점수를 sum 변수에 누적한다.
        int sum = 0;
//        sum += scores[0];
//        sum += scores[1];
//        sum += scores[2];

        for(int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        System.out.println("총점 : " + sum);
        double avg = (double) sum / scores.length;
        System.out.printf("평균 : %.2f", avg); // printf 반올림처리 (.1f -> 소수점 첫째자리까지, .2f -> 소수점 둘째자리까지 ...)
    }

    /**
     * 학생 3명의 자바 점수를 입력받고, 평균점수를 출력
     * - int[] 사용
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[3]; // 크기는 무조건 배열 할당시에 지정해야 하고, 변경할 수 없다.
        int sum = 0;

        for(int i = 0; i < scores.length; i++) {
            System.out.print("학생" + (i + 1) + " 점수 입력 : ");
            scores[i] += sc.nextInt();
            sum += scores[i];
        }
        double avg = (double) sum / scores.length;
        System.out.println("-------------------");
        System.out.printf("학생들의 평균 점수는 %.1f점입니다.\n", avg);
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
//        // ...
//        alphabets[25] = 'z';

        for(int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char) (i + 'a');
        }
        // 값조회
        for(int i = 0; i < alphabets.length; i++) {
            // 내 코드
            if(i < alphabets.length - 1) {
                System.out.print(alphabets[i] + ", ");
            } else {
                System.out.print(alphabets[i]);
            }
            // 강사님 코드1
//            System.out.print(alphabets[i]);
//            if(i != alphabets.length - 1) {
//                System.out.print(", ");
//            }
            // 코드2
//            if(i != 0)
//                System.out.println(", ");
//            System.out.println(alphabets[i]);
        }
    }
}
