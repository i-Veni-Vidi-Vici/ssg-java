package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        int num=0;
        System.out.println("문자를 입력하시오. : ");
        String str = sc.nextLine();
        System.out.println("검색할 문자 입력 : ");
        char ch = sc.next().charAt(0);
        if((ch<=90&&ch>=90)||(ch<=122&&ch>=122)){
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) == ch){
                    num++;
                }
            }
        }
        else{
            System.out.println("영문자가 아닙니다.");
        }

        System.out.println("'" + ch + "'" + "가 포함된 갯수 : " + num + "개");
    }
}
