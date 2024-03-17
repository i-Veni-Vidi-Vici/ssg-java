package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = new char[11];
        System.out.print("> 전화번호 입력 : ");
        String m = sc.nextLine();
        for (int i = 0; i < m.length(); i++){
            char ch =  m.charAt(i);
            arr[i] = ch;
        }
        System.out.print("> 출력 : 010****");
        for (int i = 7; i < arr.length; i++){
                System.out.print(arr[i]);
        }
    }
}
