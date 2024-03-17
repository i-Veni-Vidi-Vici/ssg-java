package com.ssg.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Test3 t = new Test3();
        t.test();
    }

    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.print("단수 입력 : ");
        int n = sc.nextInt();

        for (int i = 1; i <= 9; i++) {
            if(n>=10){
                System.out.println("잘못입력하셨습니다. 프로그램종료합니다");
                break;
            }
            System.out.printf("%d * %d = %d\n", n, i, n * i);
        }
    }
}

