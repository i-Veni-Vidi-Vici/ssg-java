package com.ssg.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("단수 입력 : ");
        int num = sc.nextInt(); // 입력받은 정수

        if(num>=1 && num <10) { // 1 ~ 9까지 가능
            for(int i=0; i<9; i++) {
                
            }
        }
    }
}
