package com.ssg.test.loop;

import java.util.Scanner;

public class Test1 {

    public void test1()

    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("누적 합산을 할 정수 하나를 입력해주세요 : ");
        int userNum = scanner.nextInt();
        System.out.println("입력하신 값은?" + userNum + "입니다 ");
        int sum = 0;
        for (int i = 2; i <=userNum; i += 2){
            sum += i;
    }
        System.out.println("=====================");
        System.out.println(" 총합 값은 ? " + sum + "입니다." );
 }
}
