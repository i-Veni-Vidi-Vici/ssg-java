package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열 입력 : ");
        String str = sc.nextLine();
        System.out.println("검색할 문자입력 : ");
        char n = sc.next().charAt(0);

        for(int i = 0; i<str.length(); i++){
            if(str.charAt(0) == n){
                n++;
            }
        }
        System.out.println(n + "가 포함된 갯수 : " + str +"개");
    }
}
