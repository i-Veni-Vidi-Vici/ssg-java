package com.sgg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        test4.test4();
    }
    public void test4()
    {
        Scanner sc = new Scanner(System.in);
        String[] phone = new String[11];
        System.out.println("번호 입력");
        phone[10]=sc.nextLine();
        char[] phone2 = phone[10].toCharArray();
        for (int i=0;i<3;i++)
        {
            System.out.print(phone2[i]);

        }
        System.out.print("****");
        for(int i=7;i<11;i++)
        {

            System.out.print(phone2[i]);
        }

    }
}
