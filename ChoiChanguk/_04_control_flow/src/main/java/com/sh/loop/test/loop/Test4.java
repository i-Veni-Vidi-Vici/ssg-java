package com.sh.loop.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.printf("문자열 입력 : ");
        String str=sc.next();
        sc.nextLine();

        System.out.printf("검색할 문자 입력: ");
        char  ch=sc.next().charAt(0);
        System.out.printf("입력된 문자값은 =  %c\n",ch);

        int len=str.length();
        int cnt=0;
        int i;

        if((ch<='a' || ch>='z') && (ch<='A' ||ch>='Z'))
        {
            System.out.printf("영문자가 아닙니다");
        }
        else {
            for (i = 0; i < len; i++) {
                if (str.charAt(i) == ch) {
                    cnt++;
                }
            }
            System.out.printf("%c가 포함된 갯수 : %d",ch,cnt);
        }


    }

}
