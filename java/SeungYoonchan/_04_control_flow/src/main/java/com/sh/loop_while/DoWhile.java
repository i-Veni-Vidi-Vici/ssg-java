package com.sh.loop_while;

import java.util.Scanner;

public class DoWhile {
    public void test1() {
        Scanner sc = new Scanner(System.in);
        char yn;

        do {
            System.out.println("게임 실행");
            System.out.println("한판 더 하시겠습니다 y/n : ");
            yn = sc.next().charAt(0);
        } while (yn == 'y');
    }

    public void test2() {
        Scanner sc = new Scanner(System.in);
        String str;

        do{
            System.out.println("문자열을 입력하세요. (중지하려면 exit) : ");
            str = sc.nextLine();
            System.out.println("> " + str);
        }while(!str.equals("exit"));
    }
}
