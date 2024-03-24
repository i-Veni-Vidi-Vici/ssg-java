package com.sh.inheritance.hw1.run;

import com.sh.inheritance.hw1.model.dto.Employee;
import com.sh.inheritance.hw1.model.dto.Student;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        // 3명의 학생 정보를 기록할 수 있게 객체 배열 할당
        // 위의 사용데이터 참고하여 3명의 학생 정보 초기화
        // 위의 학생 정보 모두 출력 --> 향상된 for문 이용해서
        Student[] students = new Student[3];

        students[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
        students[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
        students[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");

        for(Student student : students) {
            System.out.println(student.information());
        }

        // 최대 10명의 사원 정보를 기록할 수 있게 배열을 할당
        // 사원들의 정보를 키보드로 계속 입력 받고 --> while(true) 무한 반복문을 통해
        // 계속 추가할 것인지 물어보고, 대소문자 상관없이 ‘y’이면 계속 객체 추가
        // 한 명씩 추가 될 때마다 카운트함
        // 2명 정도의 사원 정보를 입력 받아 객체 배열에 저장
        // 현재 기록된 사원들의 정보를 모두 출력
        Scanner sc = new Scanner(System.in);
        final int MAX_EMP = 10;
        Employee[] employees = new Employee[MAX_EMP];
        int empIndex = 0;

        while(true) {
            System.out.print("이름 : ");
            String name = sc.next();
            System.out.print("나이 : ");
            int age = sc.nextInt();
            System.out.print("신장 : ");
            double height = sc.nextDouble();
            System.out.print("몸무게 : ");
            double weight = sc.nextDouble();
            System.out.print("급여 : ");
            int salary = sc.nextInt();
            System.out.print("부서 : ");
            String dept = sc.next();

            employees[empIndex] = new Employee(name, age, height, weight, salary, dept);
            if(empIndex < 10) {
                System.out.print("계속 추가할까요? (y/n) : ");
                char more = sc.next().toLowerCase().charAt(0);
                if(more == 'y') {
                    empIndex++;
                }else {
                    break;
                }
            }else {
                break;
            }
        }

        for(int i = 0; i <= empIndex; i++) {
            System.out.println(employees[i].information());
        }
    }
}
