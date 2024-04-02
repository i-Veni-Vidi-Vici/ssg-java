package com.ssg.exception.charcheck;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        test();
    }
    public static void test()
    {
        CharacterProcess characterProcess = new CharacterProcess();
        String str;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.print("문자열 : ");
                str = scanner.nextLine();
                int cnt = characterProcess.countAlpha(str);
                System.out.println(cnt);
                break;

            } catch (CharCheckException e) {
                System.out.println("다시 입력하세요.");
                scanner.nextLine();
            }
        }


    }
}


