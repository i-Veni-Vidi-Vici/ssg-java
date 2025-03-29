package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열 입력 : ");
        String str = sc.nextLine();

        char[] arr = new char[str.length()];

        int i;
        for (i = 0; i < str.length(); i++) {
            arr[i]=str.charAt(i);
        }

        System.out.print("검색문자 입력 : ");
        char ch = sc.next().charAt(0);

        int count = 0;
        for (i = 0; i < str.length(); i++) {
            if(ch==arr[i])
                count++;
        }

        System.out.printf("입력하신 문자열 %s에서 찾으시는 문자 %c는 %d개 입니다.", str, ch, count);
    }
}
