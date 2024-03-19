package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.test();
    }
    private void test() {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열 입력 : ");
        String words = sc.nextLine();
        System.out.println("검색문자 입력 : ");
        char search = sc.next().charAt(0);
//        char[] alphabets = words.toCharArray();
        char[] alphabets = new char[words.length()];
        for (int i = 0; i < words.length(); i++) {
            alphabets[i] = words.charAt(i);
        }

        int sum = 0;
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] == search) {
                sum += 1;
            }
        }
        System.out.printf("출력 : 입력하신 문자열 %s에서 찾으시는 문자 %c은 %d개 입니다", words, search, sum);
    }
}
