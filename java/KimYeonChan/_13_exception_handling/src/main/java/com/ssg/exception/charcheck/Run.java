package com.ssg.exception.charcheck;

import java.util.Scanner;

public class Run {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Run run = new Run();
        run.test1();
    }

    public void test1() {
        System.out.print("문자열 입력: ");
        String str = sc.nextLine();

        CharacterProcess cp = new CharacterProcess();
        try {
            System.out.println(cp.countAlpha(str));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
