package com.sh.array;


import java.util.Scanner;

/**
 * <pre>
 *     배열
 *     - 관련있고 동일한 자료형의 데이터를 처리하는데 적합
 *     - 점수 데이터, 이름 데이터 등
 * </pre>
 */
public class Array2 {
    public void test1() {
        int[] scores = {90, 85, 55};

        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            sum = sum + scores[i];
        }

        System.out.println(sum);

        double avg = (double) sum / scores.length;
        System.out.printf("평균 : %.1f",avg);
    }


    /**
     * 학생 3명의 자바 점수를 입력받고, 평균 점수를 출력
     * - int[] 사용
     */
    public void test2(){
        int[] scores;
        Scanner sc = new Scanner(System.in);

        System.out.print("학생 수 입력 : ");
        int num = sc.nextInt();

        scores = new int[num];

        int sum = 0;
        for (int i = 0; i < num; i++) {
            System.out.printf("학생%d 점수 입력 : ", i + 1);
            scores[i] = sc.nextInt();
            sum = sum + scores[i];
        }
        System.out.println();
        System.out.println("-------------------------");

        double avg = (double) sum / scores.length;
        System.out.printf("학생들의 평균 점수는 %.1f점 입니다.",avg);
    }

    public void test3(){
        char[] alphabets = new char[26];

        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char) (97 + i);
            System.out.print(alphabets[i]);
            if (i != alphabets.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
