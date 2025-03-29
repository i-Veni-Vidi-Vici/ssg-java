package com.sh._04.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {

        MemberAgeChecker checker = new MemberAgeChecker();
        try{
            checker.checkAge();
            System.out.println("게임을 시작합니다. ⚔");
        }catch (AgeException e){
            System.out.println(e.getMessage());
        }
    }
}
