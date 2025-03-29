package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("전화번호 입력 : ");
        String phone = sc.next();

        String[] phoneNum = new String[11];
        for(int i = 0; i < phoneNum.length; i++) {
            phoneNum[i] = String.valueOf(phone.charAt(i));
        }

        String[] priPhone = phoneNum.clone();
        System.out.print("출력 : ");
        for(int i = 0; i < priPhone.length; i++) {
            if(i > 2 && i < 7) {
                priPhone[i] = "*";
            }
        System.out.print(priPhone[i]);
        }
    }
}
