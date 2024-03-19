package com.sh.loop._for;

import com.ssg.test.random.rcp.Main;

import java.util.Scanner;

public class For {
    public void test1() {
        //1 ~ 10 까지 출력
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(i);
//        }

        //증감식이 없다면, i = 1인 채로 무한 반복
//        for (int i = 1; i <= 10;) {
//            System.out.println(i);
//        }

        //조건식이 없다면(true 작성과 동일), i가 1씩 증가하면서 무한 반복됨
//        for (int i = 1; ; i++) {
//            System.out.println(i);
//        }

        //초기식, 조건식, 증감식이 모두 없는 경우
        for (;;) {
            System.out.println("하이");
        }

    }

    /**
     * 반복횟수 n번
     * 증감 변수 범위 start ~ end
     */

    public void test2() {
        //0 ~ 9까지 출력
//        for (int i = 0; i < 10; i ++) {
//            System.out.println(i);
//        }

//        //11 ~ 20까지 출력 (10번, 11 ~ 20)
//        for (int i = 11; i <= 20; i++) {
//            System.out.println(i);
//        }

        //1 3 5 7 9 11 13 15 17 19 (10번, 1 ~19)
//        for (int i = 1; i < 20; i +=2) {
//            System.out.println(i);
//        }

        //10 ~ 1까지 출력(10번, 10 ~ 1)
//        for (int i = 10; i > 0; i--) {
//            System.out.println(i);
//        }

        //20 18 16 14 12 10 8 6 4 2
        for (int i = 20; i > 0; i -= 2) {
            System.out.println(i);
        }
    }

    /**
     * - 언제 반복문을 적용해야 하는가
     * - 몇 번 반복해야 하는가?
     * - 매 턴마다 달라지는 부분은 어떻게 처리할 것인가?
     */

    public void test3() {
        //10명의 학생 이름 입력 받아 출력
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {
            System.out.print( i +"번 학생 입력 : ");
            String std = sc.next();
            System.out.println( i +"번 학생명 : " + std);

        }

//        System.out.print("2번 학생 입력 : ");
//        String std2 = sc.next();
//        System.out.println("2번 학생명 : " + std2);
//
//        System.out.print("3번 학생 입력 : ");
//        String std3 = sc.next();
//        System.out.println("3번 학생명 : " + std3);
//
//        System.out.print("4번 학생 입력 : ");
//        String std4 = sc.next();
//        System.out.println("4번 학생명 : " + std4);
//
//        System.out.print("5번 학생 입력 : ");
//        String std5 = sc.next();
//        System.out.println("5번 학생명 : " + std5);



    }

    /**
     * 1 ~ 10 까지 합 구하기
     */
    public void test4() {
        //누적 합을 구할 변수는 0으로 초기화한다
        //누적 곱을 구할 변수는 1로 초기화한다
        int sum = 0;


        for (int i = 1; i <= 10; i ++) {
            sum += i;
        }
        System.out.println(sum);

        //실수 포인트 : sum변수를 for문 블럭 안에 선언하면 안됨! 외부에서 접근 불가, 매턴마다
    }

    /**
     * 1부터 난수까지의 합 구하기
     * - 난수의 범위 : 6 ~ 10
     */

    public void test5(){
        //난수가 6일 때, 1~6끼지의 합
        //난수가 7일 때, 1 ~ 7까지의 합
        //난수가 8 때 1 ~ 7까지의 합
        //난수가 9일 땨, 1 ~ 7까지의 합
        //난수가 9일 때, 1 ~ 7까지의 합
        //난수가 10일 때, 1 ~ 7까지의 합
        int n = (int) (Math.random() * 5) + 6;
        int sum = 0;
        System.out.println(n);
        if  (n ==6 ) {
            for (int i = 1; i <= 6; i++) {
                sum +=i;
            }
        } else if (n==7) {
            for (int i = 1; i <= 7; i++) {
                sum +=i;
            }
        } else if (n==8) {
            for (int i = 1; i <= 8; i++) {
                sum +=i;
            }
        } else if (n==9) {
            for (int i = 1; i <= 10; i++) {
                sum +=i;
            }
        } else if (n==10) {
            for (int i = 1; i <= 10; i++) {
                sum +=i;
            }
        }


        //반복 횟수, 증감 변수의 범위를 난수에 따라 결정
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    /**
     *  사용자로부터 입력받은 단수(2 ~ 9)의 구구단 출력
     *  - 숫자 입력 : 7
     *  - 7단 출력
     */
    public void test6() {
        Scanner sc = new Scanner(System.in);

        System.out.print("몇 단 구구단 출력할까? : ");
        int n = sc.nextInt();

        for (int i = 1 ; i <= 9; i++) {
            int result = n * i;
            System.out.println(n + " * " + i + " =" + result);
        }
        // %d 정수, %f 실수, %s 문자열
        //printf는 기본적으로 개행을 지원하지 않는다.
    }
}
