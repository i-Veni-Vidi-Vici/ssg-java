package com.ssg.test;

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

        System.out.print("문자열 입력 : ");
        String string = sc.nextLine(); // 문자열
        System.out.print("검색문자 입력 : ");
        char ch = sc.next().charAt(0); // 문자
        char[] alphabets = new char[10]; // 배열변수 선언과 동시에 배열객체 할당을 할 수 있다.
        int count = 0;

        for(int i = 0; i < alphabets.length; i++) {
            alphabets[i] = string.charAt(i);
            if(alphabets[i] == ch) {
                count++;
            }

        }
        System.out.println("입력하신 문자열 " + string + "에서 찾으시는 문자" + ch +"개는 " + count + "개 입니다.");


    }
}
