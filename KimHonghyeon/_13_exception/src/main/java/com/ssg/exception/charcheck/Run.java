package com.ssg.exception.charcheck;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Run run = new Run();
        System.out.print("문자열을 입력해주세요: ");
        run.test1(scanner.nextLine());

    }

    public void test1(String str){
        CharacterProcess charProcess = new CharacterProcess();
        try{
            int count  = charProcess.countAlpha(str);
            System.out.println(count);
        }
        catch(CharCheckException e){
            System.out.println(e.getMessage());
        }
    }
}
