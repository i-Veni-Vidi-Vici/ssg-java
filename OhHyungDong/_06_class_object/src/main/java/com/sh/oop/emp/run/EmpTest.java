package com.sh.oop.emp.run;

import com.ssg.oop.emp.model.vo.Employee;

import java.util.Scanner;

public class EmpTest {
    public static void main(String[] args) {
    mainMenu();


    }

    public static void mainMenu() {

        String menu = "******* 사원 정보 관리 프로그램 **********\n"
                + "1. 새 사원 정보 입력\n"
                + "2. 사원 정보 삭제\n"
                + "3. 사원정보 출력\n"
                + "9. 끝내기\n"
                + "*************************************\n"
                + "입력 : ";

        Employee e = new Employee();// Employee객체를 대입할 변수

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            switch(choice){
                case "1" : e.empInput(e); break;
                case "2" : e.empRemove(e); break;
                case "3" : e.empOutput(e); break;

            }
            System.out.print(menu);
            // 사용자 선택값에 따른 분기처리
        }

    }
}
//System.out.print(menu);
//String choice = sc.next();
//            switch (choice){
//        case "1" : driver.startEngine();break;
//        case "2" : driver.accelerate();break;
//        case "3" : driver.brake();break;
//        case "4" : driver.stopEngine();break;
//        case "0" : return; // 현재 메소드를 호출한 곳으로 리턴 - 하위 코드 실행 x
//default:
////        System.out.println("> 잘못입력하셨습니다.");
