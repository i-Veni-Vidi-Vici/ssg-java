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
        while(true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.print("숫자1 : ");
                    int num1 = sc.nextInt();
                    System.out.print("숫자2 : ");
                    int num2 = sc.nextInt();
                    calculator = new Adder(num1, num2);
                    calculator.calc();
                    break;
                case "2":
                    System.out.print("숫자1 : ");
                    num1 = sc.nextInt();
                    System.out.print("숫자2 : ");
                    num2 = sc.nextInt();
                    calculator = new Subtractor(num1, num2);
                    calculator.calc();
                    break;
                case "3":
                    System.out.print("숫자1 : ");
                    num1 = sc.nextInt();
                    System.out.print("숫자2 : ");
                    num2 = sc.nextInt();
                    calculator = new Multiplyer(num1, num2);
                    calculator.calc();
                    break;
                case "4":
                    System.out.print("숫자1 : ");
                    num1 = sc.nextInt();
                    System.out.print("숫자2 : ");
                    num2 = sc.nextInt();
                    calculator = new Divider(num1, num2);
                    calculator.calc();
                    break;
                case "5":
                    System.out.print("숫자1 : ");
                    num1 = sc.nextInt();
                    System.out.print("숫자2 : ");
                    num2 = sc.nextInt();
                    calculator = new Remainder(num1, num2);
                    calculator.calc();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못입력하셨습니다.");
                    continue;
            }

        }

    }

}
