package com.sgg.oop.emp.run;

import com.sgg.oop.emp.model.vo.Employee;

import java.util.Scanner;

public class EmpTest {
    public static void main(String[] args) {

        EmpTest empTest = new EmpTest();
        empTest.mainMenu();

    }

    Scanner sc = new Scanner(System.in);

    private void mainMenu() {
        String menu = "******** 사원 정보 관리 프로그램 **********\n"
                        + "1. 새 사원 정보 입력\n"
                        + "2. 사원 정보 삭제\n"
                        + "3. 사원 정보 출력\n"
                        + "9. 끝내기\n"
                        + "*****************************************"
                        + "입력 : ";

        Employee e = null;

        while (true) {
            System.out.println(menu);
            int choice = sc.nextInt();
            switch(choice) {
                case 1 :
                    e = new Employee();
                    e.empInput();
                    break;
                case 2 :
                    if(e != null) {
                        e = null;
                        System.out.println("사원 정보가 삭제되었습니다\n");
                }
            }

        }
    }
}
