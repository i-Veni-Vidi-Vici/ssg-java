package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("문자열 입력: ");
        String str = scanner.nextLine();
        System.out.printf("검색할 문자 입력: ");
        char target = scanner.next().charAt(0);
        if((target>='A' && target<='Z')||(target>='a'&&target<='z')){
            int count = 0;
            for(int i = 0; i<str.length();i++){
                if(target==str.charAt(i))count++;
            }
            System.out.println("\'"+target+"\'" + "가 포함된 갯수: "+count);
        }
        else{
            System.out.println("영문자가 아닙니다.");
        }
    }
}
