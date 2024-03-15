package com.ssg.test.array;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("전화번호 입력 : ");
        String phoneNumber = scanner.next();

        String[] str = new String[11];
        for(int i =0 ; i< phoneNumber.length();i++){
            str[i] = String.valueOf(phoneNumber.charAt(i));
        }

        for(int i = 0; i< str.length; i++)
        {
            if(i>= 3 && i<=6)
            {
                str[i] = "*";
            }
        }
        System.out.print("출력 : ");
        for(int i = 0; i< str.length; i++)
        {
            System.out.print(str[i]);
        }


//        for(int i = 0; i< phoneNumber.length; i++)
//        {
//            phoneNumber[i] = scanner.next();
//        }
//        for(int i = 0; i< phoneNumber.length; i++)
//        {
//            System.out.print(phoneNumber[i]);
//        }
//

    }
}
