package com.ssg.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("단수입력 : ");
        int num = sc.nextInt();

        if(num >= 1 && num <=9){
            for(int i = 1; i <= 9; i++){
                System.out.printf("%d * %d = %d \n", num, i, num * i);
            }
        }
        else{
            System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다. ");
        }
    }
}
