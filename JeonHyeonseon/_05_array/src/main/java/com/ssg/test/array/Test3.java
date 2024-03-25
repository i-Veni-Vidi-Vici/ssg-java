package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Test3 test = new Test3();
        test.test3();
    }

    private void test3() {
        // 문자열을 하나 입력 받아 문자배열에 넣고
        // 검색할 문자는 하나 입력 받아
        // 검색 문자가 문자열에 몇 개 인지 개수를 출력하는 프로그램을 작성하시오.

        // 문자열에서 중복되는 알파벳을 for문을 이용해서 식을 세워야 하는걸까

        Scanner sc = new Scanner(System.in);

        System.out.println("문자열 입력 : ");  // helloworld
        String str = sc.next();
        System.out.println("문자 입력 : ");  // l
        char ch = sc.next().charAt(0);

        char[] alphabet = new char[10];  // 배열 선언
        int count = 0; // 개수 0으로 초기화

        for(int i = 0; i < alphabet.length; i++){  // 문자열 내 반복되는 문자
            alphabet[i] = str.charAt(i);
            if(alphabet[i] == ch){
                count++;
            }
        }
        System.out.println("입력하신 문자열 " + str + "에서 찾으시는 문자 " + ch + "은 " + count + "개 입니다.");
    }
}
