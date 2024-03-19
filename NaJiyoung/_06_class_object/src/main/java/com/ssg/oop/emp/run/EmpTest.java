package com.ssg.oop.emp.run;

import com.ssg.oop.emp.model.vo.Employee;

import java.util.Scanner;

public class EmpTest {
    public static void main(String[] args) {
        EmpTest emptest = new EmpTest();
        emptest.mainMenu();
    }

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        String menu = "******* 사원 정보 관리 프로그램 **********\n"
                + "1. 새 사원 정보 입력\n"
                + "2. 사원 정보 삭제\n"
                + "3. 사원정보 출력\n"
                + "9. 끝내기\n"
                + "*************************************\n"
                + "입력 : ";

        Employee e = null; // Employee객체를 대입할 변수
        int choice = 0;  // 선택 번호
        while (true) {
            System.out.print(menu);
            // 사용자 선택값에 따른 분기처리
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    e = new Employee();
                    e.empInput();
                    System.out.println("새 사원 정보를 입력하였습니다.");
                    break;
                case 2:
                    if(e!=null) {
                        e = null;
                        System.out.println("사원 정보를 삭제하였습니다.");
                    }
                    else
                        System.out.println("사원 정보를 입력해야 합니다.");
                    break;
                case 3:
                    if(e!=null)
                        e.empOutput();
                    else
                        System.out.println("사원 정보를 입력해야 합니다.");
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }

    }
}
