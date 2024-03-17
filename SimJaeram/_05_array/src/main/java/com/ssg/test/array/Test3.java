package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = new String();
        char search = ' ';
        int count = 0;

        // 문자열 입력
        System.out.print("문자열 입력 : ");
        str = sc.nextLine();

        // 검색할 문자 입력
        System.out.print("검색문자 입력 : ");
        search = sc.nextLine().charAt(0);

        // 검색할 문자 개수 찾기
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == search)
                count++;
        }

        // 출력
        System.out.println("출력 : 입력하신 문자열 " + str + "에서 찾으시는 문자 " + search + "는 " + count + "개입니다.");
    }
}
