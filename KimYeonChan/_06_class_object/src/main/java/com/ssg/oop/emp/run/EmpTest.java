package com.ssg.oop.emp.run;

import com.ssg.oop.emp.mode1.vo.Employee;

import java.util.Scanner;

public class EmpTest {
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        String menu = "******* 사원 정보 관리 프로그램 **********\n"
                + "1. 새 사원 정보 입력\n"
                + "2. 사원 정보 삭제\n"
                + "3. 사원정보 출력\n"
                + "0. 끝내기\n"
                + "*************************************\n"
                + "입력 : ";
        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee(); // Employee객체를 대입할 변수
        while (true) {
            System.out.print(menu);
            // 사용자 선택값에 따른 분기처리
            String choice = sc.next();
            switch (choice) {
                case "1":
                    employee.empInput();
                    break;
                case "2":
                    employee = new Employee();
                    break;
                case "3":
                    employee.empOutput();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
