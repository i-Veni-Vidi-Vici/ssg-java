package com.sh.condition._if;

import java.util.Scanner;

/**
 * - if ~ else if 표현식
 * 1. 조건식1이 참인 경우, 해당 블럭 실행 후 탈출!
 * 2. 조건식1이 거짓인 경우, 조건식2를 검사
 * 3. 조건식2가 참인 경우, 해당 블럭 실행 후 탈출!
 * 4. ...
 *
 * if(조건식1) {
 *     // 조건식1이 true인 경우 실행코드
 * }
 * else if(조건식2) {
 *     // 조건식2가 true인 경우 실행코드
 * }
 * else if(조건식3) {
 *     // 조건식3이 true인 경우 실행코드
 * }
 * ...
 * else {
 *     // 위의 조건식이 모두 거짓인 경우 실행코드
 * }
 */
public class IfElseIf {
    public void test() {
        Scanner sc = new Scanner(System.in);
        // 금도끼/은도끼/쇠도끼 예제
        System.out.println("풍덩~ 펑!");
        System.out.println("산신령 : 어느것이 네 도끼냐? 1. 금도끼 2. 은도끼 3. 쇠도끼");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("산신령 : 이런 욕심쟁이! 어름없다!!");
        }
        else if (choice == 2) {
            System.out.println("산신령 : 이런 거짓말쟁이! 어림없다!!");
        }
        else {
            System.out.println("산신령 : 진실된 자는 모든 도끼를 가질 수 있다. 가져가거라");
        }
    }

    /**
     * 문제3. 학점부여
     * 90 ~ 100 -> A
     * 80 ~ 89 -> B
     * 70 ~ 79 -> C
     * 60 ~ 69 -> D
     * 0 ~ 59 -> F
     */
    public void test2() {
        System.out.println("점수 입력 (0 ~ 100) : ");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        char grade;

        if (score >= 90 && score <= 100) {
            grade = 'A';
        }
        else if (score >= 80) {
            grade = 'B';
        }
        else if (score >= 70) {
            grade = 'C';
        }
        else if (score >= 60) {
            grade = 'D';
        }
        else {
            grade ='F';
        }
        System.out.println(score + "점은 학점 " + grade + " 입니다.");
    }

    /**
     * 문제4. 학점부여
     * 95 ~ 100 -> A+
     * 90 ~ 94  -> A
     * 85 ~ 89  -> B+
     * 80 ~ 84  -> B
     * 75 ~ 79  -> C+
     * 70 ~ 74  -> C
     * 65 ~ 69  -> D+
     * 60 ~ 64  -> D
     * 0 ~ 59   -> F
     */
    public void test3() {
        System.out.println("점수 입력 (0 ~ 100) : ");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        String grade;

        if (score >= 90 && score <= 100) {
            if (score >= 95) {
                grade = "A+";
            }
            else {
                grade = "A";
            }
        }
        else if (score >= 80) {
            if (score >= 85) {
                grade = "B+";
            }
            else {
                grade = "B";
            }
        }
        else if (score >= 70) {
            if (score >= 75) {
                grade = "C+";
            }
            else {
                grade = "C";
            }
        }
        else if (score >= 60) {
            if (score >= 65) {
                grade = "D+";
            }
            else {
                grade = "D";
            }
        }
        else {
            grade ="F";
        }
        System.out.println(score + "점은 학점 " + grade + " 입니다.");
    }

}
