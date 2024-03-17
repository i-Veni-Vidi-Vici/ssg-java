package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열 입력 : ");
        String str = sc.nextLine();
        System.out.print("검색할 문자 입력 : ");
        char ch = sc.nextLine().charAt(0);

        int count = 0;
        if(ch < 'a' || ch >'z'){
            System.out.println("영어 소문자가 아닙니다.");
        }
        else{
            for (int i = 0; i < str.length(); i++) {
                if(ch == str.charAt(i)){
                    count++;
                }
            }
            System.out.printf("'%c'가 포함된 갯수 : %d개\n", ch, count);
        }

    }
}
