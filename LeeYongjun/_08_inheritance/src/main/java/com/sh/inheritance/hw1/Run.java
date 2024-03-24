package com.sh.inheritance.hw1;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person person = new Person();
        person.information();

        Student[] student = new Student[3];
        student[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
        student[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
        student[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신학과");

        System.out.println("=== 모든 학생 정보 출력 ===");

        for (Student students : student) {
            System.out.println(students.information());
        }

        System.out.println();

        final int MAX_EMPLOYEE = 10;
        Employee[] employee = new Employee[MAX_EMPLOYEE];
        int count = 0;
        while (true) {
            if (count >= MAX_EMPLOYEE) {
                System.out.println("최대 사원 수를 초과하여 더 이상 추가할 수 없습니다.");
                break;
            }

            System.out.print("사원 이름을 입력하세요: ");
            String name = sc.next();

            System.out.print("사원 나이을 입력하세요: ");
            int age = sc.nextInt();

            System.out.print("사원 신장을 입력하세요: ");
            double height = sc.nextDouble();

            System.out.print("사원 몸무게를 입력하세요: ");
            double weight = sc.nextDouble();

            System.out.print("급여를 입력하세요: ");
            int salary = sc.nextInt();

            System.out.print("부서를 입력하세요: ");
            String dept = sc.next();

            // Employee 객체 생성 및 배열에 추가
            employee[count] = new Employee(name, age, height, weight, salary,dept);
            count++;

            // 추가 입력 여부 확인
            System.out.print("사원 정보를 더 입력하시겠습니까? (y/n): ");
            String input = sc.next();
            if (!input.equalsIgnoreCase("Y")) {
                break;
            }
        }
        sc.close();
        System.out.println();
        System.out.println("=== 입력된 사원 정보 ===");
        for (int i = 0; i < count; i++) {
            System.out.println(employee[i].information());
        }
    }
}

