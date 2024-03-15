package com.sgg.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {

        // 정수를 입력 받아 입력된 값의 구구단 프로그램을 만들어보세요.
        // 1~9까지만 가능하고 이외에 값을 넣으면 “잘못입력하셨습니다. 프로그램종료합니다” 출력

        // 먼저, 구구단 프로그램부터 만들어보기
        // 그 후, if문을 사용하기 - 잘못입력했다는 것을 말하기 위해서는 사용해야 한다.
        Scanner sc = new Scanner(System.in);
        System.out.print("단수 입력(2 ~ 9) : ");
        int dan = sc.nextInt(); // 사용자가 입력할 단수 선언

        if(dan >= 1 && dan <=9 ) {
            for (int i = 1; i < 10; i++) {
                System.out.printf("%d * %d = %d\n", dan, i, dan * i);
            }
        } else {
            System.out.println("잘못입력하셨습니다. 프로그램종료합니다.");
        }
    }
}
