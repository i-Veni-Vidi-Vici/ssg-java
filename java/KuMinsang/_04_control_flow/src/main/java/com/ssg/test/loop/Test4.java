package com.ssg.test.loop;

import java.util.Scanner;

/**
 * - 문자열과 문자열에서 검색될 문자를 입력 받아 문자열에 그 문자가 몇 개이었는지 개수를 확인하는 프로그램을 작성하세요.
 * - 또, 검색할 문자가 영문자가 아니면 "영문자가 아닙니다." 출력후
 * 프로그램을 종료하세요.
 * - 문자열의 길이를 리턴하는 String의 메소드를 api에서 찾아 사용하세요
 */

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        char ch = ' ';
        int cnt = 0;

        System.out.println("문자열 입력 : ");
        str = sc.nextLine();
        System.out.println("검색할 문자 입력 : ");
        ch = sc.nextLine().charAt(0);

        if(('a'<=ch && ch <='z')||('A'<=ch && ch <='Z')){
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i)==ch){
                    cnt++;
                }
            }
            System.out.printf("%c가 포함된 갯수 : %d 개\n", ch, cnt);
        }else{
            System.out.println("영문자가 아닙니다");
        }
    }
}
