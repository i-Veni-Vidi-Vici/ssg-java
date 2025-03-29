package com.sh.condition._if;

import java.util.Scanner;

/**
 * if ~ else if 표현식
 * - 조건식1이 참인 경우, 해당 블럭 실행 후 탈출
 * - 조건식1이 거짓인 경우, 조건식 2 검사
 * - 조건식 2가 참인 경우, 해당블럭 실행 후 탈출
 *
 * if(조건식1){} //조건식 1이 true인 경우 실행 코드
 * else if(조건식2) {} // 조건식 2가 true인 경우 실행 코드
 * else //위의 조건식이 모두 거짓인 경우 실행코드
 *
 */
public class IfElseIf
{
    public void test()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("풍덩 ~ 펑 !");
        System.out.println("산신령 : 어느 것이 너꺼냐 ? 1.금도끼 2. 은도끼 3.쇠도끼");
        System.out.print("번호 입력 : ");
        int choice = scanner.nextInt();

        if(choice == 1) System.out.println("산신령 : 욕심쟁이네 어림없다");
        else if(choice == 2) System.out.println("산신령 : 거짓말쟁이 어림없다.");
        else System.out.println("산신령 : 진실된자는 금도끼/은도끼/쇠도끼를 모두 가질 수 있다.");
    }

    //점수를 받아서 학점 부여  100-90 A 80~89 B - 70-79 C 60 -69 D 나머지 f
    public void test2()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("점수 입력 : ");
        int score = scan.nextInt();
        char grade ;


        if(score >= 90 && score<=100) {
            grade = 'A';
            System.out.println("학점 : " + grade);
        }
        else if(score >= 80) {
            grade = 'B';
            System.out.println("학점 : " + grade);
        }
        else if(score >= 70) {
            grade = 'C';
            System.out.println("학점 : " + grade);
        }
        else if(score >= 60) {
            grade = 'D';
            System.out.println("학점 : " + grade);
        }
        else{
            grade = 'F';
            System.out.println("학점 : " + grade);
        }

        System.out.println(score + "점은 학점 " + grade + "입니다. ");
    }

    public void test3()
    {
        //점수를 받아서 학점 부여
        // 100-95 A+
        // 90 - 94 :A
        // 89-85 B +
        // 80~84 B -
        // 75-79 C +
        // 70 - 74 C
        Scanner scan = new Scanner(System.in);
        System.out.print("점수 입력 : ");
        int score = scan.nextInt();
        String grade;

        if(score >= 90) {
            if(score>= 95 && score<= 100)
            {
                grade = "A+";
                System.out.println("학점 : " + grade);
            }
            else
            {
                grade = "A";
                System.out.println("학점 : " + grade);
            }


        }
        else if(score >= 80) {
            if(score>= 85)
            {
                grade = "B+";
                System.out.println("학점 : " + grade);
            }
            else
            {
                grade = "B";
                System.out.println("학점 : " + grade);
            }
        }
        else if(score >= 70) {
            if(score>= 75 )
            {
                grade = "C+";
                System.out.println("학점 : " + grade);
            }
            else
            {
                grade = "C";
                System.out.println("학점 : " + grade);
            }
        }
        else if(score >= 60) {
            if(score>= 65 )
            {
                grade = "D+";
                System.out.println("학점 : " + grade);
            }
            else
            {
                grade = "D";
                System.out.println("학점 : " + grade);
            }
        }
        else{
            grade = "F";
            System.out.println("학점 : " + grade);
        }

        System.out.println(score + "점은 학점 " + grade + "입니다. ");
    }



}
