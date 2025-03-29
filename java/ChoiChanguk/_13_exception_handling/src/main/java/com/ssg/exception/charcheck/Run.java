package com.ssg.exception.charcheck;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Run run=new Run();
        run.test1();
    }

    private void test1() {
        CharacterProcess characterProcess=new CharacterProcess();
        Scanner sc = new Scanner(System.in);

        String str=sc.nextLine();

        int cnt= characterProcess.countAlpha(str);

        System.out.println("문자 개수 : "+cnt+"개");

    }
}
