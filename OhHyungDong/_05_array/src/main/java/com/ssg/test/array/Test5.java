package com.ssg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("홀수인 양의정수를 하나 입력하세요 ==> ");
        int num = scanner.nextInt();
        int[] arr = new int[num];
        int divide = arr.length / 2;

        int value = 0;
        if(num % 2 == 1)
        {
            for(int i = 0; i<num;i++)
            {
                if(i <= divide){
                    value++;
                    arr[i] = value;
                }
                else arr[i] = --value;
            }
            System.out.print("[");
            for(int i =0; i<num; i++)
            {
                if(i == arr.length -1) System.out.print(arr[i] +" ");
                else System.out.print(arr[i] + ", ");
            }
            System.out.println("]");
        }
        else System.out.println("잘못 입력했습니다. 홀수가 아닙니다. ");

    }

    public void Test()
    {

    }
}
