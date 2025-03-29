package com.ssg.oop.emp.run;

import com.ssg.oop.emp.model.vo.Employee;

import java.util.Scanner;

public class EmpTest {
    public static void main(String[] args) {
        EmpTest empTest = new EmpTest();
        empTest.mainMenu();
    }

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        String menu = "******* 사원정보 관리 프로그램 **********\n"
                + "1. 새 사원정보 입력\n"
                + "2. 사원정보 삭제\n"
                + "3. 사원정보 출력\n"
                + "4. 기존 사원정보 수정\n"
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
                    break;
                case 2 :
                    if (e != null) {
                        e = null;
                    } else {
                        System.out.println("저장된 사원 정보가 없습니다!");
                    }
                    break;
                case 3 :
                    if (e != null) {
                        e.empOutput();
                        System.out.println();
                    } else {
                        System.out.println("저장된 사원 정보가 없습니다!");
                    }
                    break;
                case 4 :
                    if (e != null) {
                        modifyMenu(e);
                    } else {
                        System.out.println("저장된 사원 정보가 없습니다!");
                    }
                    break;
                case 0 :
                    return;
            }
        }
    }

    public void modifyMenu(Employee e) {
        Scanner sc = new Scanner(System.in);
        String menu = "******* 사원정보 수정 페이지 **********\n"
                + "1. 이름 수정\n"
                + "2. 나이 수정\n"
                + "3. 성별 수정\n"
                + "4. 핸드폰 번호 수정\n"
                + "5. 주소 수정\n"
                + "0. 끝내기\n"
                + "*************************************\n"
                + "입력 : ";
        while (true) {
            System.out.print(menu);
            // 사용자 선택값에 따른 분기처리
            int input = sc.nextInt();
            switch (input) {
                case 1 :
                    System.out.println("변경할 이름을 입력하세요 : ");
                    String name = sc.next();
                    e.setEmpName(name);
                    System.out.println(name + " - 이름이 수정되었습니다.");
                    break;
                case 2 :
                    System.out.println("변경할 나이를 입력하세요 : ");
                    int age = sc.nextInt();
                    e.setAge(age);
                    System.out.println(age + " - 나이가 수정되었습니다.");
                    break;
                case 3 :
                    System.out.println("변경할 성별을 입력하세요 : ");
                    char gender = sc.next().charAt(0);
                    e.setGender(gender);
                    System.out.println(gender + " - 성별이 수정되었습니다.");
                    break;
                case 4 :
                    System.out.println("변경할 핸드폰 번호를 입력하세요 : ");
                    sc.nextLine();
                    String phone = sc.nextLine();
                    e.setPhone(phone);
                    System.out.println(phone + " - 핸드폰 번호가 수정되었습니다.");
                    break;
                case 5 :
                    System.out.println("변경할 주소를 입력하세요 : ");
                    sc.nextLine();
                    String address = sc.nextLine();
                    e.setAddress(address);
                    System.out.println(address + " - 주소가 수정되었습니다.");
                    break;
                case 0 :
                    return;
            }
        }
    }
}
