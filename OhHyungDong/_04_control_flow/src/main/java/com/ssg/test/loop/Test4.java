package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String str = scanner.nextLine();
        System.out.print("검색할 문자 입력 : ");
        char search = scanner.next().charAt(0);


        int num = 0; // 같은 숫자

        if((search >= 65 && search <= 90) || (search >= 97 && search <= 122) ) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == search) num++;
            }
            System.out.println("'" + search + "'" + "가 포함된 갯수 : " + num + "개");
        }
        else{
            System.out.println("영문자가 아닙니다. ");
        }
        //영문자가 아닙니다 추가
    }
}
