package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("문자 입력 : ");
        String str = sc.next();// 입력한 문자를 str에 저장

        char [] word = new char[str.length()];// 입력한 문자 개수와 동일한 배열 word 생성

        for (int i = 0; i< str.length(); i++) { //입력 받은 문자를 word 배열 인덱스에 하나씩 저장
            word[i] = str.charAt(i);
        }

        System.out.print("검색 문자 입력 : ");
        String search = sc.next();

        int count = 0;
        for (int j = 0; j < word.length; j++) {
            if(word[j] == search.charAt(0)) {
                count += 1;
            }
        }
        System.out.printf("입력하신 문자열 %s 에서 찾으시는 문자 %s는 %d 개 입니다.", str, search, count );
    }
}
