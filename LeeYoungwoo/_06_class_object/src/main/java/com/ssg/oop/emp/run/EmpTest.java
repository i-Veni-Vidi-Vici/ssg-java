package com.ssg.oop.emp.run;

import com.ssg.oop.emp.model1.vo.Employee;

import java.util.Scanner;

public class EmpTest {
    public static void main(String[] args) {
        EmpTest empTest = new EmpTest();
        empTest.mainMenu();
    }

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        String menu = """
                ****** 사원정보 관리 프로그램 ******
                1. 새 사원정보 입력
                2. 사원정보 삭제
                3. 사원정보 출력
                0. 끝내기
                *********************************
                입력 : """;

        Employee e = null;
        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            // 사원정보를 입력하지 않고, 삭제/출력할 수 없다 --> 이거만 해결하면됨!
            switch (choice) {
                case "1" : e = new Employee();  e.empInput(); break;
                case "2" : if(e == null) {
                    System.out.println("> 먼저 회원정보를 입력해주세요...");
                    break;
                }
                    e = null;
                    System.out.println("> 회원정보를 삭제하였습니다..."); break;
                case "3" : if(e == null) {
                    System.out.println("> 먼저 회원정보를 입력해주세요...");
                    break;
                }
                    e = new Employee(); e.empOutput(); break;
                case "0" : return ;
                default:
                    System.out.println("> 잘못 입력하셨습니다...");

            }

        }
    }
}
