package com.ssg.oop.calc;

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
        finish:
        while(true) {
            System.out.print(menu);
            String choice = sc.next();
            int num1, num2;
            switch (choice) {
                case "1":
                    calculator = new Adder();
                    System.out.print("> 첫번째 수 입력 : ");
                    num1 = sc.nextInt();
                    System.out.print("> 두번째 수 입력 : ");
                    num2 = sc.nextInt();
                    calculator.calc(num1, num2);
                    break;
                case "2":
                    calculator = new Subtractor();
                    System.out.print("> 첫번째 수 입력 : ");
                    num1 = sc.nextInt();
                    System.out.print("> 두번째 수 입력 : ");
                    num2 = sc.nextInt();
                    calculator.calc(num1, num2);
                    break;
                case "3":
                    calculator = new Multiplyer();
                    System.out.print("> 첫번째 수 입력 : ");
                    num1 = sc.nextInt();
                    System.out.print("> 두번째 수 입력 : ");
                    num2 = sc.nextInt();
                    calculator.calc(num1, num2);
                    break;
                case "4":
                    calculator = new Divider();
                    System.out.print("> 첫번째 수 입력 : ");
                    num1 = sc.nextInt();
                    System.out.print("> 두번째 수 입력 : ");
                    num2 = sc.nextInt();
                    calculator.calc(num1, num2);
                    break;
                case "5":
                    calculator = new Remainder();
                    System.out.print("> 첫번째 수 입력 : ");
                    num1 = sc.nextInt();
                    System.out.print("> 두번째 수 입력 : ");
                    num2 = sc.nextInt();
                    calculator.calc(num1, num2);
                    break;
                case "0":
                    System.out.println("종료");
                    break finish;
                default:
                    System.out.println("잘못입력하셨습니다.");
                    continue;
            }

        }

    }
}
