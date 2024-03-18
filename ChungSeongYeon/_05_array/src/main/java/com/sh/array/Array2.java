package com.sh.array;
import java.util.Scanner; // 입력 받을 때 사용하는 Scanner 클래스

public class Array2 {
    /**
     * 배열
     * - 관련이 있고 동일한 자료형의 데이터를 처리하는데 적합
     * - 점수 데이터, 이름 데이터 등.
     */

    public void test1() {
        //국어 90, 영어 85, 수학 55 -> 총점/평균
        int[] scores = new int[]{90, 85, 55};

//        int[] scores = new int[3];
//        scores[0] = 90;
//        scores[1] = 85;
//        scores[2] = 55;

        // 총점 - 각 번지 수의 점수를 sum 변수에 누적한다.
        int sum = 0;
//        sum += scores[0];
//        sum += scores[1];
//        sum += scores[2];

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }


        System.out.println("총점 : " + sum);
        double avg = (double) sum / scores.length;
        System.out.println("평균 : " + avg); //%d -> 정수 | %f ->실수 / printf로 반올림 처리


    }

    /**
     *  학생 3명의 자바 점수를 입력 받고, 평균 점수를 출력
     *  - int[] 사용
     *  학생 1 점수 입력: 80
     *  학생 2 점수 입력: 90
     *  학생 3 점수 입력: 100
     *  ------------------
     *  학생들의 평균 점수는 xx.x점 입니다.
     */

    public void test2 () {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[3]; // 크기는 무조건 배열 할당 시에 지정해야 하고, 변경할 수 없다.
        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            System.out.print("학생 " + (i+1) +" 점수 입력 : ");
            scores[i] = sc.nextInt();
            sum += scores[i];
        }
        System.out.println("======================");
        System.out.println("학생들의 평균 점수는 " + sum/scores.length + "입니다.");
        System.out.println("학생들의 평균 점수는 " + (double)sum/scores.length + "입니다.");
        System.out.printf("학생들의 평균 점수는 %.2f 입니다.",  + (double)sum/scores.length );

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

        //값 대입
        for(int i = 0; i < alphabets.length; i++){
            alphabets[i] = (char) (i + 'a');
        }
        //값 조회
        for(int i = 0; i < alphabets.length; i++){
//            if(i < alphabets.length - 1){
//                System.out.println(alphabets[i] + ", ");
//            }
//            else{
//                System.out.println(alphabets[i] + " ");
//            } // 내 답안

//            System.out.println(alphabets[i]);
//            if(i != alphabets.length - 1){
//                System.out.println(", "); //강사님 답안1
//            }
            if(i != 0)
                System.out.println(", ");
            System.out.println(alphabets[i]);
        }
    }


}
