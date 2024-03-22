package com.sh.ssg.vo;
import java.util.Scanner;

public class EmpTest {
    public static void main(String[] args) {
        EmpTest empTest = new EmpTest();
        empTest.mainMenu();
    }

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);

        String menu = "******* 사원 정보 관리 프로그램 **********\n"
                + "1. 새 사원 정보 입력\n"
                + "2. 사원 정보 삭제\n"
                + "3. 사원정보 출력\n"
                + "0. 끝내기\n"
                + "*************************************\n"
                + "입력 : ";

        Employee e = null; // Employee객체를 대입할 변수


        while (true) {
            System.out.print(menu);
            int option = sc.nextInt();

            // 사용자 선택값에 따른 분기처리
            switch(option){
                case 1:
                    e = new Employee();
                    e.empInput();
                    break;
                case 2:
                    if(e != null) {
                        e=null;
                    }else System.out.println("먼저 사원정보를 입력하세요\n");
                    break;
                case 3:
                    if(e != null) {
                        e.empOutput();
                    }else System.out.println("먼저 사원정보를 입력하세요\n");
                    break;
                case 0: return;
            }
        }
    }
}
