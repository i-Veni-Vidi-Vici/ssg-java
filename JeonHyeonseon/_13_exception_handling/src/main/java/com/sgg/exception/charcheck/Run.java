package com.sgg.exception.charcheck;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        CharacterProcess characterProcess = new CharacterProcess();

        try{
          CharacterProcess.countAlpha();
        } catch (CharCheckException e) {
            System.out.println("체크할 문자열 안에 공백 포함할 수 없습니다. : " + e.getMessage());
        }
    }
}
