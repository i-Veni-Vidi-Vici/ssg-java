package com.ssg.exception.charcheck;

import java.util.Scanner;

public class Run {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Run run1 = new Run();
        run1.test1();
    }
    public void test1(){
        CharacterProcess characterProcess = new CharacterProcess();
        while(true){
            try {
                System.out.println("검사할 문자열을 입력하세요");
                System.out.println("알파뱃 개수: " + characterProcess.countAlpha(sc.nextLine()));
                break;
            } catch (CharCheckException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
