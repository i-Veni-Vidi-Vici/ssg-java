package com.ssg.oop.emp.run;

import com.ssg.oop.emp.model.vo.Employee;

import java.util.Scanner;

public class EmpTest {
    Employee e = null;
    public static void main(String[] args) {
        EmpTest empTest = new EmpTest();
        empTest.mainMenu();
    }

    private void mainMenu() {
        String menu = "******* 사원 정보 관리 프로그램 **********\n"
                + "1. 새 사원 정보 입력\n"
                + "2. 사원 정보 삭제\n"
                + "3. 사원정보 출력\n"
                + "0. 끝내기\n"
                + "*************************************\n"
                + "입력 : ";

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            // 사용자 선택값에 따른 분기처리
            switch(choice) {
                case "1":
                    e = new Employee();
                    e.empInput();
                    break;
                case "2":
                    if(e == null) {
                        System.out.println("사원 정보가 없습니다. 사원 정보를 입력하세요.");
                        break;
                    }else {
                        e = null;
                        break;
                    }
                case "3":
                    if(e == null) {
                        System.out.println("사원 정보가 없습니다. 사원 정보를 입력하세요.");
                        break;
                    }else {
                        e.empOutput();
                        break;
                    }
                case "0": return;
            }
        }
    }
}
