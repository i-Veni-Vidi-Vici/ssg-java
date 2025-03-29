package com.sh.oop.calc;

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
        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.printf("더하기 작업\n숫자 두 개를 입력하세요 : ");
                    calculator = new Adder(sc.nextInt(), sc.nextInt());
                    calculator.calc();
                    break;
                case "2":
                    System.out.printf("빼기 작업\n숫자 두 개를 입력하세요 : ");
                    calculator = new Subtractor(sc.nextInt(), sc.nextInt());
                    calculator.calc();
                    break;
                case "3":
                    System.out.printf("곱하기 작업\n숫자 두 개를 입력하세요 : ");
                    calculator = new Multiplayer(sc.nextInt(), sc.nextInt());
                    calculator.calc();
                    break;
                case "4":
                    System.out.printf("나누기 작업\n숫자 두 개를 입력하세요 : ");
                    calculator = new Divider(sc.nextInt(), sc.nextInt());
                    calculator.calc();
                    break;
                case "5":
                    System.out.printf("나머지 작업\n숫자 두 개를 입력하세요 : ");
                    calculator = new Remainder(sc.nextInt(), sc.nextInt());
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
