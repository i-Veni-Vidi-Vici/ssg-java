package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String str = sc.next(); // 입력받은 문자열
        char arr[] = new char[str.length()];    // 문자 배열
        System.out.print("검색문자 입력 : ");
        char search = sc.next().charAt(0);  // 검색문자
        int cnt = 0;    // 검색 문자 갯수

        for(int i=0; i<str.length(); i++) {
            arr[i] = str.charAt(i);
            if(arr[i] == search)
                cnt++;
        }

        System.out.println("출력 : 입력하신 문자열 " + str + "에서 찾으시는 문자 " + search + "은 " + cnt + "개 입니다");

    }
}
