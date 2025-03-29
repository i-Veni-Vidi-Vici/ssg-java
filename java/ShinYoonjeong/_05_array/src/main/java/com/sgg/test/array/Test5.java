package com.sgg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Test5 test5 = new Test5();
        test5.test5();
    }
    public void test5()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("홀수인 양의정수를 하나 입력하세요 ==> ");
        int num = sc.nextInt();
        int[] arr = new int[num];
        int count =1;
        if(num%2==1)
        {
            for(int i=0;i<num/2;i++)
            {
                arr[i] = count++;

            }
            arr[num/2] = (num+1)/2;
            for(int i=num/2;i<num;i++)
            {
                arr[i] = count--;
            }
            for(int i=0;i<num;i++)
            {
                System.out.print(arr[i] + " ");
            }

        }
        else
        {
            System.out.println("잘못 입력했습니다. 홀수가 아닙니다.");
        }
    }
}
