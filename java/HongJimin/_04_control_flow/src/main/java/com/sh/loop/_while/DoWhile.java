package com.sh.loop._while;

import java.util.Scanner;

public class DoWhile {
    public void test1() {
        Scanner sc = new Scanner(System.in);
        char yn;

        do {
            System.out.println("게임 실행...얇빡쿵...");
            System.out.println("한판 더 하시겠습니까? Y / N");
            yn = sc.next().charAt(0);
        } while (yn == 'y');

        System.out.println("게임 종료...");
    }

    /**
     * exit를 입력하기 전까지 무한 입력 가능 앱
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        String str; //while 조건식에 사용할 변수는 do 블럭 밖에 선언하기!

        do {
            System.out.println("문자열을 입력하세요. (중지하려면 exit) : ");
            str = sc.nextLine();
            System.out.println("> " + str);

            //기본형이 아닌 문자열은 ==가 아닌 equals 메소드를 통해 동등비교 해야한다.
        } while (!str.equals("exit")); // 입력값이 exit 일 때 false인 조건식 작성
        //exit라고 입력했으면 끝내주는겄!
    }
}
