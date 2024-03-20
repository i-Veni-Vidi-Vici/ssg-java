package com.ssg.oop.emp.run;

import com.ssg.oop.emp.model.vo.Employee;

import java.util.Scanner;

public class EmpTest {
    public static void main(String[] args) {
        EmpTest empTest = new EmpTest();
        empTest.mainMenu();
//        Employee employee = new Employee();
//        employee.empInput();
    }

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        String menu = "******* 사원 정보 관리 프로그램 **********\n"
                + "1. 새 사원 정보 입력\n"
                + "2. 사원 정보 삭제\n"
                + "3. 사원정보 출력\n"
                + "0. 끝내기\n"
                + "*************************************\n"
                + "입력 : ";
        Employee e = null; // Employee객체를 대입할 변수
        while (true) {
            System.out.print(menu);
            // 사용자 선택값에 따른 분기처리
            int input = sc.nextInt();
            switch (input) {
                case 1 :
                    e = new Employee();
                    e.empInput();
                    continue;
                case 2 :
                    if (e != null) {
                        e = null;
                    } else {
                        System.out.println("저장된 사원 정보가 없습니다!");
                    }
                    continue;
                case 3 :
                    if (e != null) {
                        e.empOutput(e);
                        System.out.println();
                    } else {
                        System.out.println("저장된 사원 정보가 없습니다!");
                    }
                    continue;
                case 0 :
                    return;
            }
        }
    }
}
