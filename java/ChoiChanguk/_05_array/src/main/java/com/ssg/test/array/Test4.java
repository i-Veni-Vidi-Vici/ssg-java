package com.ssg.test.array;

import java.util.Scanner;
import java.util.Stack;

public class Test4 {
    public static void main(String[] args) {
        //깊은 복사, 가운데 4자리 *로 표시
        System.out.printf("전화번호 입력 : ");
        Scanner sc = new Scanner(System.in);
        String userNum=sc.next();//사용자 번호 받고

        int len;

        char[] inNumber=new char[userNum.length()];//정석 숫자 입력 객체
        char[] starNumber=new char[userNum.length()];// *로 바꿀 객체


        for(int i=0;i<userNum.length();i++)
        {
            inNumber[i]=userNum.charAt(i);// 문자열을 하나씩 하나씩 정석숫자 객체에 입력
            starNumber[i]=inNumber[i];//깊은 복사
        }
        for(int i=3;i<7;i++)
        {
            starNumber[i]='*';
        }

        System.out.printf("출력 : ");
        for(int i=0;i<userNum.length();i++)
        {
            System.out.printf("%c",starNumber[i]);
       }

    }
}
