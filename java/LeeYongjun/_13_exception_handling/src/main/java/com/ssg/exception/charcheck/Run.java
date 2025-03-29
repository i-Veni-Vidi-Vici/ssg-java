package com.ssg.exception.charcheck;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CharacterProcess characterProcess = new CharacterProcess();
        try {
            System.out.println("문자열을 입력 : ");
            String s = sc.nextLine();
            characterProcess.countAlpha(s);
        }
        catch (CharCheckException e){
            System.out.println(e.getMessage());
        }
    }
}
