package com.ssg.oop.emp.run;

import com.ssg.oop.emp.model.vo.Employee;

import java.util.Scanner;

public class EmpTest {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        EmpTest empTest = new EmpTest();
        empTest.mainMenu();
    }

    public void mainMenu() {
        Employee e = null;

        String menu = """
                ******* 사원 정보 관리 프로그램 **********
                1. 새 사원 정보 입력
                2. 사원 정보 삭제
                3. 사원정보 출력
                0. 끝내기
                *******************************************
                입력 : """;

        while(true) {
            // 메뉴 출력
            System.out.print(menu);

            // 메뉴 선택
            String choice = sc.next();
            switch(choice) {
                case "1":
                    System.out.println("새 사원 정보를 입력합니다.");
                    e = new Employee();
                    e.empInput();
                    break;
                case "2":
                    // 유효성 검사, 사원 정보를 입력하지 않고 삭제를 할 수 없다.
                    if(e == null) {
                        System.out.println("사원 정보를 입력하지 않아 삭제를 할 수 없습니다. 먼저 사원 정보를 입력해주세요.");
                    } else{
                        e = null;
                        System.out.println("사원 정보가 삭제되었습니다.");
                    }
                    break;
                case "3":
                    // 유효성 검사, 사원 정보를 입력하지 않고 출력을 할 수 없다.
                    if(e == null) {
                        System.out.println("사원 정보를 입력하지 않아 출력을 할 수 없습니다. 먼저 사원 정보를 입력해주세요.");
                    }else {
                        System.out.println("사원 정보를 출력합니다.");
                        e.empOutput();
                    }
                    break;
                case "0":
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }
    }
}
