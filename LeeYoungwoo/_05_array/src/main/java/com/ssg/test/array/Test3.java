package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 문자열 입력받아 문자 배열에 넣기
        System.out.print("문자열 검색 : ");
        String str = sc.nextLine();
        char[] arr = new char[str.length()];

//        arr[0] = 'a';
//        arr[1] = 'b';
//        arr[2] = 'c';
//        arr[str.length() - 1] = str.charAt(i);

        // 검색할 문자 입력받기
        System.out.print("검색문자 입력 : ");
        char ch = sc.next().charAt(0);

        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            arr[str.length() - 1] = str.charAt(i);
            if(str.charAt(i) == ch) {
                sum++;
            }
        }
        System.out.printf("출력 : 입력하신 문자열 %s에서 찾으시는 문자 %s는 %d개 입니다.", str, ch, sum);
    }
}
