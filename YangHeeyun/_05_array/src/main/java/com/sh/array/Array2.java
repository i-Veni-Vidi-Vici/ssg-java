package com.sh.array;

import java.util.Scanner;

/**
 * 배열 - 관련있고 동일한 자료형의 데이터를 처리하는데 적합하다.
 * - 점수 데이터, 이름데이터 등
 */
public class Array2 {
    public void test() {
        // 국어90,영어85,수학55->총점/평균
//        int[] scores = new int[3];
//        scores[0]=90;
//        scores[1]=85;
//        scores[2]=55;
        int[] scores = new int[] {90,85,55};

        // 총점 - 각 번지수의 점수를 sum 변수에 누적한다.
        int sum=0;
//        sum += scores[0];
//        sum += scores[1];
//        sum += scores[2];

        for(int i=0;i<scores.length;i++){
            sum += scores[i];
        }
        System.out.println("총점 : " + sum);
        double avg = (double) sum/ scores.length; //double로 선언해도 계산하는 자료형이 모두 int면 int 답이 나오므로 double로 형변환 해준다.
        System.out.printf("평균 : %.2f" , avg); // printf 반올림처리
    }

    /**
     * 학생 3명의 자바 점수를 입력받고, 평균점수를 출력
     * - int[] 사용
     */
    public void test2(){
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[3]; // 크기는 무조건 배열 할당시에 지정해야 하고, 변경할 수 없다.
        int sum =0;

        for(int i=0;i<3;i++){
            System.out.printf("학생%d 점수 입력 : ",i+1);
            scores[i] = sc.nextInt();
            sum += scores[i];
        }
        double avg=(double) sum / scores.length;

        System.out.println("--------------------");
        System.out.printf("학생들의 평균 점수는 %.1f점 입니다.",avg) ;
    }

    /**
     * char[]에 알파벳 순서대로 저장하고 출력하기
     */
    public void test3(){
        char[] alphabets = new char[26];

        // 값 대입
        for(int i=0;i< alphabets.length;i++){
            alphabets[i] = (char) (i+'a');
        }
        // 값 조회
//        for(int i=0;i< alphabets.length;i++){
//            System.out.print(alphabets[i]);
//            if(i != alphabets.length-1){
//                System.out.print(", ");
//            }
//        }

        for(int i=0;i< alphabets.length;i++){
            if(i != 0){
                System.out.print(", ");
            }
            System.out.print(alphabets[i]);
        }
    }
}
