package com.ssg.oop.emp;

import java.util.Scanner;

public class EmpTest {
    public static void main(String[] args) {
        EmpTest empTest=new EmpTest();
        Employee employee=new Employee();
        empTest.mainMenu();

    }
    public void mainMenu() {
        String menu = "******* 사원 정보 관리 프로그램 **********\n"
                + "1. 새 사원 정보 입력\n"
                + "2. 사원 정보 삭제\n"
                + "3. 사원정보 출력\n"
                + "9. 끝내기\n"
                + "*************************************\n"
                + "입력 : ";

        Employee e = new Employee(); // Employee객체를 대입할 변수

        point :while (true) {

            System.out.print(menu);
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();

            switch (choice)
            {
                case 1 :
                    e.empInput();
                        break;
                case 2 :
                    e=null;
                    break;
                case 3 :
                    e.empOutput();
                    break;
                case 9 :
                    System.out.println("종료합니다");
                    break point;
            }
        }

    }
}
