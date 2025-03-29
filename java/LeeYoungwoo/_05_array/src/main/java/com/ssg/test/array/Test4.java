package com.ssg.test.array;

import java.io.FilterOutputStream;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("전화번호 입력 : ");
        String num = sc.next();
        char[] phNum = new char[num.length()];

        System.out.print("출력 : ");

        for(int i = 0; i < num.length(); i++) {
            // 가운데 4자리만 * 로 바꾸는 if문
            if(i >=3 && i <= 6) {
                phNum[i] = '*';
            }
            else {
                phNum[i] = num.charAt(i);
            }
            System.out.print(phNum[i]);
        }
    }
}
