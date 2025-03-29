package com.ssg.exception.number;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        run.test();
    }

    private void test() {
        Scanner sc = new Scanner(System.in);
        NumberProcess process = new NumberProcess();
        int a = 0;
        int b = 0;
        boolean isPass = false;

        do {
            try {
                System.out.print("정수1 입력 : ");
                a = sc.nextInt();
                System.out.print("정수2 입력 : ");
                b = sc.nextInt();

                if (process.checkDouble(a, b))
                    System.out.println(a + "는 " + b + "의 배수이다.");
                else
                    System.out.println(a + "는 " + b + "의 배수가 아니다.");
                isPass = true;
            } catch (NumberRangeException e) {
                System.out.println(e.getMessage());
            }
        } while(!isPass);
    }
}
