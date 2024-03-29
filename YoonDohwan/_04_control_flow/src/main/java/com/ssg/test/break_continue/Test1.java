package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        System.out.print("정수를 입력하시오. => ");
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        int total=1;
        for(int i=0;i<=num;i++){
            if(i%2==1){
                total*=i;
            }

        }

        System.out.printf("1부터%d까지 홀수의 곱은 : %d 입니다.",num,total);


    }
}
