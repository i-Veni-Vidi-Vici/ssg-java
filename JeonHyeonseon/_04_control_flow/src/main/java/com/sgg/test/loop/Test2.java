package com.sgg.test.loop;

import java.util.Scanner;

public class Test2 {

    public static void main(String[] arg) {

        /**
         * - 정수를 입력 받아 1부터 입력 받은 정수까지 수를
         * - 홀수와 짝수를 나눠서 홀수면 “수”, 짝수면 “박”을 출력 하세요.
         */

        // for문을 사용하고 if문도 사용해야 한다. 왜?
        // if문을 통해 홀수이면 "수", 홀수가 아니라 짝수이면 "박"을 만든다.

        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력(1부터 가능) : ");
        int num = sc.nextInt(); // 사용자가 입력할 정수를 선언

        for(int i = 1; i <= num; i++) { // i는 변하는 값
            if (i % 2 != 0) {
                System.out.print("수");
            } else {
                System.out.print("박");
            }
        }
        System.out.println();
    }
}
