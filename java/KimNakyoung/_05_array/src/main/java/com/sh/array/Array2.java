package com.sh.array;

import java.util.Scanner;

/**
 *
 * 배열
 * - 관련있고 동일한 자료형의 데이터를 처리하는데 적합
 * - 점수데이터, 이름데이터
 *
 */


public class Array2 {
    public void test(){
       // 국어 90, 영어 85, 수학 55 -> 총점/평균
        int[] scores = new int[]{90,85,55};
//        int[] scores = new int[3];
//        scores[0] = 90;
//        scores[1] = 85;
//        scores[2] = 55;

        // 총점 - 각번지수의 점수를 sum 변수에 누적한다.

        int sum =0;
//        sum += scores[0];
//        sum += scores[1];
//        sum += scores[2];

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        System.out.println(sum);
        double avg = (double)sum / scores.length;
        // 한쪽에만 형변환 해주면 된다! (double)

//        double avg = sum / 3.0; // 이렇게 해야되는데 매직넘버임
//        double avg = sum / scores.length; //이러면 정수로 나눠서 소숫점 자릿수가 안나옴

//        System.out.println("평균 :" + avg);
        System.out.printf("평균: %.2f",avg); // printf 반올림 결과
    }

    /**
     * 학생 3명의 자바 점수를 입력받고, 평균점수를 출력
     * - int[] 사용
     *
     *
     */


    public void test2() {
        Scanner sc = new Scanner(System.in);
        int[] Scores = new int[3]; // 배열의 크기는 반드시 정해줘야한다 값을 넣든 안 넣든 무조건!! 변경 불가능
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            System.out.print("학생" + (i + 1) +"점수 입력 : ");
            Scores[i] = sc.nextInt();
            sum += Scores[i];
        }
        double avg = (double) sum / Scores.length ;
        System.out.printf("학생들의 평균 점수는 %.2f점입니다.", avg);


    }


    /**
     *
     * char[]에 알파벳 소문자 순서대로 저장하고 출력하기
     */
    public void test3(){
        char[] alphabets = new char[26];

        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char) (i + 'a'); // 아스키코드 규칙이 있어서 가능
        }
        //값 조회
//        for (int i =0; i <alphabets.length ; i++) {
//            System.out.print(alphabets[i]);
//            if(i != alphabets.length - 1){
//                System.out.print(","); // 마지막에 안 찍기
//            }
            for(int i =0; i < alphabets.length; i++){
                if(i != 0) {
                    System.out.println(", ");
                    System.out.println(alphabets[i]);
                }

            }
    }


//    public void ee(){
//        int[] a = new int[2]; // 배열 선언과 동시에 선언
//        int[] b = {50,60}; // 배열 초기화 ( 선언 객체 할당 인덱스별 값 대입)
//        // int[] b = new int[] {50,60};
//        System.out.println(b[0]);
//
//
//    }





}
