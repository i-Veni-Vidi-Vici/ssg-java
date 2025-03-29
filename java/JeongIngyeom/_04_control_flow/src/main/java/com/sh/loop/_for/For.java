package com.sh.loop._for;

import javax.script.ScriptContext;
import java.util.Scanner;

/**
 * <pre>
 * for문 표현식
 *
 * for(초기식; 조건식; 증감식){
 *     반복 실행 구문
 * }
 *
 * - 초기식 : 증감변수 선언
 * - 조건식 : 반복문 실행 여부 결정
 * - 증감식 : 증감변수 증가/감소 처리
 * - 증감변수 : 반복횟수, 반복 시 변하는 값 등을 위해 선언한 변수
 * 실행순서1
 * 1. 초기식
 * 2. 조건식 : true인 경우 | false인 경우 반복문 탈출
 * 3. 블럭 진입 - 반복 실행 구문
 * 4. 증감식 -> 2번 조건식으로 이동
 * </pre>
 */
public class For {
    public void test1() {
        // 1~10까지 출력
        for(int i = 1; i <= 10; i++)
            System.out.println(i + " ");

//        // 증감식이 없다면, i = 1인채로 무한 반복
//        for(int i = 1; i <= 10; )
//            System.out.println(i + " ");
//
//        // 조건식이 없다면(true 작성과 동일), i가 끝없이 증가하며 무한반복
//        for(int i = 1; ; i++)
//            System.out.println(i + " ");
//
//        // 초기식, 조건식, 증감식 모두 없는 경우, 무한반복
//        for( ; ; )
//            System.out.println(i + " ");
    }

    public void test2() {
        // 0~9까지 출력
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // 11~20까지 출력
        for (int i = 11; i <= 20; i++) {
            System.out.println(i);
        }

        // 1~19까지 홀수만 출력
        for (int i = 1; i < 20; i += 2) {
            System.out.println(i);
        }

        // 10~1까지 출력
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }

        // 20~2까지 짝수만 출력
        for (int i = 20; i >= 2; i -= 2) {
            System.out.println(i);
        }

        // 20~1까지 출력
        for (int i = 20; i > 0; i--) {
            System.out.println(i);
        }
    }

    /**
     * - 언제 반복문을 적용해야 하는가
     * - 몇번 반복해야 하는가
     * - 매턴마다 달라지는 부분은 어떻게 처리할 것인가
     */
    public void test3() {
        Scanner sc = new Scanner(System.in);

        // 5명의 학생 이름을 입력 받아 출력
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + "번 학생 입력 : ");
            String stdt = sc.next();
            System.out.println(i + "번 학생 명 : " + stdt);
        }
    }

    /**
     * 1 ~ 10까지 합 구하기
     */
    public void test4() {
        // 누적합을 구할 변수는 0으로 초기화한다.
        // 누적곱을 구할 변수는 1로 초기화한다.
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
            System.out.println(sum);
        }

        // 실수 포인트 : sum변수를 for문 블럭 안에 선언하면 안된다. 외부에서 접근 불가
    }

    /**
     * 1부터 난수까지의 합 구하기
     * - 난수 범위 6 ~ 10
     */
    public void test5() {
        // 난수가 6일 때, 1 ~ 6까지의 합
        // 난수가 7일 때, 1 ~ 7까지의 합
        // 난수가 8일 때, 1 ~ 8까지의 합
        // 난수가 9일 때, 1 ~ 9까지의 합
        // 난수가 10일 때, 1 ~ 10까지의 합
        int n = (int) (Math.random() * 5) + 6;
        System.out.println(n);
        int sum = 0;

//        if (n == 6) {
//
//        } else if (n == 7) {
//
//        } else if (n == 8) {
//
//        } else if (n == 9) {
//
//        } else if (n == 10) {
//
//        }

        // 반복 횟수, 증감변수가 난수에 따라 결정됨
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    /**
     * 사용자로부터 입력받은 단수(2 ~ 9)의 구구단 출력
     */
    public void test6() {
        System.out.print("- 숫자 입력 : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("- " + n + "단 출력");
        for (int i = 1; i <= 9; i++) {
//            System.out.println(n + " x " + i + " = " + n * i);

            // %d 정수, %f 실수, %s 문자열
            // printf는 기본적으로 개행을 지원하지 않는다.
            System.out.printf("%d x %d = %d\n", n, i, n * i);
        }
    }
}
