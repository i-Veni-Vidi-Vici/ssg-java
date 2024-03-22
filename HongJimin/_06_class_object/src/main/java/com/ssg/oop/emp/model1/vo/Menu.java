package com.ssg.oop.emp.model1.vo;


import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        String menu = "******* 사원 정보 관리 프로그램 **********\n"
                + "1. 새 사원 정보 입력\n"
                + "2. 사원 정보 삭제\n"
                + "3. 사원정보 출력\n"
                + "0. 끝내기\n"
                + "*************************************\n"
                + "입력 : ";

        Employee employee = null; // Employee객체를 대입할 변수
        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1":
                    employee = new Employee();
                    employee.empInput();
                    break;
                case "2":
                    if (employee == null) {
                        System.out.println("사원을 먼저 입력해주세요!");
                        break;
                    } else {
                        employee = null;
                    }
                    break;
                case "3":
                    if (employee == null) {
                        System.out.println("사원을 먼저 입력해주세요!");
                        break;
                    }
                    employee.empOutput();
                    break;
                case "0":
                    System.out.println("끝");
                    return;
                default:
                    System.out.println("다시 입력해~~~~~~~~~");

            }
        }

    }
}
