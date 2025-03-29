package com.sh.array;

import java.util.Scanner;

public class Array2 {

    /**
     * 배열 - 관련있고 동일한 자료형의 데이터를 처리하는데 적합하다.
     * ex) 점수데이터, 이름데이터 등
     */
    public void test1() {
        // 국어 90, 영어 85, 수학 55 -> 총점, 평균
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
//        double avg = sum / 3; // 원하는 double 값이 나오지 않음. int값은 double에 대입하는 건 맞지 않음
                                // 3이라고 적는 것도 magic number
//        double avg = sum / 3.0; // 따라서 이렇게 적거나
        double avg = (double)sum / scores.length; // 소수점 이하까지 원하면 이렇게 적으면 된다.
//        System.out.printf("평균 : " + avg); // 32줄과 같은 의미
        System.out.printf("평균 : %.1f", avg); // printf 반올림해서 첫번쨰 자리까지 보고 싶을 때 "%.1f" 이런 식으로 하면 된다
    }

    /**
     * 학생 3명의 자바 점수를 입력받고, 평균점수를 출력
     * - int[] 사용
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[3]; // 자바 점수 입력, 배열의 크기(new int[배열의 크기])는 반드시 처음부터 지정해야 하고 변경할 수 없다.
        int sum = 0;

        for(int i = 0; i < scores.length; i++) {
            System.out.print("학생" + (i + 1) + " 점수 입력 : "); // 학생1,2,3을 나타내는 것 = i + 1
            scores[i] = sc.nextInt();
            sum += scores[i];

        }
        double avg = sum / 3.0;
        System.out.printf("학생들의 평균 점수는 %.1f입니다.\n", avg);
    }

    /**
     * char[]에 알파벳 순서대로 저장하고 출력하기 // char[]를 char배열이라고 읽는다
     */
    public void test3() {
        char[] alphabets = new char[26]; // 이 때 크기는 처음에 지정해야 하고 변경할 수 없다.
//        alphabets[0] = 'a';
//        alphabets[1] = 'b';
//        alphabets[2] = 'c';
//        alphabets[3] = 'd';
//        // ....
//        alphabets[25] = 'z'; // 스스로 규칙을 작성해보자

        // 값 대입
        for(int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char)(i + 'a');
        }
//        // 값 조회
//        for(int i = 0; i < alphabets.length; i++) { //z 뒤에는 콤마를 찍고 싶지 않다는 내용의 식
//            System.out.print(alphabets[i]);
//            if (i != alphabets.length - 1) {
//                System.out.print(", ");
//            }
//        }

        // 앞에 a는 그대로 두고 ,(콤마) b라는 결과를 도출하는 내용
        for(int i = 0; i < alphabets.length; i++) { //z 뒤에는 콤마를 찍고 싶지 않다는 내용의 식
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.println(alphabets[i]);
        }
    }
}
