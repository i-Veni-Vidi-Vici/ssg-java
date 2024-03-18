package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        test4.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("전화번호 입력 : ");
        String phone = sc.next();   // 입력받은 전화번호 문자열
        char[] arr = new char[phone.length()];  // 문자 배열
        System.out.print("출력 : ");

        for(int i=0; i<phone.length(); i++) {
            if(i>=3 && i<7) {
                arr[i] = '*';
            } else
                arr[i] = phone.charAt(i);

            System.out.print(arr[i]);
        }
    }
}
