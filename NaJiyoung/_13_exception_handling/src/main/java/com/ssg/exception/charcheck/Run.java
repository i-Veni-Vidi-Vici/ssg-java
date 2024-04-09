package com.ssg.exception.charcheck;

import java.util.Scanner;

public class Run {
    private CharacterProcess process = new CharacterProcess();

    public static void main(String[] args) {
        Run run = new Run();
        run.test1();
    }

    public void test1() {
        Scanner sc = new Scanner(System.in);
        String s = "";
        boolean isPass = false;
        do {
            try {
                System.out.print("문자열 입력 : ");
                s = sc.nextLine();
                System.out.println("영문자 개수: " + process.countAlpha(s));
                isPass = true;
            } catch (CharCheckException e) {
                System.out.println(e.getMessage());
            }
        } while (!isPass);
    }
}
