package com.ssg.exception.charcheck;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        run.test1();
    }

    private void test1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 문자열 입력 : ");
        String str = sc.nextLine();
        try{
            CharacterProcess cp = new CharacterProcess();
            System.out.println(cp.countAlpha(str));
        }catch (CharCheckException e) {
            System.out.println(e.getMessage());
        }
    }
}
