package com.ssg.hw1.run;

import com.ssg.hw1.model.Employee;
import com.ssg.hw1.model.Student;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Student[] std = new Student[3];
        std[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
        std[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
        std[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");
        System.out.println("이름   나이   신장   몸무게   학년   전공");
        for (Student s : std) {
            System.out.println(s.information());
        }

        final int MAX_INDEX = 10;
        int i = 0;
        Scanner sc = new Scanner(System.in);
        Employee[] emp = new Employee[MAX_INDEX];
        while (i < MAX_INDEX) {
            System.out.print("이름 : ");
            String name = sc.next();
            System.out.print("나이 : ");
            int age = sc.nextInt();
            System.out.print("신장 : ");
            Double height = sc.nextDouble();
            System.out.print("몸무게 : ");
            Double weight = sc.nextDouble();
            System.out.print("급여 : ");
            int salary = sc.nextInt();
            System.out.print("부서 : ");
            String dept = sc.next();
            emp[i] = new Employee(name, age, height, weight, salary, dept);

            i++;
            System.out.println("계속 추가하시겠습니까? (y/n) : ");
            char ans = sc.next().charAt(0);
            if (ans != 'y') {
                break;
            }
        }
        System.out.println("이름   나이   신장   몸무게      급여   부서");
        for (Employee e : emp) {
            if (e != null) {
                System.out.println(e.information());
            }
        }
    }
}
