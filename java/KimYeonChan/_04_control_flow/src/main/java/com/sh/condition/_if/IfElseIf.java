package com.sh.condition._if;

import java.util.Scanner;

/**
 * if ~ else if 표현식
 * - 조건식1이 참인경우, 해당블럭 실행 후 탈출
 * - 조건식 1이 거짓인 경우, 조건식 2 검사
 * - ...
 * if (조건식1) {
 *     조건식1이 true 일때
 * }
 * else if (조건식2) {
 *     조건식2이 true 일때
 * }
 */
public class IfElseIf {
    public void test1() {
        Scanner sc = new Scanner(System.in);
        // 금도끼/은도끼/쇠도끼
        System.out.println("풍덩~ 펑!");
        System.out.println("산신령: 어느것이 네 도끼냐? 1. 금도끼 2. 은도끼 3. 쇠도끼");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("산신령: 이런 욕심쟁이~");
        }
        else if (choice == 2) {
            System.out.println("산신령: 이런 욕심쟁이~");
        }
        else {
            System.out.println("산신령: 착하군");
        }
    }

    /**
     * 학점부여
     * - 100~90: A
     * - 89~80: B
     * - 79~70: C
     * - 69~60: D
     * - 59~0: F
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("점수: ");
        int score = sc.nextInt();
        char grade;

        if (score >= 90) {
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
            grade = 'F';
        }

        System.out.println(score + "점은 학점" + grade + "입니다.");
    }

    public void test3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("점수: ");
        int score = sc.nextInt();
        String grade = null;

        if (score >= 0 && score <= 100) {
            if (score >= 90) {
                grade = "A";
                if (score >= 95) {
                    grade += "+";
                }
            }
            else if (score >= 80) {
                grade = "B";
                if (score >= 85) {
                    grade += "+";
                }
            }
            else if (score >= 70) {
                grade = "C";
                if (score >= 75) {
                    grade += "+";
                }
            }
            else if (score >= 60) {
                grade = "D";
                if (score >= 65) {
                    grade += "+";
                }
            }
            else {
                grade = "F";
            }
        }
        else {
            System.out.println("유호하지 않은 수입니다.");
        }

        System.out.println(score + "점은 학점" + grade + "입니다.");
    }
}
