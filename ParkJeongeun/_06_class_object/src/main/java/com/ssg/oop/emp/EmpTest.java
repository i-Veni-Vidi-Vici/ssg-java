package com.ssg.oop.emp;

import java.util.Scanner;

public class EmpTest {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        EmpTest empTest = new EmpTest();
        empTest.mainMenu();
    }

    public void mainMenu() {
        String menu = "******* 사원 정보 관리 프로그램 **********\n"
                + "1. 새 사원 정보 입력\n"
                + "2. 사원 정보 삭제\n"
                + "3. 사원정보 출력\n"
                + "0. 끝내기\n"
                + "*************************************\n"
                + "입력 : ";

        Employee e = new Employee(); // Employee객체를 대입할 변수
        while (true) {
            System.out.print(menu);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    e.empInput();
                    break;
                case 2:
                    if (e != null) {
                        e = null;
                        System.out.println("사원정보가 삭제되었습니다.");
                        break;
                    } else {
                        System.out.println("입력된 사원정보가 없습니다. 사원정보를 입력해주세요.");
                        break;
                    }
                case 3:
                    if (e != null) {
                        e.empOutput();
                        break;
                    } else {
                        System.out.println("입력된 사원정보가 없습니다. 사원정보를 입력해주세요.");
                        break;
                    }
                case 0:
                    return;
            }
        }
    }
}
