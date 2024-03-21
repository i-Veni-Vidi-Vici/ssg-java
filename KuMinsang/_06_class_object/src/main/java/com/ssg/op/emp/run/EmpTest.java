package com.ssg.op.emp.run;
import com.ssg.op.emp.model.vo.Employee;

import java.util.Scanner;

public class EmpTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "******* 사원 정보 관리 프로그램 **********\n"
                + "1. 새 사원 정보 입력\n"
                + "2. 사원 정보 삭제\n"
                + "3. 사원정보 출력\n"
                + "9. 끝내기\n"
                + "*************************************\n"
                + "입력 : ";


        Employee e = null; // Employee객체를 대입할 변수
        while (true) {
            System.out.print(menu);
            // 사용자 선택값에 따른 분기처리
            int select = sc.nextInt();
            switch(select){
                case 1 :
                    e = new Employee();
                    e.empInput();
                    break;
                case 2 :
                    if(e != null){
                        e = null;
                    }else{
                        System.out.println("사원정보가 없습니다");
                    }
                    break;
                case 3 :
                    if(e != null) {
                        e.empOutput();
                    }else{
                        System.out.println("사원정보가 없습니다");
                    }
                    break;
                case 9 :
                    return;
                default :
                    System.out.println("잘못 입력하셨습니다");
                    break;

            }

        }
    }
}
