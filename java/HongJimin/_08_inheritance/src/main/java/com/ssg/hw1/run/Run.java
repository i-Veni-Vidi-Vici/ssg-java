package com.ssg.hw1.run;

import com.ssg.hw1.model.dto.Employee;
import com.ssg.hw1.model.dto.Student;

import java.sql.Struct;
import java.util.Objects;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Student[] students = new Student[3];

        students[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
        students[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
        students[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");

        System.out.print("""
                =================================================
                    이름    나이    신장    몸무게   학년    전공
                -------------------------------------------------
                """);
        for (Student student : students) {
            System.out.println(student.information());
        }
        System.out.println("=================================================");

        Employee[] employees = new Employee[10];
        Scanner sc = new Scanner(System.in);
        String choice;
        int i = 0;

        while (true) {
            System.out.print("이름 : ");
            String name = sc.next();

            System.out.print("나이 : ");
            int age = sc.nextInt();

            System.out.print("키 : ");
            double height = sc.nextDouble();

            System.out.print("몸무게 : ");
            double weight = sc.nextDouble();

            System.out.print("급여 : ");
            int salary = sc.nextInt();

            System.out.print("부서 : ");
            String dept = sc.next();
            employees[i] = new Employee(name, age, height, weight, salary, dept);

            System.out.print("사원 추가 (Y/N) : ");
            choice = sc.next();
            if (choice.equals("Y") || choice.equals("y")) {
                i++;
            } else {
                break;
            }
        }
        for (Employee employee : employees){
            if(employee == null){break;}
            System.out.println(employee.information());
        }
    }
}

