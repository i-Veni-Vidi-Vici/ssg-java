package com.ssg.test.loop;

import java.util.Scanner;

public class Test3 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.println("단수를 입력하시오. : ");
        int num = sc.nextInt();
        if(num<=9&&num>=1){
            for(int i = 1;i <= 9;i++){
                System.out.printf("%d * %d = %d\n", num, i, num*i);
            }
        }
        else {
            System.out.println("잘못 입력하셨습니다. 프로그램 종료합니다.");
        }

    }
}
