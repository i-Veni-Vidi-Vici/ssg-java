package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); //스캐너 호출

        System.out.print("문자열 입력 : ");
        String str = sc.nextLine(); // 사용자로부터 한 줄을 입력받아서 문자열 변수 str에 저장하는 코드

        char[] arr = new char[str.length()]; // 문자열 'str'의 길이와 같은 길이를 가지는 문자 배열 선언.

        int i;
        for (i = 0; i < str.length(); i++) {
            arr[i]=str.charAt(i); //문자열 str의 각문자를 순회하며, 각 문자를 문자 배열 arr에 저장하는 역할
        //String으로 저장된 문자열 중에서 한 글자만 선택하여 char 타입으로 반환
        // 만약 str에 "hello"가 저장되어 있다면, charAt(i)는 "h"에 대한 인덱스를 0으로 시작해서 순서대로 1씩 증가시킴
            // 따라서 charAt(0)은 "h" ~ 를 반환함.
        }

        System.out.print("검색문자 입력 : ");
        char ch = sc.next().charAt(0);

        int count = 0;
        for (i = 0; i < str.length(); i++) {
            if(ch==arr[i])
                count++;
        }

        System.out.printf("입력하신 문자열 %s에서 찾으시는 문자 %c는 %d개 입니다.", str, ch, count);
    }
}
