package com.sh.condition.loop._for;

import java.util.Random;
import java.util.Scanner;

/**
 * <pre>
 * for문 표현식
 *
 * for(초기식; 조건식; 증감식) {
 *     //반복실행구문
 * }
 *
 * - 초기식 : 증감변수 선언
 * - 조건식 : 반복문 실행여부
 * - 증감식 : 증감변수 증가/감소처리
 * - 증감변수 : 반복횟수, 반복시 변하는 값 등을 위해 선언한 변수
 *
 * 실행순서
 * 1. 초기식
 * 2. 조건식 : true 인 경우 | false인 경우 반복문 탈출
 * 3. 블럭진입 - 반복실행구문
 * 4. 증감식 -> 2번 조건식 이동
 *
 * </pre>
 */

public class For {
    public void test1() {
//        // 1 ~ 10까지 출력
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(i);
//        }
        // 증감식이 없다면 (오류는 안남) i = 1인채로 무한반복 왜냐면 증감은 안하는데 조건식은 계속 만족해서
//        for (int i = 1; i <= 10; ) {
//            System.out.println(i);
//        }
//
//        // 조건식이 없다면, 조건이 없어서 무조건 true, 그래서 무한 증감
//        for (int i = 1; ; i++ ) {
//            System.out.println(i);
//        }

        // 초기식, 조건식, 증감식 모두 없는 경우
        // 무한반복 == while이랑 똑같음
        for (; ; ) {
            System.out.println("hi");
        }
    }

    public void test2() {
        // 0 ~ 9까지 출력
//        for(int i = 0; i <= 9 ; i++){
//            System.out.println(i);
//        }

        // 11~20 까지 출력 (10번반복, 11 ~ 20)

//        for (int i = 11 ; i <= 20 ; i++){
//            System.out.println(i);
//        }
        // 1 3 5 7 9 11 13 15 17 19 1~20까지의 홀수만 출력

//        for (int i = 1; i <= 20; i+= 2){
//            System.out.println(i);
//        }
        // 10~1 까지 출력 (10번, 10~1)
//        for (int i = 10; i >= 1; i-- ){
//            System.out.println(i);
//        }
        // 20 18 16 14 12 10 8 6 4 2

//        for(int i = 20; i > 0; i -= 2){
//            System.out.println(i);
//        }

        for (int i = 20; i > 0; i--) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    /**
     * - 언제 반복문을 적용해야 하는가 ( swith for while 뭘 써야하나?)
     * - 몇번 반복해야 하는가
     * - 매턴마다 달라지는 부분은 어떻게 처리할 것인가
     * (이걸 모르겠다면? 일단 몇번 반복해야되는지 하드코딩해보자 그럼 눈에 보임)
     */

    public void test3() {
        // 5명의 학생이름 입력받아 출력

        for (int i = 1; i <= 5; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.print(i + "번" + "학생 입력 : ");
            String stdt1 = sc.next();
            System.out.println(i + "번" + "학생명 : " + stdt1);
        }
    }

    /**
     * 1~ 10까지 합 구하기
     */

    public void test4() {
        // 누적합을 구할 변수는 0으로 초기화
        // 누적곱을 구할 변수는 1로 초기화

        // sum += 1;
        // sum += 2;
        // sum += 3;
        // sum += 4;
        // sum += 5;
        // sum += 6;
        // sum += 7;
        // sum += 8;
        // sum += 9;
        // sum += 10;

//        int sum = 0;
//        for (int i = 1; i <=10; i++){
//            sum += i;
//            // int sum += i; //int sum = sum + i라서 이건 말이 안됨 sum 초기화 안해줘서 안됨
//        }
//        System.out.println(sum);

        // 실수 포인트 : sum변수를 for문 블럭 안에 선언. 외부에서 접근불가, 매턴마다 0으로 초기화

    }

    /**
     * 1부터 난수까지의 합 구하기
     * - 난수범위 6 ~ 10
     */

    public void test5() {
        // 난수가 6일때, 1~6까지의 합
        // 난수가 7일때, 1~7까지의 합
        // 난수가 8일때, 1~8까지의 합
        // 난수가 9일때, 1~9까지의 합
        // 난수가 10일때, 1~10까지의 합
        Random rnd = new Random();
//        int n = rnd.nextInt(5)+6; // 6~10

        int n = (int) (Math.random() * 5) + 6; // 6~10

        int sum = 0;

        // 반복횟수,증감변수의 범위를 난수에 따라 결정

        for (int i = 1; i <= n; i++) {

            if (n == 6) {
                sum += i;
            } else if (n == 7) {
                sum += i;
            } else if (n == 8) {
                sum += i;
            } else if (n == 9) {
                sum += i;
            } else if (n == 10) {
                sum += i;
            }
        }
        System.out.println("난수 : " + n + "합 : "+ sum);
    }

    /**
     * 사용자로부터 입력받은 단수(2 ~ 9)의 구구단 출력
     * - 숫자입력 : 7
     * - 7단출력
     *
     *
     *
     */


    public void test6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자입력(2~9): " );
        int n = sc.nextInt();

            for (int i = 2; i <= 9; i++) {
//                System.out.println(n +"*" + i + "=" + userNo*i);
                // 개행 지원x 그래서 안에 \n 넣어줘야함
                // %d 정수, %f 실수, %s 문자열
                System.out.printf("%d * %d = %d\n", n , i, n * i);

            }
    }




}
