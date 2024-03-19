package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        test4.test();
    }

    private void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("전화번호 입력 : ");
        String phoneNum = sc.next();
        char[] num = new char[11];
        for (int i = 0; i < num.length; i++) {
            num[i] = phoneNum.charAt(i);
        }
        for (int j = 3; j < 7; j++) {
            num[j] = '*';
        }
        System.out.print("출력 : ");
        for (int k = 0; k < num.length; k++) {
            System.out.print(num[k]);
        }
    }

}