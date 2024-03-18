package com.sgg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.test3();
    }
    public void test3()
    {
        Scanner sc = new Scanner(System.in);
        String str = new String();
        int num=0;
        System.out.println("문자열 입력.");
        str = sc.nextLine();
        System.out.println("문자 입력.");
        char word = sc.next().charAt(0);
        char[] arr = new char[str.length()];
        for(int i=0;i<str.length();i++)
        {
            arr[i]=str.charAt(i);
        }


        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==word)
            {
                num++;
            }
        }
        System.out.printf("총 %d 개", num);

    }
}
