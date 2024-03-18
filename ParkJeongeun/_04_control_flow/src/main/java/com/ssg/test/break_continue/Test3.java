package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; ; i++) {
            System.out.print("> 정수 하나를 입력하세요. (1 ~ 100) : ");
            int num = sc.nextInt();
            int rnd = (int) (Math.random() * 100) + 1; // for문 안에 작성해야 난수도 숫자 계속 바뀜
            System.out.println("> 난수 생성 : " + rnd);
            if (rnd > num) {
                System.out.println("입력하신 정수보다 큽니다.");
            } else if (rnd < num) {
                System.out.println("입력하신 정수보다 작습니다.");
            } else {
                System.out.println("정답입니다. " + i + "회 만에 정답을 맞추셨습니다.");
                break; //if만 있으면 쓸 수 없고 반복문이 있어야 함
            }
        }
    }
}
