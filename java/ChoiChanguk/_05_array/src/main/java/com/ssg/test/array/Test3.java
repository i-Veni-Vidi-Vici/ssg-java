package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        char[] str;
        Scanner sc = new Scanner(System.in);
        System.out.printf("문자열 입력 : ");

        String inStr=sc.next(); // 배열 객체를 생성하기 위해 길이를 구한다

        System.out.printf("검색문자 입력 : ");
        char search = sc.next().charAt(0);

        int len=inStr.length();
        str=new char[len];
        int i;
        int cnt=0;

        for(i=0;i<len; i++)
        {
            //입력 받은 문자를 문자열 배열에 넣는다
            str[i]=inStr.charAt(i);
        }
        for(i=0;i<len; i++)
        {
            if(str[i]==search)
            {
                cnt++;
            }
        }
        System.out.printf("출력 : %s에서 찾으시는 문자 %c는 %d개입니다 ",inStr,search,cnt);
    }
}
