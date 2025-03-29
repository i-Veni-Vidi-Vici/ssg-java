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
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print(menu);
            String choice = sc.next();
            System.out.println("두 수를 입력하세요.");
            switch (choice) {
                case "1":
                    Adder adder = new Adder(sc.nextInt(), sc.nextInt());
                    adder.calc();
                    break;
                case "2":
                    Subtractor subtractor = new Subtractor(sc.nextInt(), sc.nextInt());
                    subtractor.calc();
                    break;
                case "3":
                    Multiplyer multiplyer = new Multiplyer(sc.nextInt(), sc.nextInt());
                    multiplyer.calc();
                    break;
                case "4":
                    Divider divider = new Divider(sc.nextInt(), sc.nextInt());
                    divider.calc();
                    break;
                case "5":
                    Remainder remainder = new Remainder(sc.nextInt(), sc.nextInt());
                    remainder.calc();
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