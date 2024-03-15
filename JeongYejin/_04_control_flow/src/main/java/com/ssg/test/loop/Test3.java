package com.ssg.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.test();
    }

    private void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("단수 입력 : ");
        int userDan = sc.nextInt();
        for (int i=1; i<=9; i++) {
            if (userDan >= 1 && userDan <= 9) {
                System.out.printf("%d * %d = %d\n", userDan, i, userDan * i);
            } else {
                System.out.println("잘못입력하셨습니다. 프로그램종료합니다.");
                break;
            }
        }
    }
}
