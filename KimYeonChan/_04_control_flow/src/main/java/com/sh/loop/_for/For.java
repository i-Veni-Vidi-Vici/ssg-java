package com.sh.loop._for;

import java.util.Scanner;

/**
 * for 문 표현식
 * for (초기식; 조건식; 증감식;) {
 *     // 반복 실행할 구문
 * }
 * - 초기식: 증감변수 선언
 * - 조건식: 반복문 실행여부
 * - 증감식: 증감변수 증가/감소처리
 * 실행순서
 * 1. 초기식
 * 2. 조건식: true 인 경우
 * 3. 반복 구문 - 반복실행구문
 * 4. 증감식 - 2번 조건식으로 이동
 */
public class For {
    public void test1() {
        // 1~10까지 출력
//        for (int i = 1; i <= 10; i++) {
//            System.out.print(i);
//        }

        // 증감식이 없다면, i = 1 인채로 무한 반복
//        for (int i = 1; i <= 10;) {
//            System.out.println(i);
//        }

        // 조건식이 없다면(true 작성과 동일), i가 끝없이 증가하며 무한 반복
//        for (int i = 1;  true; i++) {
//            System.out.println(i);
//        }

        // 초기식, 조건식, 증감식 모두 없는 경우
//        for (;;){
//            System.out.println("hello world");
//        }
    }

    public void test2() {
        // 0~9까지 출력
//        for (int i = 0; i < 10; i++) {
//            System.out.print(i);
//        }

        // 11 ~ 20까지 출력
//        for (int i = 11; i <= 20; i++) {
//            System.out.print(i);
//        }

        // 1 3 5 ... 19
//        for (int i = 1; i <= 20; i += 2) {
//            System.out.print(i);
//        }

        // 10~1
//        for (int i = 10; i > 0; i--) {
//            System.out.print(i);
//        }

        // 20 18 16 .. 2
//        for (int i = 20; i > 0; i -= 2) {
//            System.out.print(i);
//        }

        for (int i= 20; i > 0; i--) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }

    /**
     * - 언제 반복문을 적용해야 하는가
     * - 몇번 반복해야 하는가
     * - 매턴마다 달라지는 부분은 어떻게 처리할 것인가
     */
    public void test3() {
        // 5명의 학생이름 입력받아 출력
        Scanner sc = new Scanner(System.in);
//        System.out.println("1번 학생 입력: ");
//        String std1 = sc.next();
//        System.out.println("1번 학생명: " + std1);

        for (int i = 1; i <= 5; i++) {
            System.out.println(i + "번 학생 입력: ");
            String std = sc.next();
            System.out.println(i + "번 학생명: " + std);
        }
    }

    // 1~10까지 합 구하기
    public void test4() {
        // 누적합을 구할 변수는 0으로 초기화한다.
        // 누적곱을 구할 변수는 1로 초기화한다.
        int sum= 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    // 1부터 난수까지의 합 구하기
    // - 난수범위 6~10
    public void test5() {
        int rndNum = (int)(Math.random() * 5) + 6;
        int sum = 0;
        for (int i = 1; i <= rndNum; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    /**
     * 사용자로부터 입력받은 단수(2~9)의 구구단 출력
     */
    public void test6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 입력: ");
        int num = sc.nextInt();
        for (int i = 1; i <=9; i++) {
            // System.out.println(num + " * " + i + " = " + num * i);
            System.out.printf("%d * %d = %d\n", num, i, num * i);
        }
    }
}