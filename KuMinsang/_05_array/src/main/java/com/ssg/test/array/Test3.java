package com.ssg.test.array;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str="";
        char charin=' ';
        int cnt =0;

        System.out.print("문자열 입력 : ");
        str = sc.nextLine();
        System.out.print("검색문자 입력 : ");
        charin = sc.nextLine().charAt(0);

        for(int i =0; i<str.length(); i++){
            if(charin ==str.charAt(i))
                cnt++;
        }
        System.out.println("입력하신 문자열 "+str+"에서 찾으시는 문자 "+charin+"은 "+cnt+"개 입니다.");

    }
}
