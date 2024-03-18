package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //String[] phoneNumber = new String[11];
        System.out.print("전화번호 입력 : ");
        String str = sc.nextLine();
        String[] phoneNumber = str.split("");
        String[] copy = phoneNumber.clone(); //phoneNumber 복사본

        for (int i = 0; i < phoneNumber.length; i++) {
            if (i > 2 && i < 7) {
                copy[i] = "*";
            }
            System.out.print("출력" + copy[i]);
        }


    }
}
