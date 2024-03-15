package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       int count = 0;

        System.out.print("문자열 입력 : ");
        String str = scan.next();

        System.out.println("검색문자 입력 : ");
        char ch = scan.next().charAt(0);

        for(int i = 0; i< str.length(); i++)
        {
            if(ch == str.charAt(i)) count ++;
        }


    }
}
