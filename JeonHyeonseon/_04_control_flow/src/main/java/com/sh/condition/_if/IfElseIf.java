package com.sh.condition._if;

import java.util.Scanner;

/**
 * if ~ else if 표현식
 * - 조건식1이 참인 경우, 해당블럭 실행후 탈출!
 * - 조건식1이 거짓인 경우, 조건식2 검사
 * - 조건식2가 참인 경우, 해당블럭 실행후 탈출!
 * - ...
 *
 * if(조건식1) {
 *     // 조건식1이 true인 경우 실행코드
 * }
 * else if(조건식2) {
 *     // 조건식2이 true인 경우 실행코드
 * }
 * ...
 * else {
 *     // 위의 조건식이 모두 거짓인 경우 실행코드
 * }
 *
 */
public class IfElseIf {
    public void test() {
        Scanner sc = new Scanner(System.in);
        // 금도끼/은도끼/쇠도끼 예제
        System.out.println("풍덩~ 펑!");
        System.out.println("산신령 : 어느 것이 네 도끼냐? 1.금도끼 2.은도끼 3.쇠도끼");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("산신령 : 이런 욕심쟁이~ 어림없다!!!");
        } else if (choice == 2) {
            System.out.println("산신령 : 이런 거짓말쟁이~ 어림없다!!!");
        } else {
            System.out.println("산신령 : 진실된 자는 금도끼/은도끼/쇠도끼를 모두 가질 수 있다. 예따~");
        }
    }

    /**
     * 학점부여
     * - 90 ~ 100 -> A
     * - 80 ~ 89 -> B
     * - 70 ~ 79 -> C
     * - 60 ~ 69 -> D
     * - 0 ~ 59 -> F
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> 점수를 입력하시오(0 ~ 100)");
        int score = sc.nextInt();
        char grade;

        if (score >= 90 && score <= 100) {
            // 90 ~ 100
            grade = 'A';
//                System.out.println("A");
        } else if (score >= 80 && score < 90) {
            // 80 ~ 89
            grade = 'B';
//                System.out.println("B");
        } else if (score >= 70 && score < 80) {
            // 70 ~ 79
            grade = 'C';
//                System.out.println("C");
        } else if (score >= 60 && score < 70) {
            // 60 ~ 69
            grade = 'D';
//                System.out.println("D");
        } else {
            // 0 ~ 59
            grade = 'F';
//                System.out.println("F");
        }
        System.out.println(score + "점은 학점" + grade + "입니다.");
    }

    public void test3() {
        /**
         * 학점부여
         * - 95 ~ 100 -> A+
         * - 90 ~ 94 -> A
         * - 85 ~ 59 -> B+
         * - 80 ~ 84 -> B
         * - 75 ~ 79 -> C+
         * - 70 ~ 74 -> C
         * - 65 ~ 69 -> D+
         * - 60 ~ 64 -> D
         * - 0 ~ 59 -> F
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("> 점수를 입력하시오(0 ~ 100)");
        int score = sc.nextInt();
        String grade;

        if(score >= 90) {
            // 90 ~ 99
            grade = "A";
            if (score >= 95) {
                grade += "+";
            }
        } else if (score >= 80) {
            // 80 ~ 89
            grade = "B";
            if(score >= 85) {
                grade += "+";
            }
        } else if (score >= 70) {
            // 70 ~ 79
            grade = "C";
            if(score >= 75) {
                grade += "+";
            }
        } else if (score >= 60){
            // 60 ~ 69
            grade = "D";
            if(score >= 65){
                grade += "+";
            }
        } else {
            // 0 ~ 59
            grade = "F";
        }
        System.out.println(score + "점은 학점" + grade + "입니다.");

    }
}
