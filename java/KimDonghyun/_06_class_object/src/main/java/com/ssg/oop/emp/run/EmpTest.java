package com.ssg.oop.emp.run;

import com.ssg.oop.emp.model.vo.Employee;

import java.util.Scanner;


public class EmpTest {
    //여러메소드에서 사용할 수 있도록 멤버변수로 선언
    Scanner sc = new Scanner(System.in);
    Employee e = null; // Employee객체를 대입할 변수

    public static void main(String[] args) {
        EmpTest t = new EmpTest();
        t.mainMenu();
    }

    public void mainMenu() {
        String menu = """
        ******* 사원 정보 관리 프로그램 **********
        1. 새 사원 정보 입력
        2. 사원 정보 수정
        3. 사원 정보 삭제
        4. 사원정보 출력
        9. 끝내기
        *************************************
        선택하세요 => """;

        int selected = 0;
        // Employee e = null; // Employee객체를 대입할 변수

        while (true) {
            System.out.print(menu);
            selected = sc.nextInt();
            switch (selected) {
                case 1:
                    e = new Employee();
                    e.empInput();
                    break;
                case 2:
                    modifyMenu();
                    break;
                case 3:
                    if(e == null) {
                        System.out.println(">> 먼저 사원정보를 입력하세요.");
                        break;
                    }
                    //사원정보삭제는 참조주소값을 삭제한다.
                    //실제 heap영역의 객체 삭제는 garbage collector가 담당.
                    e = null;
                    break;
                case 4:
                    //사원정보 미입력시 출력하지 않도록함.
                    //NullPointerException 유발
                    if (e == null) {
                        System.out.println(">> 먼저 사원정보를 입력하세요.");
                        break;
                    }
                    e.empOutput();
                    break;
            }
            if (selected == 9) break;
        }

    }

    private void modifyMenu() {
        //전달된 e객체가 null인 경우
        if (e == null) {
            System.out.println("먼저 사원정보를 입력하세요.");
            return;
        }

        String menu = """
        ******* 사원 정보 수정 메뉴 **********
        1. 이름 변경
        2. 급여 변경
        3. 부서 변경
        4. 직급 변경
        9. 이전메뉴로 이동
        *************************************
        선택하세요 => """;

        int selected = 0;
        while (true) {
            System.out.println(menu);
            selected = sc.nextInt();
            switch (selected) {
                case 1:
                    System.out.print("이름 : ");
                    e.setEmpName(sc.next());
                    break;
                case 2:
                    System.out.print("급여 : ");
                    e.setSalary(sc.nextInt());
                    break;
                case 3:
                    System.out.print("부서 : ");
                    e.setDept(sc.next());
                    break;
                case 4:
                    System.out.print("직급 : ");
                    e.setJob(sc.next());
                    break;
            }
            if (selected == 9) return;
        }
    }
}
