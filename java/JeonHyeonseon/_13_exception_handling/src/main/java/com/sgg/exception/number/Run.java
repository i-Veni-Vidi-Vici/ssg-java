package com.sgg.exception.number;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        run.test();
    }

    private void test() {
        NumberProcess numberProcess = new NumberProcess();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("정수1 입력 : ");
            int num1 = sc.nextInt();
            System.out.print("정수2 입력 : ");
            int num2 = sc.nextInt();

            if(numberProcess.checkDouble(num1, num2)) {
                System.out.println(num1 + "은 " + num2 + "의 배수입니다.");
            } else {
                System.out.println(num1 + "은 " + num2 + "의 배수가 아닙니다.");
            }
        } catch (NumberRangeException e){
            System.out.println(e.getMessage());
        }
    }
}
