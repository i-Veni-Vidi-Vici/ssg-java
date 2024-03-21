package com.ssg.oop.emp.model.vo.run;

import java.util.Scanner;

public class EmpTest {
    public static void main(String[] args) {
        Employee employee = new Employee();
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
        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            switch(choice)
            {
                case "1" : Employee.emInput(); break;
                case "2" : Employee.emOutput(); break;
                case "3" : Employee.emOutput(); break;
                case "9" : return;
                default :
                    System.out.println("> 잘못 입력하셨습니다.");
            }
        }

    }
}
