package com.sh.condition._if;

import java.util.Scanner;

/**
 * <pre>
 *if ~ else if 표현식
 * - 조건식1이 참인 경우, 해당 블럭 실행 후 탈출!
 * - 조건식1이 거짓인 경우, 조건식2를 검사
 * - 조건식2이 참인 경우, 해당 블럭 실행 후 탈출!
 * - ...
 *
 * if(조건식1) {
 *      // 조건식 1이 true인 경우 실행코드
 * }
 * else if(조건식2) {
 *     // 조건식 2이 true인 경우 실행코드
 * }
 * ...
 *
 * else {
 *     // 위의 조건식이 모두 거짓인 경우 실행크도
 * }
 * </pre>
 */

public class IfElseIf {
    public void test() {
        Scanner sc = new Scanner(System.in);

        // 금도끼/은도끼/쇠도끼 예제
        System.out.println("풍덩~ 펑!");
        System.out.println("산신령 : 어느것이 네 도끼냐? 1. 금도끼 2. 은도끼 3. 쇠도끼");
        int choice = sc.nextInt();

        if(choice == 1) {
            System.out.println("산신령 : 이런 욕심쟁이~ 어림없다!!!");
        }
        else if (choice == 2) {
            System.out.println("산신령 : 이런 거짓말쟁이~ 어림없다!!!");
        }
        else {
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
        int score;
        char grade;

        System.out.println("> 점수 입력 : ");
        score = sc.nextInt();

//        if((90 <= score) && (score <= 100)) {
//            grade = 'A';
//        } else if((80 <= score) && (score <= 89)) {
//            grade = 'B';
//        } else if((70 <= score) && (score <= 79)) {
//            grade = 'C';
//        } else if((60 <= score) && (score <= 69)) {
//            grade = 'D';
//        } else {
//            grade = 'F';
//        }

        if((90 <= score) && (score <= 100)) {
            grade = 'A';
        } else if((80 <= score)) { // && (score <= 89) 생략해도 똑같다. 이전 조건식1이 거짓이므로
            grade = 'B';
        } else if((70 <= score)) { // && (score <= 79) 생략해도 똑같다. 이전 조건식1이 거짓이므로
            grade = 'C';
        } else if((60 <= score)) { // && (score <= 69) 생략해도 똑같다. 이전 조건식1이 거짓이므로
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println(score + "점은 학점 " + grade + "입니다.");
    }

    /**
     * 학점부여2
     * - 95 ~ 100 -> A+
     * - 90 ~ 94 -> A
     * - 85 ~ 89 -> B+
     * - 75 ~ 79 -> C+
     * - 70 ~ 74 -> C
     * - 65 ~ 69 -> D+
     * - 60 ~ 64 -> D
     * - 0 ~ 59 -> F
     */
    public void test3() {
        Scanner sc = new Scanner(System.in);
        int score;
        String grade;                           // A+는 문자 2개이므로 char가 아닌 String

        System.out.println("> 점수 입력 : ");
        score = sc.nextInt();

        if((95 <= score) && (score <= 100)) {
            grade = "A+";
        } else if(score >= 90) { // && (score <= 94) 생략해도 똑같다. 이전 조건식1이 거짓이므로
            grade = "A";
        } else if(score >= 85) {
            grade = "B+";
        } else if(score >= 80) {
            grade = "B";
        } else if(score >= 75) {
            grade = "C+";
        } else if(score >= 70) {
            grade = "C";
        } else if(score >= 65) {
            grade = "D+";
        } else if(score >= 60) {
            grade = "D";
        } else{
            grade = "F";
        }

        System.out.println(score + "점은 학점 " + grade + "입니다.");
/*
        if(score >= 90 && score <=100) {
           // 90 ~ 100
           grade = "A";

           if(score >= 95) {
                grade += "+";
           }
        } else if (score >= 80) {
           // 80 ~ 89
           grade = "B";

           if(score >= 85) {
                grade += "+";
           }
        } else if(score >= 70) {
           // 70 ~ 79
           grade = "C";

           if(score >= 75) {
                grade += "+";
           }
        } else if(score >= 60) {
           // 60 ~ 79
           grade = "D";

           if(score >= 65) {
                grade += "+";
           }
        } else {
           // 0 ~ 60
           grade = "F";
        }

*/
    }
}




