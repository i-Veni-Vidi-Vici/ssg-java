package com.sh.loop._for;

import java.util.Random;
import java.util.Scanner;

/**
 * <pre>
 *
 * for문 표현식
 * for(초기식;조건식;증감식) {
 *     // 반복실행구문 작성
 * }
 *
 * - 초기식 : 증감변수 선언
 * - 조건식 : 반복문 실행여부
 * - 증감식 : 증감변수 증가/감소처리
 * - 증감변수 : 반복횟수, 반복시 변하는 값 등을 위해 선언한 변수
 *
 * 실행순서
 * 1. 초기식
 * 2. 조건식 : true인 경우 | false인 경우 반복문 탈출
 * 3. 블럭 진입 - 반복실행구문
 * 4. 증감식 -> 2번 조건식으로 이동
 *
 * </pre>
 */
public class For {
    public void test1() {
//        int i;
//        // 1 ~ 10 까지 출력
//        for (i = 1; i < 11; i++) {
//            System.out.println("for문 : " + i);
//        }
//        System.out.println("i = " + i); // i는 증감식까지 수행 후 11이 됨

        // 증감식이 없다면, i=1인 채로 무한반복
        for (int i = 1; i <= 10;) { // Condition 'i <= 10' is always 'true'
            System.out.println(i);
        }

        // 조건식이 없다면(true 작성과 동일), i는 1씩 무한증가 무한반복
        for (int i = 1; ; i++) { // for (int i = 1; true ; i++)
            System.out.println(i);
        }

        // 초기식, 조건식, 증감식이 모두 없는 경우, 무조건 무한반복
//        for (; ; ) {
//            System.out.println("helloworld");
//        }
    }

    /**
     * - 반복횟수 n번
     * - 증감변수 범위 start ~ end
     */
    public void test2() {
        // 0 ~ 9까지 출력
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // 11 ~ 20까지 출력 (10번, 11 ~ 20)
        for (int i = 11; i < 21; i++) {
            System.out.println(i);
        }

        // 1 3 5 7 9 11 13 15 17 19 홀수 출력
        for (int i = 1; i < 20; i += 2) {
            System.out.println(i);
        }
        for (int i = 1; i < 20 ; i ++) {
            if (i % 2 == 1)
                System.out.println(i);
        }
        for(int i = 0; i<=9; i++){
            System.out.println(2*i+1);
        }

        //10 ~ 1까지 출력 (10번, 10 ~ 1)
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }

        // 20 18 16 14 12 10 8 6 4 2
        for (int i = 20; i > 0; i -= 2) {
            System.out.println(i);
        }
        for (int i = 20; i > 0; i--) {
            if (i % 2 == 0)
                System.out.println(i);
        }
    }

    /**
     * - 언제 반복문을 적용해야 하는가
     * - 몇번 반복해야 하는가
     * - 매턴마다 달라지는 부분은 어떻게 처리할 것인가
     */
    public void test3() {
        // 10명의 학생이름 입력받아 출력
        Scanner sc = new Scanner(System.in);
//        System.out.println("1번 학생 입력 : ");
//        String stdt1 = sc.next();
//        System.out.println("1번 학생명  : " + stdt1);
//        System.out.println("2번 학생 입력 : ");
//        String stdt2 = sc.next();
//        System.out.println("2번 학생명  : " + stdt2);
//        System.out.println("3번 학생 입력 : ");
//        String stdt3 = sc.next();
//        System.out.println("3번 학생명  : " + stdt3);
//        System.out.println("4번 학생 입력 : ");
//        String stdt4 = sc.next();
//        System.out.println("4번 학생명  : " + stdt4);
//        System.out.println("5번 학생 입력 : ");
//        String stdt5 = sc.next();
//        System.out.println("5번 학생명  : " + stdt5);

        for (int i = 1; i < 6; i++) {
            System.out.println(i + "번 학생 입력 : ");
            String stdt = sc.nextLine();
            System.out.println(i + "번 학생명 : " + stdt);
        }
    }

    public void test4() {
        // 누적합을 구할 변수는 0으로 초기화한다.
        // 누적곱을 구할 변수는 1로 초기화한다.
        int sum = 0;
//        sum += 1;
//        sum += 2;
//        sum += 3;
//        sum += 4;
//        sum += 5;
//        sum += 6;
//        sum += 7;
//        sum += 8;
//        sum += 9;
//        sum += 10;
//        System.out.println(sum);
//
//        sum = 0;
        for (int i = 1; i <= 10 ; i++ ) {
            sum += i;
        }
        System.out.println(sum);

        // 실수 포인트 : sum변수를 for문 안에 선언하면 안된다. 외부에서 접근불가, 매턴마다 0으로 초기화됨.
    }

    /**
     * 1부터 난수까지의 합 구하기
     * 난수는 6 ~ 10
     */
//            if(n == 6) {
//            sum += 1;
//            sum += 2;
//            sum += 3;
//            sum += 4;
//            sum += 5;
//            sum += 6;
//        } else if (n == 7) {
//            sum += 1;
//            sum += 2;
//            sum += 3;
//            sum += 4;
//            sum += 5;
//            sum += 6;
//            sum += 7;
//        } else if (n == 8) {
//            sum += 1;
//            sum += 2;
//            sum += 3;
//            sum += 4;
//            sum += 5;
//            sum += 6;
//            sum += 7;
//            sum += 8;
//        } else if (n == 9) {
//            sum += 1;
//            sum += 2;
//            sum += 3;
//            sum += 4;
//            sum += 5;
//            sum += 6;
//            sum += 7;
//            sum += 8;
//            sum += 9;
//        } else {
//            sum += 1;
//            sum += 2;
//            sum += 3;
//            sum += 4;
//            sum += 5;
//            sum += 6;
//            sum += 7;
//            sum += 8;
//            sum += 9;
//            sum += 10;
//        }
//        if(n == 6) {
//        for(int i = 1; i <= 6; i++){
//            sum += i;
//        }
//    } else if (n == 7) {
//        for(int i = 1; i <= 7; i++) {
//            sum += i;
//        }
//    } else if (n == 8) {
//        for(int i = 1; i <= 8; i++) {
//            sum += i;
//        }
//    } else if (n == 9) {
//        for(int i = 1; i <= 9; i++) {
//            sum += i;
//        }
//    } else {
//        for(int i = 1; i <= 10; i++) {
//            sum += i;
//        }
//    }
    public void test5() {
        Random rnd = new Random();
        int num = rnd.nextInt(5) + 6;
        int sum = 0;
        // 반복횟수, 증감변수의 범위를 난수에 따라 결정
        for (int i = 1; i <= num; i++){
            sum += i;
        }
            System.out.println(num + " " + sum);
    }

    /**
     * 사용자로부터 입력받은 단수(2~9)의 구구단 출력
     * - 숫자입력 : 7
     * - 7단출력
     * 7 * 1 = 7
     * 7 * 2 = 14
     * 7 * 3 = 21
     * ...
     */
    public void test6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자입력(2 ~ 9) : ");
        int n = sc.nextInt();
        System.out.println(n + "단 출력");
        for (int i = 1; i <= 9; i++) {
//            System.out.println( n + " * " + i + " = " + n * i );
            // %d 정수, %f 실수, %s 문자열
            // printf는 기본적으로 개행을 지원하지 않는다.
            System.out.printf("%d * %d = %d\n", n, i, n * i);
        }
    }
}
