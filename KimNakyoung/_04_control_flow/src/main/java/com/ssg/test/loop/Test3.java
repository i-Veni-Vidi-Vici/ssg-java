package com.ssg.test.loop;

import java.util.Scanner;

/**
 * - 정수를 입력 받아 입력된 값의 구구단 프로그램을 만들어보세요.
 * - 1~9까지만 가능하고 이외에 값을 넣으면 “잘못입력하셨습니다. 프로그램종료합니다” 출력
 *
 */

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print(">정수입력 : ");
        int dan = sc.nextInt();

        if (dan >= 1 && dan <= 9) {
            for (int n = 1; n <= 9; n++) {

                    System.out.println(dan + "*" + n + "=" + dan * n);

            }
        }else {

            System.out.println("잘못입력하셨습니다. 프로그램종료합니다.");

        }
    }
}
