package com.ssg.exception.charcheck;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        run.test1();
    }

    public void test1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력:");
        CharacterProcess cp = new CharacterProcess();
        try {
            System.out.println(cp.countAlpha(sc.nextLine()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
