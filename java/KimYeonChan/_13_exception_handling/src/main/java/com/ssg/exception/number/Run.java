package com.ssg.exception.number;

import java.util.Scanner;

public class Run {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Run run = new Run();
        run.test();
    }

    public void test() {
        try {
            System.out.print("정수1 입력: ");
            int num1 = sc.nextInt();
            System.out.print("정수2 입력: ");
            int num2 = sc.nextInt();

            NumberProcess numberProcess = new NumberProcess();
            if (numberProcess.checkDouble(num1, num2)) {
                System.out.println(num1 + "은 " + num2 + "의 배수입니다.");
            }
            else {
                System.out.println(num1 + "은 " + num2 + "의 배수가 아닙니다.");
            }
        } catch (NumberRangeException e){
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("정수를 입력해주세요.");
        }
    }
}
