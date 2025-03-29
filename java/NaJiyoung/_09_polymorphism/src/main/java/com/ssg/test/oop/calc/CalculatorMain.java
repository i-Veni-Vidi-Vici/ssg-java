package com.ssg.test.oop.calc;

import java.util.Scanner;

public class CalculatorMain {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CalculatorMain main = new CalculatorMain();
        main.menu();
    }

    private void menu() {
        String menu = "계산기\n"
                + "================\n"
                + "1. 합\n"
                + "2. 차\n"
                + "3. 곱\n"
                + "4. 나누기\n"
                + "5. 나머지\n"
                + "0. 종료\n"
                + "---------------------\n"
                + "입력 : ";

        Calculator calculator = null;
        String choice = "";
        int num1 = 0;
        int num2 = 0;

        while(true) {
            System.out.print(menu);
            choice = sc.next();

            switch (choice) {
                case "1":
                    System.out.print("> 정수를 입력하세요. : ");
                    num1 = sc.nextInt();
                    System.out.print("> 정수를 입력하세요. : ");
                    num2 = sc.nextInt();
                    Adder adder = new Adder(num1, num2);
                    adder.calc();
                    break;
                case "2":
                    System.out.print("> 정수를 입력하세요. : ");
                    num1 = sc.nextInt();
                    System.out.print("> 정수를 입력하세요. : ");
                    num2 = sc.nextInt();
                    Subtractor subtractor = new Subtractor(num1, num2);
                    subtractor.calc();
                    break;
                case "3":
                    System.out.print("> 정수를 입력하세요. : ");
                    num1 = sc.nextInt();
                    System.out.print("> 정수를 입력하세요. : ");
                    num2 = sc.nextInt();
                    Multiplyer multiplyer = new Multiplyer(num1, num2);
                    multiplyer.calc();
                    break;
                case "4":
                    System.out.print("> 정수를 입력하세요. : ");
                    num1 = sc.nextInt();
                    System.out.print("> 정수를 입력하세요. : ");
                    num2 = sc.nextInt();
                    Divider divider = new Divider(num1, num2);
                    divider.calc();
                    break;
                case "5":
                    System.out.print("> 정수를 입력하세요. : ");
                    num1 = sc.nextInt();
                    System.out.print("> 정수를 입력하세요. : ");
                    num2 = sc.nextInt();
                    Remainder remainder = new Remainder(num1, num2);
                    remainder.calc();
                    break;
                case "0":
                    System.out.println("프로그램이 종료됩니다...");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
                    continue;
            }
        }
    }
}