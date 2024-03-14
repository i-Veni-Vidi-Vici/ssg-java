package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args){
        Test2 t2 = new Test2();
        t2.test();
    }

    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.print("1~10 사이의 정수 한개를 입력 : ");
        int num = sc.nextInt();

        if(num%2==0 && (num>0 && num<=10)){
            System.out.println("짝수");
        }else if(num%2==1 && (num>0 && num<=10)) {
            System.out.println("홀수");
        }else{
            System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");

        }
    }
}
