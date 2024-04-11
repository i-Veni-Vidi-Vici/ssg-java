package com.ssg.exception.charcheck;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String beforeCheck = sc.nextLine();
        CharacterProcess characterProcess = new CharacterProcess();
        try {
            System.out.println(characterProcess.countAlpha(beforeCheck));
        } catch (CharCheckException e) {
            e.printStackTrace();
        }
    }
}
