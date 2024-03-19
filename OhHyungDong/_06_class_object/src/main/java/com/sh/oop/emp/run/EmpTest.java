package com.sh.oop.emp.run;

import com.ssg.oop.emp.model.vo.Employee;

import java.util.Scanner;

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
                + "9. 끝내기\n"
                + "*************************************\n"
                + "입력 : ";

        Employee e = null;
        while (true) {
            System.out.print(menu); //메뉴

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            switch(choice){
                case "1" :
                    e = new Employee();
                    e.empInput(); break;
                case "2" :
                    if(e == null) System.out.println("삭제 할 정보가 없습니다.");
                    else{
                        e = null;
                        System.out.println("사원정보가 삭제되었습니다.");
                    } break;
                case "3" :
                    if(e==null) System.out.println("출력 할 정보가 없습니다.");
                    else e.empOutput(); break;

                case "9" :
                    System.out.println("프로그램을 종료합니다."); return;
            }

        }

    }
}
