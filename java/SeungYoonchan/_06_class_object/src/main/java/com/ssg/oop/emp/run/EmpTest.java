package com.ssg.oop.emp.run;

import com.ssg.oop.emp.model.vo.Employee;

import java.util.Scanner;

public class EmpTest {
    public void mainMenu() {
        String menu = "******* 사원 정보 관리 프로그램 **********\n" +
                "1. 새 사원 정보 입력\n" +
                "2. 사원 정보 삭제\n" +
                "3. 사원정보 출력\n" +
                "9. 끝내기\n" +
                "*************************************\n" +
                "입력 : ";

        Employee e = null; // 사원 객체 참조 변수
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(menu);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    e = new Employee(); // 새로운 사원 정보를 입력할 new Employee()를 생성
                    e.empInput();
                    break;
                case 2:
                    if(e!=null){
                        e = null; // 사원객체 참조변수에 null 대입
                        System.out.println("사원 정보가 삭제되었습니다.\n");
                    }else{
                        System.out.println("사원 정보가 없습니다.\n");
                    }

                    break;
                case 3:
                    if (e != null) { // 사원 정보가 있다면 출력
                        e.empOutput();
                    } else { //아니라면 정보 없음 출력
                        System.out.println("사원 정보가 없습니다.\n");
                    }
                    break;
                case 9: // return;으로 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    return; // 종료를 하기 때문에 break;가 아닌 return; 사용
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.\n");
            }
        }
    }

    // 프로그램을 시작하는 메인 메서드
    public static void main(String[] args) {
        EmpTest empTest = new EmpTest();
        empTest.mainMenu();
    }
}
