package com.sh.loop._for;

import java.util.Scanner;

/**
 * <pre>
 *     for문 표현식
 *
 *     for(초기식; 조건식; 증감식){
 *         // 반복 실행 구문
 *     }
 *
 * </pre>
 */
public class For {
    public void test1(){
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }

    public void test2(){
        int i = 0;
        //0~9
//        for (i = 0; i <= 9; i++) {
//            System.out.println(i);
//        }
//
//        for (i = 11; i <= 20; i++) {
//            System.out.println(i);
//        }
//
//        for (i = 1; i < 20; i = i + 2) {
//            System.out.println(i);
//        }

        for (i = 20; i > 1; i = i - 2) {
            System.out.println(i);
        }

    }

    public void test3(){
        Scanner sc = new Scanner(System.in);
        String std;
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + "번 학생 입력 : ");
            std = sc.next();
            System.out.println(i + "번 학생명 : " + std);
            System.out.println();
        }
    }

    /**
     * <pre>
     *     1~10까지 합 구하기
     * </pre>
     */
    public void test4(){
        // 누적합을 구할 변수는 0
        // 누적곱을 구할 변수는 1 로 초기화.

        int sum = 0, i = 0;

        for (i = 1; i <= 10; i++) {
            sum = sum + i;
        }

        System.out.println("합 : " + sum);
    }

    public void test5(){
        int n = (int) (Math.random() * 5) + 6;
        int sum = 0;
        System.out.println("난수 " + n);
        System.out.println();

        for(int i=1;i<=n;i++){
            sum = sum + i;
            System.out.println(i);
        }

        System.out.println();
        System.out.println("합 : " + sum);

    }

    // 사용자로부터 입력받은 단수의 구구단 출력

    public void test6(){
        Scanner sc = new Scanner(System.in);

        System.out.print("원하는 단수(2~9)를 입력하세요 : ");
        int num = sc.nextInt();

        for (int i = 1; i <= 9; i++) {
//            System.out.println(num + " * " + i + " = " + (i*num));

            // %d는 정수 %f는 실수 %s 문자열
            System.out.printf("%d * %d = %d\n", num , i, num * i);
        }
    }
}
