package com.ssg.oop.emp.run;

import com.ssg.oop.emp.mode1.vo.Employee;

import java.util.Scanner;

/**
 * 실행용 클래스
 *
 */
public class EmpTest {
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

        Scanner sc = new Scanner(System.in);
        Employee employee = null;

        Employee e = null; // Employee객체를 대입할 변수

        while (true) {
            System.out.print(menu);
            // 사용자 선택값에 따른 분기처리
            String num = sc.nextLine(); 
            switch (num){
                case "1":
                if(employee == null) {
                    employee = new Employee(); // 새로운 객체 생성
                        employee.empInput();
                         // 정보입력
                } else {
                    System.out.println("이미 입력되어있습니다.");
                }break;

                case "2" :
                    if (employee != null){
                        employee = e; // 객체에 null값 넣기, 삭제
                } else{
                        System.out.println("입력된 사원이 없습니다. 사원을 입력해주세요");
                    }break;

                case "3" :
                    if (employee != null) {
                    employee.empOutput(); // 출력
                } else {
                    System.out.println("출력할 사원이 없습니다. 사원을 입력해주세요.");
                    }
                    break;

                case "0":
                    System.out.println("프로그램종료");
                    return;

                default:
                    System.out.println("잘못입력했습니다.");
                    break;
            }
        }

    }


}
