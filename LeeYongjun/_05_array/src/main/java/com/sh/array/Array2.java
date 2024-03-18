package com.sh.array;


import java.util.Scanner;

public class Array2 {
    /**
     * 배열 - 관련있고 동일한 자료형의 데이터를 처리하는데 적합하다.
     * - 점수데이터 , 이름데이터 등
     */
    public void test1() {
        //국어 90, 영어 85 , 수학 55 -> 총점/평균

        int[] score = {90, 85, 55};

        // 총점 - 각 번지수의 점수를 sum변수에 누적한다.
        int sum = 0;
        for(int i = 0; i < score.length; i++){
            sum += score[i];
        }
        System.out.println("총점은 : " + sum);
        double avg = (double) sum / score.length;
        System.out.printf("평균 : %.1f", avg); //printf로 반올림처리
    }

    /**
     * 학생 3명의 자바 점수를 입력받고,평균점수를 출력.
     * - int[] 사용
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);

        int[] score = new int[3];
        int sum = 0;
        for(int i = 0; i < score.length; i++){
            System.out.print("학생" + (i + 1) + "의 점수입력 : ");
            score[i] = sc.nextInt();
            sum += score[i];
        }
        System.out.println("----------------------");
        double avg = (double) sum / score.length;
        System.out.printf("학생들의 평균 점수는 : %.1f점입니다.", avg);
    }
    /**
     * char[]에 알파벳 소문자 순서대로 저장하고 출력하기
     */
    public void test3() {
        char[] alphabets = new char[26];
        // 값 대입
        for(int i = 0; i < alphabets.length; i++){
            alphabets[i] = (char) (i + 'a');
        }
        // 값 조회
        for(int i = 0; i < alphabets.length; i++){
            if(i == alphabets.length - 1){
                System.out.print(alphabets[i] + " ");
            }
            else{
                System.out.print(alphabets[i] + ", ");
            }
        }
    }
}

