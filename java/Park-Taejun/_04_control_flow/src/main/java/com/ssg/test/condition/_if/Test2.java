package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test2 {
    public void test2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1부터 10사이의 정수를 입력하세요 : " );
        int inum = scanner.nextInt();

        if(inum <1 || inum > 10){
            System.out.println("반드시 1~10사이의 정수를 입력해야 합니다");
        }
        else if(inum % 2 ==0){
            System.out.println("짝수다");
        }else {
            System.out.println("홀수다");
        }
    }
}
