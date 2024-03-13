package com.sh.condition._if;

import java.util.Scanner;

/**
 * if (조건식 1) {
 * 	//조건식 1이 true인 경우 실행코드
 * }
 * else if(조건식 2) {
 * 	// 조건식 2가 true인 경우 실행 코드
 * }
 * ...
 *
 */
public class IfElseIf {
    public void test() {
        Scanner sc = new Scanner(System.in);
        // 금도끼 , 은도끼 , 쇠도끼 예제
        System.out.println("풍덩 ~ 펑! 🤶");
        System.out.println("산신령 : 어느 것이 네 도끼냐? 1. 금도끼 2. 은도끼 3. 쇠도끼");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("산린령 : 이럼 욕심쟁이~👿");
        }
        else if (choice == 2) {
            System.out.println("산신령 : 거짓말쟁이~🤭");
        }
        else {
            System.out.println("산신령 : 진실된 자는 금도끼/은도끼/쇠도끼를 모두 주마 걸껄🤑");
        }
    }

    /**
     * 학점 부여
     * - 90 ~ 100 -> A
     * - 80 ~ 89 -> B
     * - 70 ~ 79 -> C
     * - 60 ~ 69 -> D
     * - 0 ~ 59 -> F
     */

    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("점수 입력 (0 ~ 100) : ");
        int score = sc.nextInt();
        String grade;

        if(score >= 90) {
            //90 ~ 100
            grade = "A";
        } else if (score >= 80) {
            //80 ~ 89
            grade = "B";
        } else if (score >= 70) {
            //70 ~ 79
            grade = "C";
        } else if (score >= 60) {
            //60 ~ 69
            grade = "D";
        } else {
            //0 ~ 59
            grade = "F";
        }
        System.out.println(score + "점은 학점 " + grade + "입니다.");
    }

    /**
     * 학점 부여2
     * - 95 ~ 100 -> A+
     * - 90 ~ 94 -> A
     * - 85 ~ 89 -> B+
     * - 80 ~ 84 -> B
     * - 75 ~ 79 -> C+
     * - 70 ~ 74 -> C
     * - 65 ~ 69 -> D+
     * - 60 ~ 64 -> D
     * - 0 ~ 59 -> F
     */

    public void test3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("점수 입력 (0 ~ 100) : ");
        int score = sc.nextInt();

         String grade;


        if(score >= 90) {
            if(score <95) {
                //90 ~ 95
                grade = "A";
            } else {
                //95~100
                grade = "A+";
            }
        } else if (score >= 80) {
            if(score <85) {
                //80 ~ 85
                grade = "B";
            } else {
                //85~89
                grade = "B+";
            }
        } else if (score >= 70) {
            if(score <75) {
                //70 ~ 75
                grade = "C";
            } else {
                //75~89
                grade = "C+";
            }
        } else if (score >= 60) {
            if(score <65) {
                //60 ~ 65
                grade = "D";
            } else {
                //95~100
                grade = "D+";
            }
        } else {
            //0 ~ 59
            grade = "F";
        }
        System.out.println(score + "점은 학점 " + grade + "입니다.");
    }
}

