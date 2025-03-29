package com.ssg.test.loop;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        t.test();
    }

    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int n = sc.nextInt();
        int sum=0;

        for(int i=1;i<=n;i++){
            if(i%2 ==0){
                sum += i;
            }
        }
        System.out.printf("1부터 %d까지 짝수만 더한 합 : %d",n,sum);
    }
}
