package com.sgg.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {

        // 정수를 입력 받아 입력된 값의 구구단 프로그램을 만들어보세요.
        // 1~9까지만 가능하고 이외에 값을 넣으면 “잘못입력하셨습니다. 프로그램종료합니다” 출력

        // if문을 사용해야 할까.
        // 잘못입력했다는 것을 말하기 위해서는 사용하는 것이 맞는 것 같다.
        Scanner sc = new Scanner(System.in);
        System.out.print("단수 입력 : ");
        int dan = sc.nextInt(); // 사용자가 입력할 단수 선언

        for(int i = 1; i < 10; i++){

            if(dan < 10 && i < 10 ) {
                for (int n =1; n < 10; n++) {  // * n을 의미하는 거
                    System.out.printf("%d * %d = %d\n", dan, n, dan * n);
                }
            } else {
                System.out.println("잘못입력하셨습니다. 프로그램을 종료합니다.");
            }
        }
        System.out.println();
    }
}
