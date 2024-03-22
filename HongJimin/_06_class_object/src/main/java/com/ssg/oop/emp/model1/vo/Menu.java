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

        Employee employee = new Employee(); // Employee객체를 대입할 변수
        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1":
                    employee.empInput();
                    break;
                case "2":
                    employee.deleteEmp();
                    break;
                case "3":
                    employee.empOutput();
                    break;
                case "0":
                    break;

            }
        }

    }
}
