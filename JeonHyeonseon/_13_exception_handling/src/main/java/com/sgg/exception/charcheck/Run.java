package com.sgg.exception.charcheck;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        run.test1();
    }

    private void test1() {
        Scanner sc = new Scanner(System.in);
        CharacterProcess characterProcess = new CharacterProcess();

        System.out.print("문자열 입력 : ");
        String str = sc.nextLine();

        try {
            CharacterProcess.countAlpha(str);
        } catch (CharCheckException e) {
            System.out.println("체크할 문자열 안에 공백 포함할 수 없습니다. ");
        }
    }
}