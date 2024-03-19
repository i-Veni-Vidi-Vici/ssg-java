package com.sh.loop._for;

import java.util.Scanner;

/**
 * 중첩반복문
 */
public class For2 {
    public void test1() {
        for(int i = 0; i < 3; i++){
            System.out.println(i);

            for(int j = 1; j <= 5; j++){
                System.out.println("\t" + j);
            }
        }

    }

    /**
     * 전체 구구단 출력
     *
     * 2 * 1 = 2
     * 2 * 2 = 4
     * 2 * 3 = 6
     * ....
     *
     * 3 * 1 = 3
     * 3 * 2 = 6
     * 3 * 3 = 9
     * ....
     *
     * 9 * 1 = 9
     * 9 * 2 = 18
     * 9 * 3 = 27
     * ...
     * 9 * 9 = 81
     */
    public void test2() {
        // outer loop(바깥 부분) 2단 ~ 9단 (8번)
        for(int dan = 2; dan <= 9; dan++){ // 단을 해결하는 식
//            System.out.println(dan);
            System.out.println("\t" + dan + "단");
            // inner loop 1 ~ 9 (9번)
            for(int n = 1; n <= 9; n++){ // 단 안에 있는 각각의 식을 해결하는 식
//                System.out.println("\t" + n);
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
            }
            System.out.println(); // 각 단에 띄어쓰기할 수 있도록 해줌
        }
    }

    /**
     * 중첩반복문 - 메소드
     */
    public void test3(){
        for(int dan = 2; dan <= 9; dan++) {
            printEachDan(dan); // 메소드 호출
        }
    }

    public void printEachDan(int dan) {
        System.out.println("---" + dan + "단---");
        for(int n = 1; n <= 9; n++) {
            System.out.printf("%d + %d = %d\n", dan, n, dan * n);
        }
        System.out.println();
    }

    /**
     * 중첩반복문 - 행/열 표현하기
     * - outer loop -> 행(가로)
     * - inner loop -> 열(세로)
     */
    public void test4() {
        // 2행 3열
        // 행
        for(int row = 0; row < 2; row++){ // 행을 표현
            // 열
            for(int col = 0; col < 3; col++) {  // 열 표현
//                System.out.print("★ ");
                System.out.printf("(%d, %d)", row, col); // 좌표 표현
            }
            System.out.println(); // 개행처리
        }
    }

    /**
     * 사용자로부터 행/열 값을 입력 받아 별찍기하세요
     * >> 행 : 5
     * >> 열 : 3
     * ★★★
     * ★★★
     * ★★★
     * ★★★
     * ★★★
     *
     */
    public void test5() {
        Scanner sc = new Scanner(System.in);
        // 행
        System.out.println("행 : ");
        int row = sc.nextInt();
        System.out.println("열 : ");
        int col = sc.nextInt();

        //row번 반복
        for(int i = 0; i < row; i++) {
            // col번 반복
            for(int j = 0; j < col; j++) {
                System.out.print("★");
            }
            System.out.println();
        }
    }

    /**
     * 행수를 입력받아서 다음과 같이 출력
     * > 행수 : 5
     * ★
     * ★★
     * ★★★
     * ★★★★
     * ★★★★★
     *
     */
    public void test6() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> 행수 : ");
        int row = sc.nextInt();

        // 행(가로)
        for(int i =0; i < row; i++) {
            // 열(세로)
                for (int j = 0; j < i + 1; j++) {
                    System.out.println("★");
                }
            }
            System.out.println(); // 가로를 바꾸는 것
        }


    /**
     * 알파벳 대문자 E처럼 출력하기
     * □□□
     * □
     * □□□
     * □
     * □□□
     *
     */
    public void test7() {
        // 행(가로)
        for(int i = 1; i < 5; i++) {
//            if(i % 2 != 0) { //i(행 row)가 홀수일때
//                System.out.println("ㅁㅁㅁ");
//            } else { // i(행 row)가 짝수일때
//                System.out.println("ㅁ");
//            }
            int limit = (i % 2 == 0) ? 3 : 1;
            for(int j = 0; j < limit; j++) {
                System.out.println("ㅁ");
            }
            System.out.println();
        }
    }
}
