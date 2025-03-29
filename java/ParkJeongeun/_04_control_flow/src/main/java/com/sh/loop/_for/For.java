package com.sh.loop._for;

import java.util.Scanner;

/**
 * <pre>
 * for문 표현식
 * for(초기식; 조건식; 증감식) {
 *     // 반복실행구문
 * }
 *
 * - 초기식 : 증감변수 선언
 *        * 증감변수 : 반복횟수, 반복시 변하는 값 등을 위해 선언한 변수
 * - 조건식 : 반복문 실행여부
 * - 증감식 : 증감변수 증가/감소 처리
 *
 * 실행순서
 * 1. 초기식
 * 2. 조건식 : true인 경우 계속 실행 / false인 경우에는 반복문 탈출
 * 3. 블럭진입 : 반복실행구문 실행
 * 4. 증감식 -> 2번 조건식 이동
 *
 * </pre>
 */

public class For {
    public void test() {
        // 1 ~ 10 반복
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(i);
//        }
        // 증감식이 없다면, i=1인채로 무한반복
//        for (int i = 1; i <= 10;) {
//            System.out.println(i);
//        }
        // 조건식이 없다면, true 작성과 동일 -> i가 끝없이 증가하며 무한반복
//        for (int i = 1; ; i++) {
//            System.out.println(i);
//        }
        // 초기식, 조건식, 증감식 모두 없는 경우 : 무한반복
        for (; ;) {
            System.out.println("hello world");
        }
    }

    /**
     * 반복횟수 몇번인지
     * 증감변수 범위는 어디서부터 어디까지인지
     */

    public void test2 () {
        // 0 ~ 9까지 출력
//        for(int i = 0; i <= 9; i++) {
//            System.out.println(i);
//        }
        // 11 ~ 20까지 출력
//        for(int i = 11; i < 21; i++) {
//            System.out.println(i);
//        }
        // 1~20까지 중 홀수만 출력
//        for(int i = 1; i <= 20; i = i + 2) { // 증감식 i += 2로 작성가능
//            System.out.println(i);
//        }
        // 10 ~ 1까지 출력 (10번 반복, 증감변수 범위 10~1)
//        for(int i = 10; i >= 1; i--) {
//            System.out.println(i);
//        }
        // 20 ~ 1까지 중 짝수만 출력
        for(int i = 20; i >= 1; i -= 2) {
            System.out.println(i);
        }
    }

    /**
     * 언제 반복문을 적용해야 하는가 : 반복되는 내용을 실행문으로 넣기
     * 몇번 반복해야 하는가
     * 매 턴마다 달라지는 부분은 어떻게 처리할 것인가
     */
    public void test3 () {
        // 5명의 학생이름을 입력받아 출력
        Scanner sc = new Scanner(System.in);

//        System.out.println("1번 학생 입력 : ");
//        String stdt1 = sc.next();
//        System.out.println("1번 학생명 : " + stdt1);
//
//        System.out.println("2번 학생 입력 : ");
//        String stdt2 = sc.next();
//        System.out.println("2번 학생명 : " + stdt2);
//
//        System.out.println("3번 학생 입력 : ");
//        String stdt3 = sc.next();
//        System.out.println("3번 학생명 : " + stdt3);
//
//        System.out.println("4번 학생 입력 : ");
//        String stdt4 = sc.next();
//        System.out.println("4번 학생명 : " + stdt4);
//
//        System.out.println("5번 학생 입력 : ");
//        String stdt5 = sc.next();
//        System.out.println("5번 학생명 : " + stdt5);

        // 반복횟수 5번
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + "번 학생 입력 : ");
            String stdt = sc.next();
            System.out.println(i + "번 학생명 : " + stdt);
        }
    }

    /**
     * 1 ~ 10까지 합 구하기
     */
    public void test4() {
        // 누적합을 구할 변수는 0으로 초기화
        // 누적곱을 구할 변수는 1로 초기화
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

        // 10번 반복, 1 ~ 10
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);

        // 실수포인트 : sum변수를 for문 블럭 안에 선언하면 안됨 (외부에서 접근불가하고 매턴마다 0으로 초기화되기때문)
    }

    /**
     * 1부터 난수까지 합 구하기
     * - 난수범위 6~10까지 구하기
     */
    public void test5() {
        // 난수가 6일때 1 ~ 6까지의 합
        // 난수가 7일때 1 ~ 7까지의 합
        // 난수가 8일때 1 ~ 8까지의 합
        // 난수가 9일때 1 ~ 9까지의 합
        // 난수가 10일때 1 ~ 10까지의 합

        int n = (int) (Math.random() * 5) + 6;
        System.out.println(n);
        int sum = 0;
//        if (n == 6){
//            for (int i = 1; i <= 6; i++) {
//                sum += i;
//            }
//
//        } else if (n == 7) {
//            for (int i = 1; i <= 7; i++) {
//                sum += i;
//            }
//
//        } else if (n == 8) {
//            for (int i = 1; i <= 8; i++) {
//                sum += i;
//            }
//
//        } else if (n == 9) {
//            for (int i = 1; i <= 9; i++) {
//                sum += i;
//            }
//
//        } else {
//            for (int i = 1; i <= 10; i++) {
//                sum += i;
//            }
//        }

        // 반복횟수, 증감변수의 범위를 난수에 따라 결정
        for (int i = 1; i <= n; i++) {
                sum += i;
            }
        System.out.println(sum);
    }

    /**
     * 사용자로부터 입력받은 단수(2 ~ 9)의 구구단 출력
     */
    public void test6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("단수 입력 (2 ~ 9) : ");
        int num = sc.nextInt();
        System.out.println(num + "단 출력");

        for (int i = 1; i <= 9; i++) {
//            System.out.println(num + "*" + i + "=" + (num * i));
            // %d 정수, %f 실수,  %s 문자열
            // printf는 개행을 지원하지 않기 때문에 \n 사용
            System.out.printf("%d * %d = %d\n", num, i, num * i);
        }

    }
}
