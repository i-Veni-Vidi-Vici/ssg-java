package com.ssg.test.break_continue;

import java.util.Random;
import java.util.Scanner;
//
//- 1~100 사이의 임의의 난수를 발생시키고, 정수 한 개를 입력 받습니다.
//        - 난수가 입력 받은 정수보다 작으면 “입력하신 정수보다 작습니다.” 출력,
//        - 난수가 입력 받은 정수보다 크면 “입력하신 정수보다 큽니다.” 출력하세요.
//- 단, 정답을 맞출 때까지 정수를 계속 입력 받아 프로그램이 반복되도록 하고,
//- 정답인 경우 **“정답입니다. 5회 만에 정답을 맞추셨습니다.”**와 같이
//몇 회 만에 정답을 맞추었는지 출력하도록 작성하세요.
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        int random = rnd.nextInt(100) + 1;
        System.out.println(random);
        System.out.println("정수하나를 입력하세요 : ");
        int number = scanner.nextInt();

        xyz:
        for(int i = 1; ; i++)
        {
            if(random == number){
                System.out.println("정답입니다! " + i +"번 만에 정답을 맞추셨습니다.");
                break;
            }
            else if(random > number){
                System.out.println("난수가 입력하신 정수보다 큽니다.");
                System.out.println("정수를 다시 입력하세요 : ");
                number = scanner.nextInt();
                continue xyz;
            }
            else {
                System.out.println("난수가 입력하신 정수보다 작습니다.");
                System.out.println("정수를 다시 입력하세요 : ");
                number = scanner.nextInt();
                continue xyz;
            }
        }
    }
}
