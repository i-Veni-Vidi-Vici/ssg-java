package com.hw1.run;

import com.hw1.model.dto.Employee;
import com.hw1.model.dto.Person;
import com.hw1.model.dto.Student;

import java.util.Arrays;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[3];
        students[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
        students[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
        students[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");

        for (Student student : students) {
            System.out.println(student.information());
        }

        Employee[] employees = new Employee[10];
        int index = 0;
        abc:
        while (true) {
            System.out.print("> 이름 입력 : ");
            String name = sc.nextLine();
            System.out.print("> 나이 입력 : ");
            int age = sc.nextInt();
            System.out.print("> 신장 입력 : ");
            double height = sc.nextDouble();
            System.out.print("> 몸무게 입력 : ");
            double weight = sc.nextDouble();
            System.out.print("> 급여 입력 : ");
            int salary = sc.nextInt();
            System.out.print("> 부서 입력 : ");
            String dept = sc.nextLine();
            sc.nextLine();

            employees[index++] = new Employee(name, age, height, weight, salary, dept);
            while (true) {
                System.out.print("> 사원정보를 추가로 입력하시겠습니까? (y/n) : ");
                char add = sc.next().charAt(0);
                sc.nextLine();
                if (add == 'y' || add == 'Y') {
                    break;
                } else if (add == 'n' || add == 'N'){
                    break abc;
                } else{
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                    continue;
                }
            }
        }
        for (int i = 0; i < index; i++){
            System.out.println(employees[i].information());
        }
    }
}
